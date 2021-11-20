package com.drpicox.game.components.resourceds.api;

import com.drpicox.game.components.resourceds.ResourcedsController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/resourceds")
public class ResourcedsApi {

    private final ResourcedsController resourcedsController;
    private final GamesApi gamesApi;

    public ResourcedsApi(ResourcedsController resourcedsController, GamesApi gamesApi) {
        this.resourcedsController = resourcedsController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/load")
    public GameData load(@PathVariable String entityId, @RequestParam String playerName, @RequestBody LoadUnloadForm form) {
        resourcedsController.transfer(form.getDockId(), entityId, form.getResource(), form.getLoadUnloadAmount());

        return gamesApi.play(playerName);
    }

    @PostMapping("/{entityId}/unload")
    public GameData unload(@PathVariable String entityId, @RequestParam String playerName, @RequestBody LoadUnloadForm form) {
        resourcedsController.transfer(entityId, form.getDockId(), form.getResource(), form.getLoadUnloadAmount());

        return gamesApi.play(playerName);
    }
}
