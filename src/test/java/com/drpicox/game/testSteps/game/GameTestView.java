package com.drpicox.game.testSteps.game;

import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.player.PlayerTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class GameTestView implements NavigableScreen {

    private final MessageTestView messageTestView;
    private final SnapshotService snapshotService;
    private final PlayerTestView playerTestView;

    public GameTestView(MessageTestView messageTestView, SnapshotService snapshotService, PlayerTestView playerTestView) {
        this.messageTestView = messageTestView;
        this.snapshotService = snapshotService;
        this.playerTestView = playerTestView;
    }

    private GameResponse game;

    @Override
    public String getScreenName() {
        return "game";
    }

    @Override
    public void show() {
    }

    public GameResponse fetchGame(String gameName, String creatorName, String token) {
        var game = messageTestView.callApi(
                () -> snapshotService.get("/api/v1/games/" + gameName + "/by/" + creatorName + "?token=" + token, null, GameResponse.class)
        );
        replaceGame(game);

        return game;
    }

    public void replaceGame(GameResponse game) {
        if (game == null) return;
        this.game = game;
        playerTestView.replaceToken(game.getPlayerName(), game.getToken());
    }

    public GameResponse getGame() {
        return game;
    }

    public GameResponse post(String url, HashMap<String, String> data) {
        var token = playerTestView.getToken();

        var finalUrl = url + "?token=" + token;
        var result = messageTestView.callApi(() -> {
            var response = snapshotService.post(finalUrl, data, GameResponse.class);
            replaceGame(response);
            return response;
        });
        return result;
    }
}
