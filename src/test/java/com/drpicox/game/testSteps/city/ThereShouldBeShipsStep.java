package com.drpicox.game.testSteps.city;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.helpers.CitiesHelper;
import com.drpicox.game.testSteps.helpers.ShipsHelper;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeShipsStep extends AbstractPostLineStep {


    private final CityTestView cityTestView;

    public ThereShouldBeShipsStep(CityTestView cityTestView) {
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be (\\d+) \"([^\"]+)\" ships";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var count = Integer.parseInt(match[1]);
        var ownerName = match[2];

        var city = cityTestView.getCity();
        var ships = ShipsHelper.findAllByOwner(city, ownerName);
        assertThat(ships).hasSize(count);
    }
}
