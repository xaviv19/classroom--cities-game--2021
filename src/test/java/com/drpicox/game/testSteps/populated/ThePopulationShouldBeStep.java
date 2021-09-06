package com.drpicox.game.testSteps.populated;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.populated.PopulatedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThePopulationShouldBeStep extends AbstractPostLineStep {


    private final PopulatedTestView populatedTestView;

    public ThePopulationShouldBeStep(PopulatedTestView populatedTestView) {
        this.populatedTestView = populatedTestView;
    }

    @Override
    protected String getRegex() {
        return "The population should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedPopulation = Integer.parseInt(match[1]);

        var population = populatedTestView.getPopulation();
        assertThat(population).isEqualTo(expectedPopulation);
    }
}
