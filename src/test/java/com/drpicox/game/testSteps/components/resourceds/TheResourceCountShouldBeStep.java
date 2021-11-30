package com.drpicox.game.testSteps.components.resourceds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheResourceCountShouldBeStep extends AbstractPostLineStep {

    private final ResourcedTestView resourcedTestView;

    public TheResourceCountShouldBeStep(ResourcedTestView resourcedTestView) {
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "The resource \"([^\"]+)\" count should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var key = PrettyKey.getKey(match[1]);
        var expectedValue = Integer.parseInt(match[2]);

        var value = resourcedTestView.getResourceCount(key);
        assertThat(value).isEqualTo(expectedValue);
    }
}
