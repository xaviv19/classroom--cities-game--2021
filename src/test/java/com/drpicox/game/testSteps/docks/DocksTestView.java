package com.drpicox.game.testSteps.docks;

import com.drpicox.game.ecs.EntityResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.stream.Stream;

@Component
public class DocksTestView {

    public static Predicate<EntityResponse> byDockId(String dockId) {
        return e -> e.getOrDefault("dockId", "").equals(dockId);
    }

    private final GameTestView gameTestView;
    private final NavigatorTestView navigatorTestView;

    public DocksTestView(GameTestView gameTestView, NavigatorTestView navigatorTestView) {
        this.gameTestView = gameTestView;
        this.navigatorTestView = navigatorTestView;
    }

    public Stream<EntityResponse> streamDockables() {
        var game = gameTestView.getGame();
        String dockEntityId = navigatorTestView.peekId();

        return game.streamEntities().filter(byDockId(dockEntityId));
    }
}
