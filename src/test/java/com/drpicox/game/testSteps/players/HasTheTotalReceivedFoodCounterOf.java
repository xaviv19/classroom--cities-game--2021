package com.drpicox.game.testSteps.players;

import com.drpicox.game.forms.VisibleGameForm;
import com.drpicox.game.testPost.TestPostForms;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class HasTheTotalReceivedFoodCounterOf extends AbstractPostLineStep {

    private final TestPostForms testPostForms;

    public HasTheTotalReceivedFoodCounterOf(TestPostForms testPostForms) {
        this.testPostForms = testPostForms;
    }

    @Override
    protected String getRegex() {
        return "_([^_]+)_ has the total received food counter of _([^_]+)_";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var player = match[1];
        var count = Integer.parseInt(match[2]);
        var response = testPostForms.getForm(VisibleGameForm.class);

        var actualCount = response.getPlayer(player).getTotalReceivedFoodCount();

        assertThat(actualCount).isEqualTo(count);
    }
}
