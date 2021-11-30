package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.resourceds.ResourcedTestView;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheDockResourceCountShouldBeStep extends AbstractPostLineStep {

    private final DockTestView dockTestView;
    private final ResourcedTestView resourcedTestView;

    public TheDockResourceCountShouldBeStep(DockTestView dockTestView, ResourcedTestView resourcedTestView) {
        this.dockTestView = dockTestView;
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "The dock resource \"([^\"]+)\" count should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var key = PrettyKey.getKey(match[1]);
        var expectedValue = Integer.parseInt(match[2]);

        var dockId = dockTestView.getCoLocatedDockId();

        var value = resourcedTestView.getResourceCount(dockId, key);
        assertThat(value).isEqualTo(expectedValue);
    }
}
