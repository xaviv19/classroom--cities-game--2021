package com.drpicox.game.testSteps.nameds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ChangeTheNameToStep extends AbstractPostLineStep {

    private final NamedTestView namedTestView;

    public ChangeTheNameToStep(NamedTestView namedTestView) {
        this.namedTestView = namedTestView;
    }

    @Override
    protected String getRegex() {
        return "Change the name to \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var newNamedName = match[1];
        namedTestView.enterNewName(newNamedName);
        namedTestView.submitChangeCityName();
    }
}
