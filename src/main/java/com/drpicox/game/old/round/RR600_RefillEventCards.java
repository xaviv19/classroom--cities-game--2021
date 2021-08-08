package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR600_RefillEventCards implements RoundRule {

    private final CardController cardController;
    private final PlayerController playerController;

    public RR600_RefillEventCards(CardController cardController, PlayerController playerController) {
        this.cardController = cardController;
        this.playerController = playerController;
    }

    @Override
    public void run(Game game) {
        var scenario = game.getScenario();
        var allCards = cardController.findByGame(game);
        var players = playerController.findByGame(game);
        var limit = scenario.getInt("limit.hand.event");

        for (var player: players)
            pickEventCards(player, allCards.ofOwner(player).atHand().ofType("event").count(), limit);

    }

    private void pickEventCards(Player player, int eventCardsCount, int limit) {
        if (eventCardsCount < limit)
            cardController.pickCard(player, Positions.HAND, "event");
    }
}
