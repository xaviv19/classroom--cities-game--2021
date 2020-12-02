package com.drpicox.game.rest.games;

import com.drpicox.game.forms.VisibleGameBuilder;
import com.drpicox.game.forms.NewGameBuilder;
import com.drpicox.game.forms.NewGameForm;
import com.drpicox.game.forms.VisibleGameForm;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/games")
public class GameRestController {

    private final NewGameBuilder newGameBuilder;

    public GameRestController(NewGameBuilder newGameBuilder) {
        this.newGameBuilder = newGameBuilder;
    }

    @PostMapping
    public SuccessForm replace(@RequestBody NewGameForm newGameForm) {
        newGameBuilder.replace(newGameForm);
        return new SuccessForm();
    }
}
