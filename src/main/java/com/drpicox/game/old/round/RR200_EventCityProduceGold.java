package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_EventCityProduceGold extends EachPlayerSquareRoundRule {

    public RR200_EventCityProduceGold(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        var squareCards = allCards.atSquare(oldPlayer, square);
        var cities = squareCards.ofType("building").ofName("city");
        var fields = squareCards.ofType("field");

        fields.forEach(field -> {
            var eventName = field.getName();
            var events = allCards.atPile("event").ofType("event").ofName(eventName);
            events.forEach(event -> cities.forEach(city ->
                    cardController.pickCard(oldPlayer, Positions.HAND, "material", "gold")
            ));
        });
    }
}
