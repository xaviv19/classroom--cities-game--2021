package com.drpicox.game.testSteps.wall;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ClickTheCreateWallButtonStep extends AbstractPostLineStep {
    private final WallTestView wallTestView;

    public ClickTheCreateWallButtonStep(WallTestView wallTestView){
        this.wallTestView = wallTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the Create wall button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        wallTestView.createWall();
    }
}
