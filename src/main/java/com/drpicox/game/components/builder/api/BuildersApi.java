package com.drpicox.game.components.builder.api;

import com.drpicox.game.components.builder.BuilderController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/builders")
public class BuildersApi {

    private final BuilderController builderController;
    private final GamesApi gamesApi;

    public BuildersApi(BuilderController builderController, GamesApi gamesApi) {
        this.builderController = builderController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/build")
    public GameData build(@PathVariable String entityId, @RequestParam String playerName, @RequestBody NewBuildingForm form) {
       builderController.build(entityId, form.getBuildingName());

        return gamesApi.play(playerName);
    }
}
