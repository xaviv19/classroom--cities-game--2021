package com.drpicox.game.components.owneds;

import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnedsController {

    private final OwnedsRepository ownedsRepository;

    public OwnedsController(OwnedsRepository ownedsRepository) {
        this.ownedsRepository = ownedsRepository;
    }

    public void create(String entityId, Player owner) {
        var component = new Owned(entityId, owner);
        ownedsRepository.save(component);
    }

    public List<Owned> findAllByOwner(Player owner) {
        return ownedsRepository.findAllByOwner(owner);
    }
}
