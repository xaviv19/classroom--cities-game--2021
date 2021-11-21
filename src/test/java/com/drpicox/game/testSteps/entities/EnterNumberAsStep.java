package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class EnterNumberAsStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public EnterNumberAsStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter number (\\d+) as _([^_]+)_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var count = Integer.parseInt(match[1]);
        var key = PrettyKey.getKey(match[2]);

        entityTestView.putFormKey(key, count);
    }
}
