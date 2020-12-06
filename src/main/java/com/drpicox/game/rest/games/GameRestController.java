package com.drpicox.game.rest.games;

import com.drpicox.game.forms.NewGameBuilder;
import com.drpicox.game.forms.NewGameForm;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/games")
public class GameRestController {

    private final NewGameBuilder newGameBuilder;

    public GameRestController(NewGameBuilder newGameBuilder) {
        this.newGameBuilder = newGameBuilder;
    }

    @PostMapping
    public SuccessForm create(@RequestBody NewGameForm newGameForm) {
        newGameBuilder.create(newGameForm);
        return new SuccessForm();
    }
}
