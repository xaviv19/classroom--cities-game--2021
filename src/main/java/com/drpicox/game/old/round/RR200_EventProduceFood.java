package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.Player;
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

    private void balanceProductionAccordingSocialism(Game game, java.util.List<Player> players, HashMap<Player, Integer> productions) {
        if (game.getScenario().getInt("socialism") == 0) return;

        var luckyPlayer = getLuckyPlayer(players);
        var unluckyPlayer = getUnluckyPlayer(players);

        if (luckyPlayer.getTotalReceivedFoodCount() <= unluckyPlayer.getTotalReceivedFoodCount()) return;

        var luckyProduction = productions.get(luckyPlayer);
        var unluckyProduction = productions.get(unluckyPlayer);
        if (!(luckyProduction > 1 && unluckyProduction == 0)) return;

        productions.put(luckyPlayer, luckyProduction - 1);
        productions.put(unluckyPlayer, 1);

        game.sendMessageToAllPlayers("Socialism rules, one food from "+luckyPlayer.getName()+" goes to " + unluckyPlayer.getName());
    }

    private Player getLuckyPlayer(java.util.List<Player> players) {
        var luckyCount = 0;
        for (var player: players) {
            var count = player.getTotalReceivedFoodCount();
            if (count > luckyCount) {
                luckyCount = count;
            }
        }

        return pickRandomPlayerWithTotalReceivedFoodCount(players, luckyCount);
    }

    private Player getUnluckyPlayer(java.util.List<Player> players) {
        var unluckyCount = Integer.MAX_VALUE;
        for (var player: players) {
            var count = player.getTotalReceivedFoodCount();
            if (count < unluckyCount) {
                unluckyCount = count;
            }
        }

        return pickRandomPlayerWithTotalReceivedFoodCount(players, unluckyCount);
    }

    private Player pickRandomPlayerWithTotalReceivedFoodCount(List<Player> players, int count) {
        var list = players.stream().filter(p -> p.getTotalReceivedFoodCount() == count).collect(Collectors.toList());

        return randomPlayerPicker.pickOne(list);
    }

    private HashMap<Player, Integer> countProducedFoodCards(CardListFilter<Card> allCards, java.util.List<Player> players) {
        var productions = new HashMap<Player, Integer>();
        for (var player: players) {
            productions.put(player, countProducedFoodCards(player, allCards));
        }
        return productions;
    }

    private int countProducedFoodCards(Player player, CardListFilter<Card> allCards) {
        var sum = 0;
        for (var square = 1; square <= 5; square++)
            sum += countProducedFoodCardsBySquare(player, square, allCards);
        return sum;
    }


    private int countProducedFoodCardsBySquare(Player player, int square, CardListFilter<Card> allCards) {
        var fields = allCards.atSquare(player, square).ofType("field");
        if (fields.isEmpty()) return 0;

        var name = fields.getOne().getName();
        var eventCards = allCards.atPile("event").ofName(name);
        return eventCards.count();
    }
}
