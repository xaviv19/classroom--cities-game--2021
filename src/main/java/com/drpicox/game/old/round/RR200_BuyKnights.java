package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_BuyKnights extends EachPlayerRoundRule {

    public RR200_BuyKnights(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    protected void runPlayer(OldPlayer oldPlayer, CardListFilter<Card> allCards) {
        var ofOwner = allCards.ofOwner(oldPlayer);
        var foods = ofOwner.atPile("buy-knight").ofType("food");
        var knights = ofOwner.atHand().ofType("knight");

        var count = Math.floorDiv(foods.count(), 2);
        // K + c <= 5; c <= 5 - K
        count = Math.min(count, 5 - knights.count());
        for (var i = 0; i < count; i++)
            cardController.pickCard(oldPlayer, Positions.HAND, "knight");

        var cost = count * 2;
        foods.limit(cost).forEach(cardController::discardCard);
    }


}
