package com.drpicox.game.testSteps.navigator;

import com.drpicox.game.testPost.BeforePostTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

@Component
public class NavigatorTestView implements BeforePostTest {

    private final List<NavigableScreen> navigableScreens;

    public NavigatorTestView(@Lazy List<NavigableScreen> navigableScreens) {
        this.navigableScreens = navigableScreens;
    }
    
    private Stack<String> screenNameStack = new Stack<>();

    @Override
    public void beforePostTest() {
        screenNameStack.clear();
        pushScreenName("welcome");
    }

    public void pushScreenName(String screenName) {
        var screen = getNavigableScreen(screenName);

        screenNameStack.push(screenName);
        screen.show();
    }

    private NavigableScreen getNavigableScreen(String screenName) {
        return navigableScreens.stream()
                .filter(s -> s.getScreenName().equals(screenName))
                .findFirst()
                .get();
    }

    public String peekScreenName() {
        return screenNameStack.peek();
    }

    public void popScreenName() {
        screenNameStack.pop();
        var screenName = screenNameStack.peek();
        var screen = getNavigableScreen(screenName);
        screen.show();
    }
}
