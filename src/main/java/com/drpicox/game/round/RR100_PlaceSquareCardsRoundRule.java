package com.drpicox.game.round;

import com.drpicox.game.cards.Card;
import com.drpicox.game.cards.CardController;
import com.drpicox.game.cards.CardListFilter;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR100_PlaceSquareCardsRoundRule extends EachPlayerSquareRoundRule {

    public RR100_PlaceSquareCardsRoundRule(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(Player player, int square, CardListFilter<Card> allCards) {
        allCards.ofOwner(player).atPile(player, square).forEach(card -> {
            cardController.moveCardToSquare(card, square);
        });
    }
}
