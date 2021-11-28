package com.drpicox.game.testSteps.components.leveled;

import com.drpicox.game.components.leveleds.LeveledUpgrader;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testSteps.components.nameds.NamedTestView;
import com.drpicox.game.testSteps.entities.EntityTestView;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UpgradeTheLevelStep extends AbstractPostLineStep {

    private final EntityTestView entityTestView;
    private final NamedTestView namedTestView;
    private final LeveledTestView leveledTestView;
    private final List<LeveledUpgrader> leveledUpgraders;

    public UpgradeTheLevelStep(EntityTestView entityTestView, NamedTestView namedTestView, LeveledTestView leveledTestView, List<LeveledUpgrader> leveledUpgraders) {
        this.entityTestView = entityTestView;
        this.namedTestView = namedTestView;
        this.leveledTestView = leveledTestView;
        this.leveledUpgraders = leveledUpgraders;
    }

    @Override
    protected String getRegex() {
        return "Upgrade the level";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        checkLeveledUpgrader();
        leveledTestView.upgrade();
    }

    private void checkLeveledUpgrader() {
        var name = namedTestView.getName();
        var exists = leveledUpgraders.stream().anyMatch(l -> l.getName().equals(name));
        if (!exists) throw new AssertionError(
                "There is no @Component implementing LeveledUpgrader for the name '"+name+"'.\n"+
                        "Available implementations are:"+
                        leveledUpgraders.stream().map(
                                f -> "\n- " + f.getName() + " (" + f.getClass().getName() + ")"
                        ).collect(Collectors.joining()) + "\n" +
                        "You may create a new @Component implementing LeveledUpgrader with the corresponding getName().\n" +
                        "Look inside com.drpicox.game.entities.{buildings,decks}.upgraders, and you may add the new Upgrader."
        );
    }
}
