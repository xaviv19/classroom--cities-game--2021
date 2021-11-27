package com.drpicox.game.testSteps.components.resourceds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class UnloadTheResourceStep extends AbstractPostLineStep {

    private final ResourcedTestView resourcedTestView;

    public UnloadTheResourceStep(ResourcedTestView resourcedTestView) {
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "Unload the resource \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resource = PrettyKey.getKey(match[1]);

        resourcedTestView.unload(resource);
    }
}
