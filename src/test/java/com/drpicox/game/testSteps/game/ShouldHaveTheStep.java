package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ShouldHaveTheStep extends AbstractPostLineStep {

    private final GameTestView gameTestView;

    public ShouldHaveTheStep(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    @Override
    protected String getRegex() {
        return "\"([^\"]+)\" should have the \"([^\"]+)\" \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var owner = match[1];
        var name = match[2];
        var type = match[3];

        var result = gameTestView.getGame().getEntityByOwnerNameType(owner, name, type);
        assertThat(result).isNotNull();
    }
}
