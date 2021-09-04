package com.drpicox.game.testSteps.city;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class TheCityPopulationShouldBeStep extends AbstractPostLineStep {


    private final CityTestView cityTestView;

    public TheCityPopulationShouldBeStep(CityTestView cityTestView) {
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "The city population should be (\\d+)";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var expectedPopulation = Integer.parseInt(match[1]);

        var city = cityTestView.getCity();
        assertThat(city.getPopulation()).isEqualTo(expectedPopulation);
    }
}
