package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR400_DestroyFields extends EachPlayerSquareRoundRule {

    public RR400_DestroyFields(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        allCards.ofOwner(oldPlayer).atSquare(square).stream().findAny().ifPresent(field -> {
            allCards.atPile(oldPlayer, square).ofType("knight").stream().findAny().ifPresent(x ->
                cardController.discardCard(field)
            );
        });
        allCards.atPile(oldPlayer, square).ofType("knight").forEach(cardController::discardCard);
    }
}
