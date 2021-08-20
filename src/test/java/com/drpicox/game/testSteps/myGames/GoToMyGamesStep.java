package com.drpicox.game.testSteps.myGames;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class GoToMyGamesStep extends AbstractPostLineStep {

    private final MyGamesTestView myGamesTestView;

    public GoToMyGamesStep(MyGamesTestView myGamesTestView) {
        this.myGamesTestView = myGamesTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to my games";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        myGamesTestView.fetch();
    }
}
