package com.drpicox.game.testSteps.house;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ClickTheCreateHouseButtonStep extends AbstractPostLineStep {

    private final HouseTestView houseTestView;

    public ClickTheCreateHouseButtonStep(HouseTestView houseTestView) {
        this.houseTestView = houseTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the Create House button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        houseTestView.createHouse();
    }
}
