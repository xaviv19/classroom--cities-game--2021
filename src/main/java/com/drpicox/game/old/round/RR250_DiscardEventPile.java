package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.games.Game;
import org.springframework.stereotype.Component;

@Component
public class RR250_DiscardEventPile implements RoundRule {

    private CardController cardController;

    public RR250_DiscardEventPile(CardController cardController) {
        this.cardController = cardController;
    }

    @Override
    public void run(Game game) {
        cardController.findByGame(game).atPile("event").forEach(cardController::discardCard);
    }
}
