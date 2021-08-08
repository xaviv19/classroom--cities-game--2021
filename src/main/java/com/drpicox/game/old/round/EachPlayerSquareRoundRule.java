package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;

public abstract class EachPlayerSquareRoundRule extends EachPlayerRoundRule {

    public EachPlayerSquareRoundRule(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    protected void runPlayer(Player player, CardListFilter<Card> allCards) {
        for (var square = 1; square <= 5; square++)
            runPlayerSquare(player, square, allCards);
    }

    protected abstract void runPlayerSquare(Player player, int square, CardListFilter<Card> allCards);


}
