package com.drpicox.game.components.quantity.api;

import com.drpicox.game.components.loadables.LoadablesController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.ecs.GameData;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/quantity")
public class QuantityApi {

    private final QuantityController quantityController;
    private final GamesApi gamesApi;
    private final NamedsController namedsController;
    private final OwnedsController ownedsController;

    public QuantityApi(OwnedsController ownedsController, NamedsController namedsController, QuantityController quantityController, GamesApi gamesApi) {
        this.quantityController = quantityController;
        this.gamesApi = gamesApi;
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
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
*/
    @PostMapping("/{entityId}/createHouse")
    public GameData createHouse(@PathVariable String entityId, @RequestParam String token) {
        var quantity = quantityController.increaseQuantity(entityId, 1);
        var game = quantity.getGame();


        var owneds = ownedsController.findAllByGame(game);
        owneds.forEach(owned -> {
            if(owned.getEntityId().equals(entityId)){
                var stoneId1 = namedsController.findAllByGameAndName(game, "STONE").get(0).getEntityId();
                var woodId1 = namedsController.findAllByGameAndName(game, "WOOD").get(0).getEntityId();

                quantityController.decreaseQuantity(stoneId1, 35);

                quantityController.decreaseQuantity(woodId1, 20);
            }
        });
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
