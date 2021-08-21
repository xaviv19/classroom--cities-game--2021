package com.drpicox.game.testSteps.player;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThePlayerShouldBeStep extends AbstractPostLineStep {

    private final PlayerTestView playerTestView;

    public ThePlayerShouldBeStep(PlayerTestView playerTestView) {
        this.playerTestView = playerTestView;
    }

    @Override
    protected String getRegex() {
        return "The player should be \"([^\"]*)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];

        assertThat(playerTestView.getPlayerName()).isEqualTo(playerName);
    }
}
