package com.drpicox.game.testSteps.loadable;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheUnloadButtonShouldBeStep extends AbstractPostLineStep {


    private final LoadableTestView loadableTestView;

    public TheUnloadButtonShouldBeStep(LoadableTestView loadableTestView) {
        this.loadableTestView = loadableTestView;
    }

    @Override
    protected String getRegex() {
        return "The unload button should be (highlighted|normal)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var isRequested = match[1].equals("highlighted");

        var loadable = loadableTestView.getLoadable();
        assertThat(loadable.isUnloadRequested()).isEqualTo(isRequested);
    }
}
