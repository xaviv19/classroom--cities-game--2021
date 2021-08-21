package com.drpicox.game.testSteps.listGames;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class GoToMyGamesStep extends AbstractPostLineStep {

    private final ListGamesTestView listGamesTestView;

    public GoToMyGamesStep(ListGamesTestView listGamesTestView) {
        this.listGamesTestView = listGamesTestView;
    }

    @Override
    protected String getRegex() {
        return "Go to my games";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        listGamesTestView.fetchMyGames();
    }
}
