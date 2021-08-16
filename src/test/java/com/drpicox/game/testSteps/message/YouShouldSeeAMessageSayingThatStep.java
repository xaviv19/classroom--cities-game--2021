package com.drpicox.game.testSteps.message;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import com.drpicox.game.testViews.MessageTestView;
import org.springframework.stereotype.Component;
import static com.google.common.truth.Truth.assertThat;

@Component
public class YouShouldSeeAMessageSayingThatStep extends AbstractPostLineStep {

    private MessageTestView messageTestView;

    @Override
    protected String getRegex() {
        return "You should see a message saying that \"([^\"]+)\"";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var message = match[0];

        assertThat(messageTestView.getMessage()).isEqualTo(message);
    }
}
