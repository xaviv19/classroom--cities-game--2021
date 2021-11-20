package com.drpicox.game.components.sails.api;

import com.drpicox.game.components.sails.SailsController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sails")
public class SailsApi {

    private final SailsController sailsController;
    private final GamesApi gamesApi;

    public SailsApi(SailsController sailsController, GamesApi gamesApi) {
        this.sailsController = sailsController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/sail")
    public GameData sail(@PathVariable String entityId, @RequestParam String playerName, @RequestBody DestinationForm form) {
        var sail = sailsController.orderSail(entityId, form.getDestinationLocation());

        return gamesApi.play(playerName);
    }

    @PostMapping("/{entityId}/halt")
    public GameData halt(@PathVariable String entityId, @RequestParam String playerName) {
        var sail = sailsController.orderHalt(entityId);

        return gamesApi.play(playerName);
    }
}
