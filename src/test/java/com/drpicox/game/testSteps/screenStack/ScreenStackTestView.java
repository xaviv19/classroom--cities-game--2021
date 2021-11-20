package com.drpicox.game.testSteps.screenStack;

import com.drpicox.game.testPost.BeforePostTest;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Stack;

@Component
public class ScreenStackTestView implements BeforePostTest {

    private final List<Screen> screens;

    public ScreenStackTestView(@Lazy List<Screen> screens) {
        this.screens = screens;
    }
    
    private Stack<StackEntry> screenNameStack = new Stack<>();

    @Override
    public void beforePostTest() {
        screenNameStack.clear();
        pushScreenName("welcome");
    }

    public void pushScreenName(String screenName) {
        pushScreenName(screenName, null);
    }

    public void pushScreenName(String screenName, String id) {
        screenNameStack.push(new StackEntry(screenName, id));
        showScreen(screenName);
    }

    private void showScreen(String screenName) {
        var screen = getNavigableScreen(screenName);
        screen.show();
    }

    private Screen getNavigableScreen(String screenName) {
        return screens.stream()
                .filter(s -> s.getScreenName().equals(screenName))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Cannot found the testView for the screen '" + screenName + "'.\nYou may check that:\n - Do you have a testView that implements NavigableScreen?\n - Does the testView have the @Component annotation?\n - Does the testView method getScreenName() returns '" + screenName + "'?"));
    }

    public String peekScreenName() {
        return screenNameStack.peek().screenName;
    }

    public String peekId() {
        return screenNameStack.peek().id;
    }

    public void popScreenName() {
        screenNameStack.pop();
        var top = screenNameStack.peek();
        showScreen(top.screenName);
    }

    private static class StackEntry {
        String screenName;
        String id;

        public StackEntry(String screenName, String id) {
            this.screenName = screenName;
            this.id = id;
        }
    }
}
