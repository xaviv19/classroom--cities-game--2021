package com.drpicox.game.testSteps.city;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.city.CityTestView;
import com.drpicox.game.testSteps.login.LoginTestView;
import org.springframework.stereotype.Component;

@Component
public class EnterNewCityNameStep extends AbstractPostLineStep {

    private final CityTestView cityTestView;

    public EnterNewCityNameStep(CityTestView cityTestView) {
        this.cityTestView = cityTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter new city name \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var newCityName = match[1];
        cityTestView.enterNewCityName(newCityName);
    }
}
