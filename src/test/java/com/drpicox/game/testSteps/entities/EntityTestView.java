package com.drpicox.game.testSteps.entities;

import com.drpicox.game.testSteps.game.GameResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.components.nameds.NamedTestView;
import com.drpicox.game.testSteps.components.owneds.OwnedTestView;
import com.drpicox.game.testSteps.screenStack.Screen;
import com.drpicox.game.testSteps.screenStack.ScreenStackTestView;
import com.drpicox.game.testSteps.components.typeds.TypedTestView;
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

    public EntityResponse getEntity() {
        var game = gameTestView.getGame();
        String entityId = getEntityId();
        if (entityId == null) throw new AssertionError("Expected screen to have an id for an entity, but it has no id. The screen is '"+screenStackTestView.peekScreenName()+"' and the screen id is null");

        return game.getEntity(entityId);
    }

    public String getEntityId() {
        return screenStackTestView.peekId();
    }

    public int getEntityPropertyInt(String key) {
        return getEntity().getInt(key);
    }

    public String getEntityPropertyString(String key) {
        return getEntityPropertyString(getEntityId(), key);
    }

    public String getEntityPropertyString(String entityId, String key) {
        return gameTestView.getGame().getEntity(entityId).get(key, String.class);
    }

    public boolean getEntityPropertyBoolean(String key) {
        return getEntity().get(key, Boolean.class);
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

        return gameTestView.post(url, data);
    }

    public static Function<EntityResponse,String> toId() {
        return e -> e.getId();
    }

    public static Function<EntityResponse,String> toOwnerNameType() {
        var owner = OwnedTestView.toOwner();
        var name = NamedTestView.toName();
        var type = TypedTestView.toType();

        return e -> owner.apply(e) + "-" + name.apply(e) + "-" + type.apply(e);
    }

    public static Predicate<EntityResponse> byOwnerNameType(String owner, String name, String type) {
        var powner = OwnedTestView.byOwner(owner);
        var pname = NamedTestView.byName(name);
        var ptype = TypedTestView.byType(type);

        return e -> powner.test(e) && pname.test(e) && ptype.test(e);
    }

}
