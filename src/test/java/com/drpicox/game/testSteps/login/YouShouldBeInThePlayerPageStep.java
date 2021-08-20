package com.drpicox.game.testSteps.login;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.player.PlayerTestView;

import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldBeInThePlayerPageStep extends AbstractPostLineStep {

    private PlayerTestView playerTestView;

    public YouShouldBeInThePlayerPageStep(PlayerTestView playerTestView) {
        this.playerTestView = playerTestView;
    }

    @Override
    protected String getRegex() {
        return "You should be in the player page";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = playerTestView.getPlayerName();
        var token = playerTestView.getToken();

        assertThat(playerName).isNotEmpty();
        assertThat(token).isNotEmpty();
    }
}
