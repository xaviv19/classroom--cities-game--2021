package com.drpicox.game.testSteps.nameds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class AskToChangeTheNameStep extends AbstractPostLineStep {

    private final NamedTestView namedTestView;

    public AskToChangeTheNameStep(NamedTestView namedTestView) {
        this.namedTestView = namedTestView;
    }

    @Override
    protected String getRegex() {
        return "Ask to change the name";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        namedTestView.submitChangeCityName();
    }
}
