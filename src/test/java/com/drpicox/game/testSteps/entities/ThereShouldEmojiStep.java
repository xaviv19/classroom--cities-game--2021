package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldEmojiStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;

    public ThereShouldEmojiStep(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    @Override
    protected String getRegex() {
        return "There should (be|be no) \"([^_]+)\" emoji";
    }

    @Override
    protected void run(PostLine line, String[] match) {
    }
}
