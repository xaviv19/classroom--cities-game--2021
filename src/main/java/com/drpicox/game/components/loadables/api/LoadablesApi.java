package com.drpicox.game.components.loadables.api;

import com.drpicox.game.components.loadables.LoadablesController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loadables")
public class LoadablesApi {

    private final LoadablesController loadablesController;
    private final GamesApi gamesApi;

    public LoadablesApi(LoadablesController loadablesController, GamesApi gamesApi) {
        this.loadablesController = loadablesController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/load")
    public GameData load(@PathVariable String entityId, @RequestParam String playerName, @RequestBody LoadUnloadForm form) {
        loadablesController.load(entityId, form.getDockId(), form.getResource(), form.getLoadUnloadAmount());

        return gamesApi.play(playerName);
    }

    @PostMapping("/{entityId}/unload")
    public GameData unload(@PathVariable String entityId, @RequestParam String playerName, @RequestBody LoadUnloadForm form) {
        loadablesController.unload(entityId, form.getDockId(), form.getResource(), form.getLoadUnloadAmount());

        return gamesApi.play(playerName);
    }
}
