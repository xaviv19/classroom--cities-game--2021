package com.drpicox.game.old.round;

import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.games.GameController;
import com.drpicox.game.old.players.PlayerController;
import org.springframework.stereotype.Component;

@Component
public class RR100_IncreaseRound implements RoundRule {

    private final GameController gameController;
    private final PlayerController playerController;

    public RR100_IncreaseRound(GameController gameController, PlayerController playerController) {
        this.gameController = gameController;
        this.playerController = playerController;
    }

    @Override
    public void run(Game game) {
        gameController.increaseRoundNumber(game);
    }
}
