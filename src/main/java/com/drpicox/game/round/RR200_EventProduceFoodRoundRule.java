package com.drpicox.game.round;

import com.drpicox.game.cards.Card;
import com.drpicox.game.cards.CardController;
import com.drpicox.game.cards.CardListFilter;
import com.drpicox.game.cards.Positions;
import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;

@Component
public class RR200_EventProduceFoodRoundRule implements RoundRule {

    private final CardController cardController;

    public RR200_EventProduceFoodRoundRule(CardController cardController) {
        this.cardController = cardController;
    }

    @Override
    public void run(Game game) {
        var allCards = cardController.findByGame(game);

        var playedFoodEvents = allCards.atPile("event");
        var playersFields = allCards.atAnySquare().ofType("field");

        for (var event: playedFoodEvents)
            pickFoodForField(event, playersFields);
    }

    private void pickFoodForField(Card event, CardListFilter<Card> playersFields) {
        var fields = playersFields.ofSameName(event);

        for (var field: fields)
            pickFoodForField(field);
    }

    private void pickFoodForField(Card field) {
        var owner = field.getOwner();
        cardController.pickCard(owner, Positions.HAND, "food");
    }
}
