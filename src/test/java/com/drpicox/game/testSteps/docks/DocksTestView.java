package com.drpicox.game.testSteps.docks;

import com.drpicox.game.games.api.EntityResponse;
import com.drpicox.game.nameds.api.NamedResponse;
import com.drpicox.game.owneds.api.OwnedResponse;
import com.drpicox.game.ships.api.ShipResponse;
import com.drpicox.game.testSteps.game.GameTestView;
import com.drpicox.game.testSteps.navigator.NavigatorTestView;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.drpicox.game.owneds.api.OwnedResponse.byOwner;

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

        return game.getEntityResponses().stream()
                .filter(e -> e instanceof ShipResponse)
                .map(e -> (ShipResponse)e)
                .filter(e -> e.getCityId().equals(dockEntityId))
                .map(e -> (EntityResponse) e);
    }
}
