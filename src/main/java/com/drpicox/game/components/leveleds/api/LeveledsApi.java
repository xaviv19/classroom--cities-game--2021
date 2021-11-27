package com.drpicox.game.components.leveleds.api;

import com.drpicox.game.components.leveleds.LeveledController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/leveleds")
public class LeveledsApi {

    private final LeveledController leveledController;
    private final GamesApi gamesApi;

    public LeveledsApi(LeveledController leveledController, GamesApi gamesApi) {
        this.leveledController = leveledController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/upgrade")
    public GameData upgrade(@PathVariable String entityId, @RequestParam String playerName) {
        leveledController.upgrade(entityId);

        return gamesApi.play(playerName);
    }
}
