package com.drpicox.game.old.round;

import com.drpicox.game.old.games.Game;
import org.springframework.stereotype.Component;

import java.util.SortedSet;

@Component
public class RoundRulesRunner {

    private SortedSet<RoundRule> roundRules;

    public RoundRulesRunner(SortedSet<RoundRule> roundRules) {
        this.roundRules = roundRules;
    }

    public void run(Game game) {
        roundRules.forEach(rr -> rr.run(game));
    }
}
