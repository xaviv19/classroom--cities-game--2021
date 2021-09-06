package com.drpicox.game.testSteps.nameds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheNameShouldBeStep extends AbstractPostLineStep {

    private final NamedTestView namedTestView;

    public TheNameShouldBeStep(NamedTestView namedTestView) {
        this.namedTestView = namedTestView;
    }

    @Override
    protected String getRegex() {
        return "The name should be \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedName = match[1];

        var name = namedTestView.getNamedName();
        assertThat(name).isEqualTo(expectedName);
    }
}
