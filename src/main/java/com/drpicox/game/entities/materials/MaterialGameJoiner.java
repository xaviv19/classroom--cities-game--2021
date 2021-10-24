package com.drpicox.game.entities.materials;

import com.drpicox.game.components.locateds.LocatedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.entities.ships.ShipFactory;
import com.drpicox.game.games.Game;
import com.drpicox.game.games.GameJoiner;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class MaterialGameJoiner implements GameJoiner {

    private final MaterialFactory materialFactory;

    public MaterialGameJoiner(MaterialFactory materialFactory) {
        this.materialFactory = materialFactory;
    }

    @Override
    public void joinGame(Player owner, Game game) {
        materialFactory.createMaterials(game, owner,"IRON", 20);
        materialFactory.createMaterials(game, owner,"GOLD", 20);
        materialFactory.createMaterials(game, owner,"WHEAT", 50);
        materialFactory.createMaterials(game, owner,"WOOD", 35);
        materialFactory.createMaterials(game, owner,"STONE", 50);
    }

}
