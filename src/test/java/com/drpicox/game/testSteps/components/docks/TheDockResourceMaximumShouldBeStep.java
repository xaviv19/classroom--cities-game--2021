package com.drpicox.game.testSteps.components.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.resourceds.ResourcedTestView;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheDockResourceMaximumShouldBeStep extends AbstractPostLineStep {

    private final DockTestView dockTestView;
    private final ResourcedTestView resourcedTestView;

    public TheDockResourceMaximumShouldBeStep(DockTestView dockTestView, ResourcedTestView resourcedTestView) {
        this.dockTestView = dockTestView;
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "The dock resource _([^_]+)_ maximum should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var key = PrettyKey.getKey(match[1]);
        var expectedValue = Integer.parseInt(match[2]);

        var dockId = dockTestView.getCoLocatedDockId();

        var value = resourcedTestView.getResourceMaximum(dockId, key);
        assertThat(value).isEqualTo(expectedValue);
    }
}
