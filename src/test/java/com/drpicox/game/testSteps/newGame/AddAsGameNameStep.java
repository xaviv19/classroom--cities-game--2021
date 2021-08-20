package com.drpicox.game.testSteps.newGame;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;

import org.springframework.stereotype.Component;

@Component
public class AddAsGameNameStep extends AbstractPostLineStep {

    private NewGameTestView newGameTestView;

    public AddAsGameNameStep(NewGameTestView newGameTestView) {
        this.newGameTestView = newGameTestView;
    }

    @Override
    protected String getRegex() {
        return "Add \"([^\"]+)\" as game name";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var gameName = match[1];
        newGameTestView.addGameName(gameName);
    }
}
