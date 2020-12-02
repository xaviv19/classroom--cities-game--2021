package com.drpicox.game.round;

import com.drpicox.game.cards.Card;
import com.drpicox.game.cards.CardController;
import com.drpicox.game.cards.CardListFilter;
import com.drpicox.game.players.Player;
import com.drpicox.game.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_BuyFieldRoundRule extends EachPlayerRoundRule {

    public RR200_BuyFieldRoundRule(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayer(Player player, CardListFilter<Card> allCards) {
        var ofOwner = allCards.ofOwner(player);
        var fields = ofOwner.atAnySquare().ofType("field");
        var foods = ofOwner.atPile("buy-field").ofType("food");

        var required = computeRequiredFood(fields.count());
        if (required < 0) return;
        if (foods.count() < required) return;
        var freeSquare = findFreeSquare(fields);
        cardController.pickCard(player, freeSquare, "field");
    }

    private int findFreeSquare(CardListFilter fields) {
        for (var square = 1; square < 5; square++)
            if (fields.atSquare(square).isEmpty()) return square;

        return 5;
    }

    private int computeRequiredFood(int count) {
        switch (count) {
            case 2: return 2;
            case 3: return 4;
            case 4: return 6;
            default: return 9;
        }
    }
}
