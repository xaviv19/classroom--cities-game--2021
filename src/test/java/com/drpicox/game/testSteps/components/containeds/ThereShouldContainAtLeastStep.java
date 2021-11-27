package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.drpicox.game.testSteps.components.typeds.TypedTestView.byType;
import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldContainAtLeastStep extends AbstractPostLineStep {

    private final ContainerTestView containerTestView;

    public ThereShouldContainAtLeastStep(ContainerTestView containerTestView) {
        this.containerTestView = containerTestView;
    }

    @Override
    protected String getRegex() {
        return "There should contain at least (\\d+) \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var atLeast = Integer.parseInt(match[1]);
        var type = match[2];

        var contents = containerTestView.streamContaineds().filter(byType(type));
        assertThat(contents.count()).isAtLeast(atLeast);
    }
}
