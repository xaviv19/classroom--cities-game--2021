package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testSteps.game.GameResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.screenStack.Screen;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;

@Component
public class EntityTestView implements Screen {

    private final GameTestView gameTestView;
    private final ScreenStackTestView screenStackTestView;
    private Map<String, Object> form;

    public EntityTestView(GameTestView gameTestView, ScreenStackTestView screenStackTestView) {
        this.gameTestView = gameTestView;
        this.screenStackTestView = screenStackTestView;
    }

    @Override
    public String getScreenName() {
        return "entity";
    }

    @Override
    public void show() {
        clear();
    }

    private void clear() {
        form = new TreeMap<>();
    }

    public String getEntityId() {
        var entityId = screenStackTestView.peekId();
        if (entityId == null) throw new AssertionError("Expected screen to have an id for an entity, but it has no id. The screen is '"+screenStackTestView.peekScreenName()+"' and the screenId is null");
        return entityId;
    }

    public EntityResponse getEntity() {
        var game = gameTestView.getGame();
        String entityId = getEntityId();
        return game.getEntity(entityId);
    }

    public void putFormKey(String key, Object value) {
        form.put(key, value);
    }

    public GameResponse post(String collection, String action) {
        return this.post("/api/v1/" + collection + "/" + getEntityId() + "/" + action, new TreeMap<>());
    }

    public GameResponse post(String url, Map<String, Object> extraData) {
        var data = new TreeMap<>();
        data.putAll(form);
        data.putAll(extraData);
        form.clear();

        return gameTestView.post(url, data);
    }

    public static Function<EntityResponse,String> toId() {
        return e -> e.getId();
    }

    public static Function<EntityResponse,String> toOwnerNameType() {
        return e -> e.getOnwerNameType();
    }

    public static Predicate<EntityResponse> byOwnerNameType(String owner, String name, String type) {
        var ownerNameType = owner + "-" + name + "-" + type;
        return e ->e.getOnwerNameType().equals(ownerNameType);
    }

}
