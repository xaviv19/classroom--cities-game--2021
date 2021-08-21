package com.drpicox.game.testSteps.listGames;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class JoinOnTheGameStep extends AbstractPostLineStep {

    private final PlayerTestView playerTestView;
    private final ListGamesTestView listGamesTestView;

    public JoinOnTheGameStep(PlayerTestView playerTestView, ListGamesTestView listGamesTestView) {
        this.playerTestView = playerTestView;
        this.listGamesTestView = listGamesTestView;
    }

    @Override
    protected String getRegex() {
        return "Join on the game \"([^\"]+)\" and creator \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var gameName = match[1];
        var creatorName = match[2];

        listGamesTestView.join(gameName, creatorName);
    }
}
