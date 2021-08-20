package com.drpicox.game.testSteps.myGames;

import com.drpicox.game.games.api.GameListResponseEntry;
import com.drpicox.game.games.api.GamesListResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class MyGamesTestView {
    private final MessageTestView messageTestView;
    private final PlayerTestView playerTestView;
    private final SnapshotService snapshotService;

    public MyGamesTestView(MessageTestView messageTestView, PlayerTestView playerTestView, SnapshotService snapshotService) {
        this.messageTestView = messageTestView;
        this.playerTestView = playerTestView;
        this.snapshotService = snapshotService;
    }

    private List<GameListResponseEntry> games;

    public void fetch() {
        var token = playerTestView.getToken();

        var data = new HashMap<String, String>();
        data.put("token", token);

        messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/byPlayer", data, GamesListResponse.class);
            games = response.getGames();
            return response;
        });
    }

    public List<GameListResponseEntry> getGames() {
        return games;
    }
}
