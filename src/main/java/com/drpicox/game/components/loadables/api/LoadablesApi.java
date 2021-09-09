package com.drpicox.game.components.loadables.api;

import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.games.api.GamesApi;
import com.drpicox.game.components.loadables.LoadablesController;
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

    @PostMapping("/{entityId}/loadUnloadAmount")
    public GameResponse changeShipName(@PathVariable String entityId, @RequestParam String token, @RequestBody NewLoadUnloadAmountForm form) {
        loadablesController.orderLoadUnload(entityId, form.getNewLoadUnloadAmount(), form.getSourceEntityId());
        var loadable = loadablesController.findById(entityId).get();

        var game = loadable.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
