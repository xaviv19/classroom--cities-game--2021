package com.drpicox.game.testSteps.multiplayer;

import com.drpicox.game.testPost.BeforePostTest;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MultiplayerTestView implements BeforePostTest {

    private GameTestView gameTestView;

    public MultiplayerTestView(GameTestView gameTestView) {
        this.gameTestView = gameTestView;
    }

    private List<String> tokens;
    private int currentTokensIndex;

    @Override
    public void beforePostTest() {
        tokens = new ArrayList<>();
    }
    
    public void addToken(String token) {
        if (tokens.contains(token)) return;
        tokens.add(token);
        currentTokensIndex = tokens.indexOf(token);
    }

    public void next() {
        currentTokensIndex += 1;
        if (currentTokensIndex >= tokens.size()) currentTokensIndex = 0;

        var newToken = tokens.get(currentTokensIndex);
        var game = gameTestView.getGame();
        var gameName = game.getGameName();
        var creatorName = game.getCreatorName();
        gameTestView.fetchGame(gameName, creatorName, newToken);
    }
}
