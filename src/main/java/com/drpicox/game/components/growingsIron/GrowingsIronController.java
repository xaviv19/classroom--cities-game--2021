package com.drpicox.game.components.growingsIron;
import com.drpicox.game.components.growingsIron.GrowingIron;
import com.drpicox.game.components.growingsIron.GrowingsIronRepository;
import com.drpicox.game.games.Game;
import org.springframework.stereotype.Component;



@Component
public class GrowingsIronController {

    private final GrowingsIronRepository growingsIronRepository;

    public GrowingsIronController(GrowingsIronRepository growingsIronRepository) {
        this.growingsIronRepository = growingsIronRepository;
    }

    public GrowingIron create(String entityId, Game game) {
        var component = new GrowingIron(entityId, game);
        growingsIronRepository.save(component);
        return component;
    }

}
