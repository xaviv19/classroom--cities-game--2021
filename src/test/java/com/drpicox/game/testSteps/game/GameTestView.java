package com.drpicox.game.testSteps.game;

import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testSteps.message.MessageTestView;
import com.drpicox.game.testSteps.screenStack.Screen;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class GameTestView implements Screen {

    private final MessageTestView messageTestView;
    private final SnapshotService snapshotService;

    public GameTestView(MessageTestView messageTestView, SnapshotService snapshotService) {
        this.messageTestView = messageTestView;
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

    public Stream<EntityResponse> streamEntities() {
        return game.streamEntities();
    }

    public Stream<EntityResponse> streamEntities(Predicate<EntityResponse> predicate) {
        return streamEntities().filter(predicate);
    }

    public Optional<EntityResponse> findEntity(Predicate<EntityResponse> predicate) {
        return streamEntities(predicate).findFirst();
    }

    /////////// --- RestMethods

    private void replaceGame(GameResponse game) {
        this.game = game;
    }

    public GameResponse post(String url, Map data) {
        var playerName = game.getPlayerName();

        var finalUrl = url + "?playerName=" + playerName;
        var result = messageTestView.callApi(() -> {
            var response = snapshotService.post(finalUrl, data, GameResponse.class);
            replaceGame(response);
            return response;
        });
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
        messageTestView.callApi(() -> {
            var response = snapshotService.get(url, null, GameResponse.class);
            replaceGame(response);
            return response;
        });
    }

    public void playGame() {
        nextPlayer(nextPlayerName);
    }
}
