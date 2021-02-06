package com.drpicox.game.testSteps.cheating;

import com.drpicox.game.testMocks.RandomPlayerPickerMock;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class MockChoosePlayer extends AbstractPostLineStep {

    private final RandomPlayerPickerMock randomPlayerPickerMock;

    public MockChoosePlayer(RandomPlayerPickerMock randomPlayerPickerMock) {
        this.randomPlayerPickerMock = randomPlayerPickerMock;
    }

    @Override
    protected String getRegex() {
        return "MOCK choose player _([^_]*)_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        String player = match[1];
        randomPlayerPickerMock.cheatPick(player);
    }
}
