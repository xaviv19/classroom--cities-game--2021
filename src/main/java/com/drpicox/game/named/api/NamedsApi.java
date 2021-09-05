package com.drpicox.game.named.api;

import com.drpicox.game.named.NamedController;
import com.drpicox.game.games.api.GameResponse;
import com.drpicox.game.games.api.GamesApi;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/nameds")
public class NamedsApi {

    private final NamedController namedController;
    private final GamesApi gamesApi;

    public NamedsApi(NamedController namedController, GamesApi gamesApi) {
        this.namedController = namedController;
        this.gamesApi = gamesApi;
    }

    @PostMapping("/{entityId}/name")
    public GameResponse changedName(@PathVariable String entityId, @RequestParam String token, @RequestBody NewNamedNameForm form) {
        var named = namedController.changeName(entityId, form.getNewName());


        var game = named.getGame();
        return gamesApi.get(game.getGameName(), game.getCreator().getPlayerName(), token);
    }
}
