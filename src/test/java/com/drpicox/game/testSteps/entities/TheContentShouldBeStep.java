package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheContentShouldBeStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public TheContentShouldBeStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "The _([^_]+)_ content should be \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var key = PrettyKey.getKey(match[1]);
        var expectedValue = match[2];

        var value = entityTestView.getEntity().getString(key);
        assertThat(value).isEqualTo(expectedValue);
    }
}
