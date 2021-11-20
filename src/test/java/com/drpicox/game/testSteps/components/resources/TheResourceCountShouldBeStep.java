package com.drpicox.game.testSteps.components.resources;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.PrettyKey;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheResourceCountShouldBeStep extends AbstractPostLineStep {

    private final ResourcesTestView resourcesTestView;

    public TheResourceCountShouldBeStep(ResourcesTestView resourcesTestView) {
        this.resourcesTestView = resourcesTestView;
    }

    @Override
    protected String getRegex() {
        return "The resource _([^_]+)_ count should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var key = PrettyKey.getKey(match[1]);
        var expectedValue = Integer.parseInt(match[2]);

        var value = resourcesTestView.getResourceCount(key);
        assertThat(value).isEqualTo(expectedValue);
    }
}
