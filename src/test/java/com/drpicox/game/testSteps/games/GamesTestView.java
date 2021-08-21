package com.drpicox.game.testSteps.games;

import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.games.api.GameListResponseEntry;
import com.drpicox.game.games.api.GamesListResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class GamesTestView {
    private final MessageTestView messageTestView;
    private final PlayerTestView playerTestView;
    private final SnapshotService snapshotService;

    public GamesTestView(MessageTestView messageTestView, PlayerTestView playerTestView, SnapshotService snapshotService) {
        this.messageTestView = messageTestView;
        this.playerTestView = playerTestView;
        this.snapshotService = snapshotService;
    }

    private List<GameListResponseEntry> games;

    public void fetchMyGames() {
        var playerName = playerTestView.getPlayerName();
        fetch(playerName);
    }

    public void fetch(String playerName) {
        var data = new HashMap<String, String>();
        data.put("playerName", playerName);

        messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/byPlayer", data, GamesListResponse.class);
            games = response.getGames();
            return response;
        });
    }

    public List<GameListResponseEntry> getGames() {
        return games;
    }

    public void join(String gameName, String creatorName) {
        var token = playerTestView.getToken();

        var data = new HashMap<String, String>();
        data.put("gameName", gameName);
        data.put("creatorName", creatorName);
        data.put("token", token);

        messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/join", data, SuccessResponse.class);
            games.clear();
            return response;
        });
    }

    public void fetchMyPlayingGames() {
        var token = playerTestView.getToken();

        var data = new HashMap<String, String>();
        data.put("token", token);

        messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/byJoined", data, GamesListResponse.class);
            games = response.getGames();
            return response;
        });
    }
}
