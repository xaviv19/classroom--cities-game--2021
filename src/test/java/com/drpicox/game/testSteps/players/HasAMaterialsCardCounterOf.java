package com.drpicox.game.testSteps.players;

import com.drpicox.game.forms.NewGameForm;
import com.drpicox.game.forms.VisibleGameForm;
import com.drpicox.game.testPost.SnapshotService;
import com.drpicox.game.testPost.TestPostForms;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

@Component
public class HasAMaterialsCardCounterOf extends AbstractPostLineStep {

    @Override
    protected String getRegex() {
        return "_([^_]+)_ has a materials card counter of _([^_]+)_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        // skip on backend
    }
}
