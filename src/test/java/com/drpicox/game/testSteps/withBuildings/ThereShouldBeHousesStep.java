package com.drpicox.game.testSteps.withBuildings;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeHousesStep extends AbstractPostLineStep {

    private final WithBuildingsTestView withBuildingsTestView;

    public ThereShouldBeHousesStep(WithBuildingsTestView withBuildingsTestView) {
        this.withBuildingsTestView = withBuildingsTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be (\\d+) houses";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedCount = Integer.parseInt(match[1]);

        var count = withBuildingsTestView.getBuildingCount("houses");
        assertThat(count).isEqualTo(expectedCount);
    }
}
