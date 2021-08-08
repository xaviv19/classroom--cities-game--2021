package com.drpicox.game.testSteps.alert;

import com.drpicox.game.old.forms.VisibleGameForm;
import com.drpicox.game.testPost.TestPostForms;
import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class ThereIsAMessageThatSays extends AbstractPostLineStep {

    private final TestPostForms testPostForms;

    public ThereIsAMessageThatSays(TestPostForms testPostForms) {
        this.testPostForms = testPostForms;
    }

    @Override
    protected String getRegex() {
        return "There is a message that says \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var message = match[1];
        var response = testPostForms.getForm(VisibleGameForm.class);

        assertThat(response.getMessage()).isEqualTo(message);
    }
}
