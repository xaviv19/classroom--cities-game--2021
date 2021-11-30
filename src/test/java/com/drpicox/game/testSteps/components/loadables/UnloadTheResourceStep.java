package com.drpicox.game.testSteps.components.loadables;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.entities.PrettyKey;
import org.springframework.stereotype.Component;

@Component
public class UnloadTheResourceStep extends AbstractPostLineStep {

    private final LoadableTestView loadableTestView;

    public UnloadTheResourceStep(LoadableTestView loadableTestView) {
        this.loadableTestView = loadableTestView;
    }

    @Override
    protected String getRegex() {
        return "Unload the resource \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var resource = PrettyKey.getKey(match[1]);

        loadableTestView.unload(resource);
    }
}
