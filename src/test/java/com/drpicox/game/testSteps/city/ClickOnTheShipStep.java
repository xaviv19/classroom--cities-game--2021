package com.drpicox.game.testSteps.city;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.helpers.CitiesHelper;
import com.drpicox.game.testSteps.helpers.ShipsHelper;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

@Component
public class ClickOnTheShipStep extends AbstractPostLineStep {

    private final NavigatorTestView navigatorTestView;
    private final CityTestView cityTestView;

    public ClickOnTheShipStep(NavigatorTestView navigatorTestView, CityTestView cityTestView) {
        this.navigatorTestView = navigatorTestView;
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "Click on the \"([^\"]+)\" ship \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var shipName = match[2];

        var city = cityTestView.getCity();
        var ship = ShipsHelper.findByOwnerAndName(city, ownerName, shipName);
        navigatorTestView.pushScreenName("ship", ship.getId());
    }
}
