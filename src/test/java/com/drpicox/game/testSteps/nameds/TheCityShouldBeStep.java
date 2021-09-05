package com.drpicox.game.testSteps.nameds;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.city.CityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.helpers.CitiesHelper;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheCityShouldBeStep extends AbstractPostLineStep {


    private final CityTestView cityTestView;

    public TheCityShouldBeStep(CityTestView cityTestView) {
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "The city should be \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var cityName = match[1];

        var city = cityTestView.getCity();
        assertThat(city.getName()).isEqualTo(cityName);
    }
}
