package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.cards.Positions;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_EventFarmerProduceHay extends EachPlayerSquareRoundRule {

    public RR200_EventFarmerProduceHay(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(Player player, int square, CardListFilter<Card> allCards) {
        var events = allCards.atPile("event").ofType("event").ofName("grain");
        var farmers = allCards.atSquare(player, square).ofType("worker").ofName("farmer");
        events.forEach(event -> farmers.forEach(farmer ->
                cardController.pickCard(player, Positions.HAND, "material", "hay")
        ));
    }
}
