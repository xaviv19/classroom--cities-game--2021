package com.drpicox.game.testSteps.withBuildings;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class OrderBuildANewHouseStep extends AbstractPostLineStep {

    private final WithBuildingsTestView withBuildingsTestView;

    public OrderBuildANewHouseStep(WithBuildingsTestView withBuildingsTestView) {
        this.withBuildingsTestView = withBuildingsTestView;
    }

    @Override
    protected String getRegex() {
        return "Order build a new house";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        withBuildingsTestView.orderBuildHouse();
    }
}
