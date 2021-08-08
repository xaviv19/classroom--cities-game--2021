package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR300_DefenseFields extends EachPlayerSquareRoundRule {

    public RR300_DefenseFields(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        var defenses = allCards.ofOwner(oldPlayer).atSquare(square).ofType("knight");
        var attackers = allCards.ofOtherOwnerThan(oldPlayer).atPile(oldPlayer, square).ofType("knight");

        var killedDefenses = Math.floorDiv(attackers.count(), 2);
        var killedAttackers = defenses.count() * 2;
        defenses.limit(killedDefenses).forEach(cardController::discardCard);
        attackers.limit(killedAttackers).forEach(cardController::discardCard);
    }
}
