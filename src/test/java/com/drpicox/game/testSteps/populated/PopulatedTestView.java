package com.drpicox.game.testSteps.populated;

import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.populateds.api.PopulatedResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

@Component
public class PopulatedTestView {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public PopulatedTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    public int getPopulation() {
        var game = gameTestView.getGame();
        String entityId = navigatorTestView.peekId();

        var entity = game.getEntityResponse(entityId);
        var component = entity.getComponent(PopulatedResponse.class).get();

        return component.getPopulation();
    }
}
