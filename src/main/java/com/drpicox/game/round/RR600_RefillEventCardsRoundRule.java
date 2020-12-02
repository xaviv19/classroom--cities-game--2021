package com.drpicox.game.round;

import com.drpicox.game.cards.CardController;
import com.drpicox.game.cards.Positions;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR600_RefillEventCardsRoundRule implements RoundRule {

    private final CardController cardController;
    private final PlayerController playerController;

    public RR600_RefillEventCardsRoundRule(CardController cardController, PlayerController playerController) {
        this.cardController = cardController;
        this.playerController = playerController;
    }

    @Override
    public void run(Game game) {
        var allCards = cardController.findByGame(game);
        var players = playerController.findByGame(game);

        for (var player: players)
            pickEventCards(player, allCards.ofOwner(player).atHand().ofType("event").count());

    }

    private void pickEventCards(Player player, int eventCardsCount) {
        if (eventCardsCount < 3)
            cardController.pickCard(player, Positions.HAND, "event");
    }
}
