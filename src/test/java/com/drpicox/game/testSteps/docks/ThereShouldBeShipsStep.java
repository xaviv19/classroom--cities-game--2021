package com.drpicox.game.testSteps.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.drpicox.game.owneds.api.OwnedResponse.byOwner;
import static com.google.common.truth.Truth8.assertThat;

@Component
public class ThereShouldBeShipsStep extends AbstractPostLineStep {


    private final DocksTestView docksTestView;

    public ThereShouldBeShipsStep(DocksTestView docksTestView) {
        this.docksTestView = docksTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be (\\d+) \"([^\"]+)\" ships";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedSize = Integer.parseInt(match[1]);
        var ownerName = match[2];

        var dockables = docksTestView.streamDockables().filter(byOwner(ownerName));
        assertThat(dockables).hasSize(expectedSize);
    }
}
