package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR600_AtLeastOneField extends EachPlayerRoundRule {

    public RR600_AtLeastOneField(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    protected void runPlayer(OldPlayer oldPlayer, CardListFilter<Card> allCards) {
        var fields = allCards.ofOwner(oldPlayer).ofType("field").atAnySquare();

        if (fields.isEmpty())
            cardController.pickCard(oldPlayer, 1, "field");
    }


}
