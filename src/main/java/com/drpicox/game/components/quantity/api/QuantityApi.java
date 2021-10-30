package com.drpicox.game.components.quantity.api;

import com.drpicox.game.components.loadables.LoadablesController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/quantity")
public class QuantityApi {

    private final QuantityController quantityController;
    private final GamesApi gamesApi;

    public QuantityApi(QuantityController quantityController, GamesApi gamesApi) {
        this.quantityController = quantityController;
        this.gamesApi = gamesApi;
    }
/*
    @PostMapping("/{entityId}/increaseQuantity")
    public GameData increaseQuantity(@PathVariable String entityId, @RequestParam String token) {
        var quantity = quantityController.increaseQuantity(entityId, 1);
        var game = quantity.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }

    @PostMapping("/{entityId}/decreaseQuantity")
    public GameData decreaseQuantity(@PathVariable String entityId, @RequestParam String token) {
        var quantity = quantityController.decreaseQuantity(entityId, 1);
        var game = quantity.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
hola

*/
    @PostMapping("/{entityId}/createHouse/{entityId1}/{quantity1}/{entityId2}/{quantity2}")
    public GameData createHouse(@PathVariable String entityId,@PathVariable String entityId1, @PathVariable int quantity1, @PathVariable String entityId2, @PathVariable int quantity2,@RequestParam String token) {
        var quantity = quantityController.increaseQuantity(entityId, 1);
        quantity = quantityController.decreaseQuantity(entityId1, quantity1);
        quantity = quantityController.decreaseQuantity(entityId2, quantity2);
        var game = quantity.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }

}
