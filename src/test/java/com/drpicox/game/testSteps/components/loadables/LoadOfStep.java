package com.drpicox.game.testSteps.components.loadables;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.EntityTestView;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class LoadOfStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;
    private final LoadableTestView loadableTestView;

    public LoadOfStep(EntityTestView entityTestView, LoadableTestView loadableTestView) {
        this.entityTestView = entityTestView;
        this.loadableTestView = loadableTestView;
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
        loadableTestView.load(resource);
    }
}
