package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR500_PlagueSpreadsOrDies extends EachPlayerSquareRoundRule {

    public RR500_PlagueSpreadsOrDies(PlayerController playerController, CardController cardController) {
        super(playerController, cardController);
    }

    @Override
    protected void runPlayerSquare(OldPlayer oldPlayer, int square, CardListFilter<Card> allCards) {
        var squareCards =  allCards.ofOwner(oldPlayer).atSquare(square);
        var plagues = squareCards.ofType("event").ofName("plague");
        if (plagues.isEmpty()) return;

        var knights = squareCards.ofType("knight");
        if (knights.count() > 0) return;

        var nextSquare = square + 1;
        boolean thereAreNoKinghts = areThereNoKinghts(oldPlayer, allCards, nextSquare);
        if (thereAreNoKinghts) killThePlague(plagues);
        else spreadThePlague(plagues, nextSquare);
    }

    private boolean areThereNoKinghts(OldPlayer oldPlayer, CardListFilter<Card> allCards, int nextSquare) {
        var nextKnights = allCards.ofOwner(oldPlayer).atSquare(nextSquare);
        var thereAreNoKinghts = nextKnights.isEmpty();
        return thereAreNoKinghts;
    }

    private void killThePlague(CardListFilter<Card> plagues) {
        plagues.forEach(c -> cardController.discardCard(c));
    }

    private void spreadThePlague(CardListFilter<Card> plagues, int nextSquare) {
        plagues.forEach(c -> cardController.moveCardToSquare(c, nextSquare));
    }

}
