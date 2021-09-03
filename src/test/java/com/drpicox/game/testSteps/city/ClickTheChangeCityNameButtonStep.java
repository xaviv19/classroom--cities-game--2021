package com.drpicox.game.testSteps.city;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class ClickTheChangeCityNameButtonStep extends AbstractPostLineStep {

    private final CityTestView cityTestView;

    public ClickTheChangeCityNameButtonStep(CityTestView cityTestView) {
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "Click the change city name button";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        cityTestView.submitChangeCityName();
    }
}
