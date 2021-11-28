package com.drpicox.game.testSteps.components.resourceds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class LoadOfStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;
    private final ResourcedTestView resourcedTestView;

    public LoadOfStep(EntityTestView entityTestView, ResourcedTestView resourcedTestView) {
        this.entityTestView = entityTestView;
        this.resourcedTestView = resourcedTestView;
    }

    @Override
    protected String getRegex() {
        return "Load (\\d+) of \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var count = Integer.parseInt(match[1]);
        var resource = PrettyKey.getKey(match[2]);

        entityTestView.putFormKey("loadUnloadAmount", count);
        resourcedTestView.load(resource);
    }
}
