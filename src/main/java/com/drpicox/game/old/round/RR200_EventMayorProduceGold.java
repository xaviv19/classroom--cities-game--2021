package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_EventMayorProduceGold extends EachPlayerSquareRoundRule {

    public RR200_EventMayorProduceGold(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        var squareCards = allCards.atSquare(oldPlayer, square);
        var fields = squareCards.ofType("field");
        if (fields.isEmpty()) return;
        var fieldName = fields.getOne().getName();

        var events = allCards.atPile("event").ofType("event").ofName(fieldName);
        if (events.isEmpty()) return;

        var townhalls = squareCards.ofType("building").ofName("townhall");
        if (townhalls.isEmpty()) return;

        var mayors = squareCards.ofType("worker").ofName("mayor");
        if (mayors.isEmpty()) return;

        cardController.pickCard(oldPlayer, Positions.HAND, "material", "gold");
    }
}
