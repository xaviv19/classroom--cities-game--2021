package com.drpicox.game.testSteps.components.containeds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldContainTheStep extends AbstractPostLineStep {

    private final ContainerTestView containerTestView;

    public ThereShouldContainTheStep(ContainerTestView containerTestView) {
        this.containerTestView = containerTestView;
    }

    @Override
    protected String getRegex() {
        return "There should contain the \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var type = match[1];
        var name = match[2];

        var contained = containerTestView.getContained(type, name);
        assertThat(contained).isNotNull();
    }
}
