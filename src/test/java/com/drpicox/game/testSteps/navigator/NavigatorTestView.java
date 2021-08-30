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
        screenNameStack.push(screenName);
        showScreen(screenName);
    }

    private void showScreen(String screenName) {
        var screen = getNavigableScreen(screenName);
        screen.show();
    }

    private NavigableScreen getNavigableScreen(String screenName) {
        return navigableScreens.stream()
                .filter(s -> s.getScreenName().equals(screenName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Cannot found the testView for the screen '" + screenName + "'.\nYou may check that:\n - Do you have a testView that implements NavigableScreen?\n - Does the testView have the @Component annotation?\n - Does the testView method getScreenName() returns '" + screenName + "'?"));
    }

    public String peekScreenName() {
        return screenNameStack.peek();
    }

    public void popScreenName() {
        screenNameStack.pop();
        var screenName = screenNameStack.peek();
        showScreen(screenName);
    }
}
