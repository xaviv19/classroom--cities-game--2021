package com.drpicox.game.testSteps.newPlayer;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testViews.NewPlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class AddYourNameAsPlayerNameStep extends AbstractPostLineStep {

    private NewPlayerTestView newPlayerTestView;

    public AddYourNameAsPlayerNameStep(NewPlayerTestView newPlayerTestView) {
        this.newPlayerTestView = newPlayerTestView;
    }

    @Override
    protected String getRegex() {
        return "Add your name as player name";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        newPlayerTestView.addPlayerName("leoard");
    }
}
