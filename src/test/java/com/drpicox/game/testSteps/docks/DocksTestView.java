package com.drpicox.game.testSteps.docks;

import com.drpicox.game.dockables.api.DockableResponse;
import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.ships.api.ShipResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.stream.Stream;

import static com.drpicox.game.dockables.api.DockableResponse.byDockId;

@Component
public class DocksTestView {

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
