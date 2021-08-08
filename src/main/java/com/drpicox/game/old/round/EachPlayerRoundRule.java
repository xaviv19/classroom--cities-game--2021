package com.drpicox.game.old.round;

import com.drpicox.game.old.cards.Card;
import com.drpicox.game.old.cards.CardController;
import com.drpicox.game.old.cards.CardListFilter;
import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.OldPlayer;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public abstract class EachPlayerRoundRule implements RoundRule {

    protected final PlayerController playerController;
    protected final CardController cardController;

    public EachPlayerRoundRule(PlayerController playerController, CardController cardController) {
        this.playerController = playerController;
        this.cardController = cardController;
    }

    @Override
    public void run(Game game) {
        var allCards = cardController.findByGame(game);
        var players = playerController.findByGame(game);

        for (var player: players)
            runPlayer(player, allCards);
    }

    protected abstract void runPlayer(OldPlayer oldPlayer, CardListFilter<Card> allCards);

}
