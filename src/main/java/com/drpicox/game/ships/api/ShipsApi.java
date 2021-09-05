package com.drpicox.game.ships.api;

import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.ships.ShipController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ships")
public class ShipsApi {

    private final ShipController shipController;
    private final GamesApi gamesApi;

    public ShipsApi(ShipController shipController, GamesApi gamesApi) {
        this.shipController = shipController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{shipId}/loadUnloadAmount")
    public GameResponse changeShipName(@PathVariable String shipId, @RequestParam String token, @RequestBody NewLoadUnloadAmountForm form) {
        shipController.changeLoadUnloadAmount(shipId, form.getNewLoadUnloadAmount());

        var ship = shipController.findById(shipId).get();
        var game = ship.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
