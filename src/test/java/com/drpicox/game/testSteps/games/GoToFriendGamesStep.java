package com.drpicox.game.testSteps.games;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class GoToFriendGamesStep extends AbstractPostLineStep {

    private final PlayerTestView playerTestView;
    private final GamesTestView gamesTestView;

    public GoToFriendGamesStep(PlayerTestView playerTestView, GamesTestView gamesTestView) {
        this.playerTestView = playerTestView;
        this.gamesTestView = gamesTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to friend games";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var friendName = playerTestView.getFriendName();
        gamesTestView.fetch(friendName);
    }
}
