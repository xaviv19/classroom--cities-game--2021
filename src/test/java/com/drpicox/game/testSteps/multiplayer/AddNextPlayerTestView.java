package com.drpicox.game.testSteps.multiplayer;

import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AddNextPlayerTestView implements NavigableScreen {

    private final GameTestView gameTestView;
    private final MessageTestView messageTestView;
    private final NavigatorTestView navigatorTestView;
    private final SnapshotService snapshotService;

    public AddNextPlayerTestView(GameTestView gameTestView, MessageTestView messageTestView, NavigatorTestView navigatorTestView, SnapshotService snapshotService) {
        this.gameTestView = gameTestView;
        this.messageTestView = messageTestView;
        this.navigatorTestView = navigatorTestView;
        this.snapshotService = snapshotService;
    }

    private String nextPlayerName;
    private String nextPlayerPassword;

    @Override
    public String getScreenName() {
        return "add next player";
    }

    @Override
    public void show() {
        clear();
    }

    private void clear() {
        nextPlayerName = "";
        nextPlayerPassword = "";
    }

    public void enterNextPlayerName(String playerName) {
        this.nextPlayerName = playerName;
    }

    public void enterNextPlayerPassword(String password) {
        this.nextPlayerPassword = password;
    }

    public GameResponse submit() {
        var game = gameTestView.getGame();
        var gameName = game.getGameName();
        var creatorName = game.getCreatorName();

        var data = new HashMap<String, String>();
        data.put("gameName", gameName);
        data.put("creatorName", creatorName);
        data.put("playerName", nextPlayerName);
        data.put("password", nextPlayerPassword);

        var ok = gameTestView.post("/api/v1/games/joinNext", data);
        if (ok != null) navigatorTestView.pushScreenName("game");
        return ok;
    }
}
