package com.drpicox.game.games.api;

import com.drpicox.game.games.Game;

import java.util.ArrayList;
import java.util.List;

public class GamesListResponse {

    private List<GameListResponseEntry> games = new ArrayList<>();

    public List<GameListResponseEntry> getGames() {
        return games;
    }

    public void addGame(Game game) {
        var entry = new GameListResponseEntry(game.getGameName(), game.getPlayer().getPlayerName());
        games.add(entry);
    }
}
