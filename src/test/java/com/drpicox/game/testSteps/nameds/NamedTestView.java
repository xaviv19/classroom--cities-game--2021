package com.drpicox.game.testSteps.nameds;

import com.drpicox.game.nameds.NamedResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class NamedTestView {

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public NamedTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    private String newName;

    private void clear() {
        newName = "";
    }

    public String getNamedName() {
        var game = gameTestView.getGame();
        String entityId = navigatorTestView.peekId();

        var entity = game.getEntityResponse(entityId);
        var name = entity.getComponent(NamedResponse.class).get().getName();

        return name;
    }

    public void enterNewName(String newName) {
        this.newName = newName;
    }

    public void submitChangeCityName() {
        String entityId = navigatorTestView.peekId();

        var data = new HashMap<String, String>();
        data.put("newName", newName);

        gameTestView.post("/api/v1/nameds/" + entityId + "/name", data);
    }
}
