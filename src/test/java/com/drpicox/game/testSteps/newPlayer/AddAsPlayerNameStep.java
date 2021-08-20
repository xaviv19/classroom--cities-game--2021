package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class AddAsPlayerNameStep extends AbstractPostLineStep {

    private NewPlayerTestView newPlayerTestView;

    public AddAsPlayerNameStep(NewPlayerTestView newPlayerTestView) {
        this.newPlayerTestView = newPlayerTestView;
    }

    @Override
    protected String getRegex() {
        return "Add \"([^\"]+)\" as player name";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var playerName = match[1];
        newPlayerTestView.addPlayerName(playerName);
    }
}
