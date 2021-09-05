package com.drpicox.game.testSteps.owneds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.owneds.OwnedTestView;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheOwnerShouldBeStep extends AbstractPostLineStep {


    private final OwnedTestView ownedTestView;

    public TheOwnerShouldBeStep(OwnedTestView ownedTestView) {
        this.ownedTestView = ownedTestView;
    }

    @Override
    protected String getRegex() {
        return "The owner should be \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedOwnerName = match[1];

        var ownerName = ownedTestView.getOnwerName();
        assertThat(ownerName).isEqualTo(expectedOwnerName);
    }
}
