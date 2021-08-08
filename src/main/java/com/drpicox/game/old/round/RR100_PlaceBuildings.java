package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.Player;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR100_PlaceBuildings extends EachPlayerSquareRoundRule {

    public RR100_PlaceBuildings(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(Player player, int square, CardListFilter<Card> allCards) {
        var buildings = allCards.atSquare(player, square).ofType("building");
        buildings.forEach(w -> cardController.moveCardToSquare(w, square));
    }
}
