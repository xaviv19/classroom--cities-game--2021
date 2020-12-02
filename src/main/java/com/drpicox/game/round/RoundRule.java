package com.drpicox.game.round;

import com.drpicox.game.games.Game;

public interface RoundRule extends Comparable<RoundRule> {

    void run(Game game);

    @Override
    default int compareTo(RoundRule o) {
        return getClass().getName().compareTo(o.getClass().getSimpleName());
    }
}
