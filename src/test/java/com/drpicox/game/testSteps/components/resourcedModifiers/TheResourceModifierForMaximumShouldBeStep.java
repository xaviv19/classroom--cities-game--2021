package com.drpicox.game.testSteps.components.resourcedModifiers;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheResourceModifierForMaximumShouldBeStep extends AbstractPostLineStep {

    private final ResourcedModifierTestView resourcedModifierTestView;

    public TheResourceModifierForMaximumShouldBeStep(ResourcedModifierTestView resourcedModifierTestView) {
        this.resourcedModifierTestView = resourcedModifierTestView;
    }

    @Override
    protected String getRegex() {
        return "The resource modifier for \"([^\"]+)\" maximum should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resourceName = PrettyKey.getKey(match[1]);
        var expectedValue = Integer.parseInt(match[2]);

        var value = resourcedModifierTestView.getResourceModifierMaximum(resourceName);
        assertThat(value).isEqualTo(expectedValue);
    }
}
