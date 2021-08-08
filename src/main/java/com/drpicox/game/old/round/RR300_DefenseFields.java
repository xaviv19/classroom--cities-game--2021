package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR300_DefenseFields extends EachPlayerSquareRoundRule {

    public RR300_DefenseFields(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(Player player, int square, CardListFilter<Card> allCards) {
        var defenses = allCards.ofOwner(player).atSquare(square).ofType("knight");
        var attackers = allCards.ofOtherOwnerThan(player).atPile(player, square).ofType("knight");

        var killedDefenses = Math.floorDiv(attackers.count(), 2);
        var killedAttackers = defenses.count() * 2;
        defenses.limit(killedDefenses).forEach(cardController::discardCard);
        attackers.limit(killedAttackers).forEach(cardController::discardCard);
    }
}
