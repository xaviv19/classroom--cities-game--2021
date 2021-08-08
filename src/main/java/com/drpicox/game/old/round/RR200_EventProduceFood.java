package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import com.drpicox.game.old.players.RandomPlayerPicker;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RR200_EventProduceFood implements RoundRule {

    private final PlayerController playerController;
    private final CardController cardController;
    private final RandomPlayerPicker randomPlayerPicker;

    public RR200_EventProduceFood(PlayerController playerController, CardController cardController, RandomPlayerPicker randomPlayerPicker) {
        this.playerController = playerController;
        this.cardController = cardController;
        this.randomPlayerPicker = randomPlayerPicker;
    }

    @Override
    public void run(Game game) {
        var allCards = cardController.findByGame(game);
        var players = playerController.findByGame(game);

        var productions = countProducedFoodCards(allCards, players);
        balanceProductionAccordingSocialism(game, players, productions);

        for (var player: players) {
            for (var i = 0; i < productions.get(player); i++)
                cardController.pickCard(player, Positions.HAND, "food");
        }
    }

    private void balanceProductionAccordingSocialism(Game game, java.util.List<OldPlayer> oldPlayers, HashMap<OldPlayer, Integer> productions) {
        if (game.getScenario().getInt("socialism") == 0) return;

        var luckyPlayer = getLuckyPlayer(oldPlayers);
        var unluckyPlayer = getUnluckyPlayer(oldPlayers);

        if (luckyPlayer.getTotalReceivedFoodCount() <= unluckyPlayer.getTotalReceivedFoodCount()) return;

        var luckyProduction = productions.get(luckyPlayer);
        var unluckyProduction = productions.get(unluckyPlayer);
        if (!(luckyProduction > 1 && unluckyProduction == 0)) return;

        productions.put(luckyPlayer, luckyProduction - 1);
        productions.put(unluckyPlayer, 1);

        game.sendMessageToAllPlayers("Socialism rules, one food from "+luckyPlayer.getName()+" goes to " + unluckyPlayer.getName());
    }

    private OldPlayer getLuckyPlayer(java.util.List<OldPlayer> oldPlayers) {
        var luckyCount = 0;
        for (var player: oldPlayers) {
            var count = player.getTotalReceivedFoodCount();
            if (count > luckyCount) {
                luckyCount = count;
            }
        }

        return pickRandomPlayerWithTotalReceivedFoodCount(oldPlayers, luckyCount);
    }

    private OldPlayer getUnluckyPlayer(java.util.List<OldPlayer> oldPlayers) {
        var unluckyCount = Integer.MAX_VALUE;
        for (var player: oldPlayers) {
            var count = player.getTotalReceivedFoodCount();
            if (count < unluckyCount) {
                unluckyCount = count;
            }
        }

        return pickRandomPlayerWithTotalReceivedFoodCount(oldPlayers, unluckyCount);
    }

    private OldPlayer pickRandomPlayerWithTotalReceivedFoodCount(List<OldPlayer> oldPlayers, int count) {
        var list = oldPlayers.stream().filter(p -> p.getTotalReceivedFoodCount() == count).collect(Collectors.toList());

        return randomPlayerPicker.pickOne(list);
    }

    private HashMap<OldPlayer, Integer> countProducedFoodCards(CardListFilter<Card> allCards, java.util.List<OldPlayer> oldPlayers) {
        var productions = new HashMap<OldPlayer, Integer>();
        for (var player: oldPlayers) {
            productions.put(player, countProducedFoodCards(player, allCards));
        }
        return productions;
    }

    private int countProducedFoodCards(OldPlayer oldPlayer, CardListFilter<Card> allCards) {
        var sum = 0;
        for (var square = 1; square <= 5; square++)
            sum += countProducedFoodCardsBySquare(oldPlayer, square, allCards);
        return sum;
    }


    private int countProducedFoodCardsBySquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        var fields = allCards.atSquare(oldPlayer, square).ofType("field");
        if (fields.isEmpty()) return 0;

        var name = fields.getOne().getName();
        var eventCards = allCards.atPile("event").ofName(name);
        return eventCards.count();
    }
}
