package com.drpicox.game.testSteps.city;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.helpers.ShipsHelper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereShouldBeTheShipStep extends AbstractPostLineStep {


    private final CityTestView cityTestView;

    public ThereShouldBeTheShipStep(CityTestView cityTestView) {
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "There should be the \"([^\"]+)\" \"([^\"]+)\" ship";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var ownerName = match[1];
        var shipName = match[2];

        var city = cityTestView.getCity();
        var ships = ShipsHelper.findAllByOwner(city, ownerName);
        var shipNames = ships.stream().map(c -> c.getName()).collect(Collectors.toList());
        assertThat(shipNames).contains(shipName);
    }
}
