package com.drpicox.game.testSteps.listGames;

import com.drpicox.game.common.api.SuccessResponse;
import com.drpicox.game.games.api.ListGamesResponseEntry;
import com.drpicox.game.games.api.ListGamesResponse;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import com.drpicox.game.testSteps.player.PlayerTestView;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class ListGamesTestView implements NavigableScreen {
    private final NavigatorTestView navigatorTestView;
    private final MessageTestView messageTestView;
    private final PlayerTestView playerTestView;
    private final SnapshotService snapshotService;

    public ListGamesTestView(NavigatorTestView navigatorTestView, MessageTestView messageTestView, PlayerTestView playerTestView, SnapshotService snapshotService) {
        this.navigatorTestView = navigatorTestView;
        this.messageTestView = messageTestView;
        this.playerTestView = playerTestView;
        this.snapshotService = snapshotService;
    }

    private List<ListGamesResponseEntry> games;

    public void fetchMyGames() {
        var playerName = playerTestView.getPlayerName();
        fetch(playerName);
    }

    public void fetch(String playerName) {
        var data = new HashMap<String, String>();
        data.put("playerName", playerName);

        var ok = messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/byPlayer", data, ListGamesResponse.class);
            games = response.getGames();
            return response;
        });
        if (ok != null) navigatorTestView.pushScreenName("list games");
    }

    public void fetchMyPlayingGames() {
        var token = playerTestView.getToken();

        var data = new HashMap<String, String>();
        data.put("token", token);

        var ok = messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/byJoined", data, ListGamesResponse.class);
            games = response.getGames();
            return response;
        });
        if (ok != null) navigatorTestView.pushScreenName("list games");
    }

    public List<ListGamesResponseEntry> getGames() {
        return games;
    }

    public void join(String gameName, String creatorName) {
        var token = playerTestView.getToken();

        var data = new HashMap<String, String>();
        data.put("gameName", gameName);
        data.put("creatorName", creatorName);
        data.put("token", token);

        var ok = messageTestView.callApi(() -> {
            var response = snapshotService.post("/api/v1/games/join", data, SuccessResponse.class);
            games.clear();
            return response;
        });
        if (ok != null) navigatorTestView.popScreenName();
    }

    @Override
    public String getScreenName() {
        return "list games";
    }

    @Override
    public void show() {
    }
}
