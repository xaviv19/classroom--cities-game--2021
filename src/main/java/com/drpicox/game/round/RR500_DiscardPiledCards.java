package com.drpicox.game.round;

import com.drpicox.game.cards.CardController;
import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class RR500_DiscardPiledCards implements RoundRule {

    private final CardController cardController;

    public RR500_DiscardPiledCards(CardController cardController) {
        this.cardController = cardController;
    }

    @Override
    public void run(Game game) {
        var piledCards = cardController.findByGame(game).atAnyPile();
        for (var card: piledCards)
            cardController.discardCard(card);
    }
}
