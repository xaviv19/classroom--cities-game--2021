package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR300_PlagueMasacre extends EachPlayerSquareRoundRule {

    public RR300_PlagueMasacre(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(Player player, int square, CardListFilter<Card> allCards) {
        var squareCards =  allCards.ofOwner(player).atSquare(square);
        var plagues = squareCards.ofType("event").ofName("plague");
        if (plagues.isEmpty()) return;

        var knights = squareCards.ofType("knight");
        var count = knights.count();
        var kills = (count + 1) / 2;

        knights.limit(kills).forEach(c -> cardController.discardCard(c));
    }
}
