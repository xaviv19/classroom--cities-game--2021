package com.drpicox.game.round;

import com.drpicox.game.cards.Card;
import com.drpicox.game.cards.CardController;
import com.drpicox.game.cards.CardListFilter;
import com.drpicox.game.cards.Positions;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RR200_EventProduceFood implements RoundRule {

    private final PlayerController playerController;
    private final CardController cardController;

    public RR200_EventProduceFood(PlayerController playerController, CardController cardController) {
        this.playerController = playerController;
        this.cardController = cardController;
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

        Player unluckyPlayer = getUnluckyPlayer(players);
        Player luckyPlayer = getLuckyPlayer(players);

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
        var luckyPlayer = players.get(0);
        for (var player: players) {
            var count = player.getTotalReceivedFoodCount();
            if (count > luckyCount) {
                luckyCount = count;
                luckyPlayer = player;
            }
        }
        return luckyPlayer;
    }

    private Player getUnluckyPlayer(java.util.List<Player> players) {
        var unluckyCount = Integer.MAX_VALUE;
        var unluckyPlayer = players.get(0);
        for (var player: players) {
            var count = player.getTotalReceivedFoodCount();
            if (count < unluckyCount) {
                unluckyCount = count;
                unluckyPlayer = player;
            }
        }
        return unluckyPlayer;
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
