package com.drpicox.game.testSteps.game;

import com.drpicox.game.ecs.EntityResponse;
import com.drpicox.game.testSteps.navigator.NavigableScreen;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

@Component
public class EntityTestView implements NavigableScreen {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public EntityTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    @Override
    public String getScreenName() {
        return "entity";
    }

    @Override
    public void show() {
        clear();
    }

    private void clear() {}

    public EntityResponse getEntity() {
        var game = gameTestView.getGame();
        String entityId = navigatorTestView.peekId();

        return game.getEntityResponse(entityId);
    }

    public Object getEntityProperty(String key) {
        return getEntity().get(key);
    }
}
