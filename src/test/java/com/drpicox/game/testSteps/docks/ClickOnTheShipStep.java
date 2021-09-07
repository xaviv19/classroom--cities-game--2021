package com.drpicox.game.testSteps.docks;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import static com.drpicox.game.components.nameds.NamedResponse.byName;
import static com.drpicox.game.components.owneds.OwnedResponse.byOwner;

@Component
public class ClickOnTheShipStep extends AbstractPostLineStep {

    private final DocksTestView docksTestView;
    private final NavigatorTestView navigatorTestView;

    public ClickOnTheShipStep(DocksTestView docksTestView, NavigatorTestView navigatorTestView) {
        this.docksTestView = docksTestView;
        this.navigatorTestView = navigatorTestView;
    }

    @Override
    protected String getRegex() {
        return "Click on the \"([^\"]+)\" ship \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var shipName = match[2];

        var ship = docksTestView.streamDockables()
                .filter(byOwner(ownerName)).filter(byName(shipName))
                .findFirst().get();

        navigatorTestView.pushScreenName("entity", ship.getId());
    }
}
