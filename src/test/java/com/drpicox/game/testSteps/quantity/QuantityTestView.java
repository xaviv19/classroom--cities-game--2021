package com.drpicox.game.testSteps.quantity;

import com.drpicox.game.testSteps.game.EntityTestView;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

@Component
public class QuantityTestView {

    private final EntityTestView entityTestView;

    public QuantityTestView(EntityTestView entityTestView) {
        this.entityTestView = entityTestView;
    }

    public int getQuantity() {
        return entityTestView.getEntityPropertyInt("quantity");
    }

}
