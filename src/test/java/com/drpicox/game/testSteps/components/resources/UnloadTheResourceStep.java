package com.drpicox.game.testSteps.components.resources;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class UnloadTheResourceStep extends AbstractPostLineStep {

    private final ResourcesTestView resourcesTestView;

    public UnloadTheResourceStep(ResourcesTestView resourcesTestView) {
        this.resourcesTestView = resourcesTestView;
    }

    @Override
    protected String getRegex() {
        return "Unload the resource \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resource = PrettyKey.getKey(match[1]);

        resourcesTestView.unload(resource);
    }
}
