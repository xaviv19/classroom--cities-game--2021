package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR200_EventDeal implements RoundRule {

    protected final PlayerController playerController;
    protected final CardController cardController;

    public RR200_EventDeal(PlayerController playerController, CardController cardController) {
        this.playerController = playerController;
        this.cardController = cardController;
    }

    @Override
    public void run(Game game) {
        var allCards = cardController.findByGame(game);
        var deal = allCards.atPile("event").ofType("event").ofName("deal");
        if (deal.isEmpty()) return;

        var players = playerController.findByGame(game);
        var maxCountPlayer = getPlayerWithMoreMaterialCards(allCards, players);
        stealGoldCards(allCards, players, maxCountPlayer);

    }

    private OldPlayer getPlayerWithMoreMaterialCards(CardListFilter<Card> allCards, java.util.List<OldPlayer> oldPlayers) {
        var maxCount = 0;
        var maxCountPlayer = oldPlayers.get(0);
        for (var player: oldPlayers) {
            var count = allCards.ofOwner(player).atHand().ofType("material").count();
            if (count > maxCount) {
                maxCount = count;
                maxCountPlayer = player;
            }
        }
        return maxCountPlayer;
    }

    private void stealGoldCards(CardListFilter<Card> allCards, java.util.List<OldPlayer> oldPlayers, OldPlayer newOwner) {
        for (var player: oldPlayers) {
            var golds = allCards.ofOwner(player).atHand().ofType("material").ofName("gold");
            golds.forEach(g -> cardController.stealCard(newOwner, g));
        }
    }
}
