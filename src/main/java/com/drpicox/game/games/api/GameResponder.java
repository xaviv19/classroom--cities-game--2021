package com.drpicox.game.games.api;

import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;

public interface GameResponder {
    void respond(GameResponse response, Game game, Player playingPlayer);
}
