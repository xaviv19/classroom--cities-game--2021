package com.drpicox.game.entities.materials;

import com.drpicox.game.components.growingsIron.GrowingsIronController;
import com.drpicox.game.components.growingsWood.GrowingsWoodController;
import com.drpicox.game.components.nameds.NamedsController;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EntityIdGenerator;
import com.drpicox.game.games.Game;
import com.drpicox.game.players.Player;
import org.springframework.stereotype.Component;

@Component
public class MaterialFactory {

    private final NamedsController namedsController;
    private final OwnedsController ownedsController;
    private final QuantityController quantityController;
    private final EntityIdGenerator entityIdGenerator;
    private final TypedsController typedsController;
    private final GrowingsWoodController growingsWoodController;
    private final GrowingsIronController growingsIronController;

    public MaterialFactory(NamedsController namedsController, OwnedsController ownedsController, EntityIdGenerator entityIdGenerator, TypedsController typedsController, QuantityController quantityController, GrowingsWoodController growingsWoodController, GrowingsIronController growingsIronController) {
        this.namedsController = namedsController;
        this.ownedsController = ownedsController;
        this.entityIdGenerator = entityIdGenerator;
        this.quantityController = quantityController;
        this.typedsController = typedsController;
        this.growingsWoodController = growingsWoodController;
        this.growingsIronController = growingsIronController;
    }

    public void createMaterials(Game game, Player owner, String materialName, int initialQuantity) {
        var entityId = entityIdGenerator.nextEntityId("material");
        namedsController.create(entityId, game, materialName);
        ownedsController.create(entityId, game, owner);
        typedsController.create(entityId, game, "material");
        quantityController.create(entityId, game, initialQuantity);
        materialChose(materialName, entityId, game);

    }
    public void materialChose(String materialName, String entityId, Game game){
        switch(materialName){
            case "IRON":
                growingsIronController.create(entityId, game);
                break;
            case "WOOD":
                growingsWoodController.create(entityId, game);
                break;
        }
    }

}
