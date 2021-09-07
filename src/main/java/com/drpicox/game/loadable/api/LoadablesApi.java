package com.drpicox.game.loadable.api;

import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.loadable.LoadablesController;
import com.drpicox.game.ships.ShipController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/loadables")
public class LoadablesApi {

    private final ShipController shipController;
    private final LoadablesController loadablesController;
    private final GamesApi gamesApi;

    public LoadablesApi(ShipController shipController, LoadablesController loadablesController, GamesApi gamesApi) {
        this.shipController = shipController;
        this.loadablesController = loadablesController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/loadUnloadAmount")
    public GameResponse changeShipName(@PathVariable String entityId, @RequestParam String token, @RequestBody NewLoadUnloadAmountForm form) {
        loadablesController.changeLoadUnloadAmount(entityId, form.getNewLoadUnloadAmount());

        var ship = shipController.findById(entityId).get();
        var game = ship.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
