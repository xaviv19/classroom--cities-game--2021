package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.players.api.NewPlayerForm;
import com.drpicox.game.players.api.PlayersApi;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ThereIsThePlayerWithPasswordStep extends AbstractPostLineStep {

    private PlayersApi playersApi;

    public ThereIsThePlayerWithPasswordStep(PlayersApi playersApi) {
        this.playersApi = playersApi;
    }

    @Override
    protected String getRegex() {
        return "there is the player \"([^\"]+)\" with password \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        var password = match[2];

        playersApi.newPlayer(new NewPlayerForm(playerName, password));
    }
}
