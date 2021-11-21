package com.drpicox.game.testSteps.components.resources;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class LoadTheResourceStep extends AbstractPostLineStep {

    private final ResourcesTestView resourcesTestView;

    public LoadTheResourceStep(ResourcesTestView resourcesTestView) {
        this.resourcesTestView = resourcesTestView;
    }

    @Override
    protected String getRegex() {
        return "Load the resource \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resource = PrettyKey.getKey(match[1]);

        resourcesTestView.load(resource);
    }
}
