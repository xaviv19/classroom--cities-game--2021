package com.drpicox.game.testSteps.loadable;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheLoadUnloadAmountShouldBeStep extends AbstractPostLineStep {


    private final LoadableTestView loadableTestView;

    public TheLoadUnloadAmountShouldBeStep(LoadableTestView loadableTestView) {
        this.loadableTestView = loadableTestView;
    }

    @Override
    protected String getRegex() {
        return "The load/unload amount should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var amount = Integer.parseInt(match[1]);

        var loadable = loadableTestView.getLoadable();
        assertThat(loadable.getLoadUnloadAmount()).isEqualTo(amount);
    }
}
