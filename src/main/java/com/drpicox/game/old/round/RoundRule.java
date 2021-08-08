package com.drpicox.game.old.round;

import com.drpicox.game.old.games.Game;

public interface RoundRule extends Comparable<RoundRule> {

    void run(Game game);

    @Override
    default int compareTo(RoundRule o) {
        return getClass().getName().compareTo(o.getClass().getSimpleName());
    }
}
