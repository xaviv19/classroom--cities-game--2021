package com.drpicox.game.testSteps.welcome;

import com.drpicox.game.testSteps.screenStack.Screen;
import org.springframework.stereotype.Component;

@Component
public class WelcomeTestView implements Screen {

    @Override
    public String getScreenName() {
        return "welcome";
    }

    @Override
    public void show() {
    }
}
