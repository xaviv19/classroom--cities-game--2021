package com.drpicox.game.testSteps.loadable;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class EnterAsLoadUnloadAmountStep extends AbstractPostLineStep {


    private final LoadableTestView loadableTestView;

    public EnterAsLoadUnloadAmountStep(LoadableTestView loadableTestView) {
        this.loadableTestView = loadableTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter (\\d+) as load/unload amount";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var amount = Integer.parseInt(match[1]);

        loadableTestView.enterLoadUnloadAmount(amount);
    }
}
