package com.drpicox.game.testSteps.game;

import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

@Component
public class GameTestView implements NavigableScreen {

    private final MessageTestView messageTestView;
    private final PlayerTestView playerTestView;
    private final SnapshotService snapshotService;

    public GameTestView(MessageTestView messageTestView, PlayerTestView playerTestView, SnapshotService snapshotService) {
        this.messageTestView = messageTestView;
        this.playerTestView = playerTestView;
        this.snapshotService = snapshotService;
    }

    private GameResponse game;

    @Override
    public String getScreenName() {
        return "game";
    }

    @Override
    public void show() {
    }

    public GameResponse fetchGame(String gameName, String creatorName) {
        var token = playerTestView.getToken();

        var game = messageTestView.callApi(
                () -> snapshotService.get("/api/v1/games/" + gameName + "/by/" + creatorName + "?token=" + token, null, GameResponse.class)
        );
        this.game = game;

        return game;
    }

    public GameResponse getGame() {
        return game;
    }
}
