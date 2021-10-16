package com.drpicox.game.components.withBuildings.api;

import com.drpicox.game.components.withBuildings.WithBuildingsController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/with-buildings")
public class WithBuildingsApi {

    private final WithBuildingsController withBuildingsController;
    private final GamesApi gamesApi;

    public WithBuildingsApi(WithBuildingsController withBuildingsController, GamesApi gamesApi) {
        this.withBuildingsController = withBuildingsController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/order-build")
    public GameData sail(@PathVariable String entityId, @RequestParam String token, @RequestBody BuildForm form) {
        var type = form.getBuildingType();
        var component = withBuildingsController.build(entityId, type);

        var game = component.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
