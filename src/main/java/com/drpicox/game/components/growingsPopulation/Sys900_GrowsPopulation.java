package com.drpicox.game.components.growingsPopulation;

import com.drpicox.game.components.owneds.Owned;
import com.drpicox.game.components.owneds.OwnedsController;
import com.drpicox.game.components.quantity.QuantityController;
import com.drpicox.game.components.typeds.TypedsController;
import com.drpicox.game.ecs.EcsComponent;
import com.drpicox.game.ecs.EcsSystem;
import com.drpicox.game.games.Game;
import com.drpicox.game.components.populateds.PopulatedsController;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Sys900_GrowsPopulation implements EcsSystem {

    private final GrowingsPopulationsRepository growingsPopulationsRepository;
    private final GrowingsPopulationsController growsPopulationController;
    private final PopulatedsController populatedsController;
    private final TypedsController typedsController;
    private final QuantityController quantityController;
    private final OwnedsController ownedsController;

    public Sys900_GrowsPopulation(OwnedsController ownedsController, QuantityController quantityController, TypedsController typedsController, GrowingsPopulationsRepository growingsPopulationsRepository, GrowingsPopulationsController growsPopulationController, PopulatedsController populatedsController) {
        this.growingsPopulationsRepository = growingsPopulationsRepository;
        this.growsPopulationController = growsPopulationController;
        this.populatedsController = populatedsController;
        this.typedsController = typedsController;
        this.quantityController = quantityController;
        this.ownedsController = ownedsController;
    }

    @Override
    public void act(Game game) {
        var cities = growingsPopulationsRepository.findAllByGame(game);
        cities.forEach(growsPopulation -> {
            if(typedsController.isTyped(growsPopulation.getEntityId(), "HOUSE")) {
                var nHouses = quantityController.getQuantity(growsPopulation.getEntityId());
                if(nHouses > 0){
                    var owneds = getIds(ownedsController.findAllByGame(game));
                    var types = getIds(typedsController.findAllByGameAndType(game, "city"));
                    var intersection = types.stream()
                            .filter(owneds::contains).collect(Collectors.toSet());
                    var cityId = intersection.stream().findAny().get();
                    System.out.print(cityId);
                    populatedsController.increasePopulation(cityId, 1);
                }
            }else{
                populatedsController.increasePopulation(growsPopulation.getEntityId(), 1);
            }
        });
    }

    private <T extends EcsComponent> List<String> getIds(List<T> components) {
        return components.stream().map(c -> c.getEntityId()).collect(Collectors.toList());
    }
}
