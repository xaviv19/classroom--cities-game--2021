package com.drpicox.game.testSteps.owneds;

import com.drpicox.game.components.owneds.OwnedResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

@Component
public class OwnedTestView {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public OwnedTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    private String newName;

    private void clear() {
        newName = "";
    }

    public String getOnwerName() {
        var game = gameTestView.getGame();
        String entityId = navigatorTestView.peekId();

        var entity = game.getEntityResponse(entityId);
        var named = entity.getComponent(OwnedResponse.class).get();

        return named.getOwnerName();
    }
}
