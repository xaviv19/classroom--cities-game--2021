package com.drpicox.game.testSteps.ship;

import com.drpicox.game.testPost.reader.PostLine;
import com.drpicox.game.testSteps.AbstractPostLineStep;
import org.springframework.stereotype.Component;

import static com.google.common.truth.Truth.assertThat;

@Component
public class EnterAsLoadUnloadAmountStep extends AbstractPostLineStep {


    private final ShipTestView shipTestView;

    public EnterAsLoadUnloadAmountStep(ShipTestView shipTestView) {
        this.shipTestView = shipTestView;
    }

    @Override
    protected String getRegex() {
        return "Enter (\\d+) as load/unload amount";
    }

    @Override
    protected void run(PostLine line, String[] match) {
        var amount = Integer.parseInt(match[1]);

        shipTestView.enterLoadUnloadAmount(amount);
    }
}
