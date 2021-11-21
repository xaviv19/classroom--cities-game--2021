package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.screenStack.Screen;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class GameTestView implements Screen {

    private final SnapshotService snapshotService;

    public GameTestView(SnapshotService snapshotService) {
        this.snapshotService = snapshotService;
    }

    private GameResponse game;

    /////////// --- Screen

    @Override
    public String getScreenName() {
        return "game";
    }

    @Override
    public void show() {
    }

    /////////// --- NextPlayerInput

    private String nextPlayerName;

    public void replaceNextPlayerName(String playerName) {
        this.nextPlayerName = playerName;
    }

    /////////// --- Current Saved Game

    public GameResponse getGame() {
        return game;
    }

    /////////// --- RestMethods

    private void replaceGame(GameResponse game) {
        this.game = game;
    }

    public GameResponse post(String url, Map data) {
        var playerName = game.getPlayerName();

        var finalUrl = url + "?playerName=" + playerName;
        var result = snapshotService.post(finalUrl, data, GameResponse.class);
        replaceGame(result);
        return result;
    }

    public void endTheRound() {
        post("/api/v1/games/endRound", new LinkedHashMap<>());
    }

    public void refreshGame() {
        nextPlayer(game.getPlayerName());
    }

    public void nextPlayer(String playerName) {
        var url = "/api/v1/games/play/" + playerName;
        var response = snapshotService.get(url, null, GameResponse.class);
        replaceGame(response);
    }

    public void playGame() {
        nextPlayer(nextPlayerName);
    }
}
