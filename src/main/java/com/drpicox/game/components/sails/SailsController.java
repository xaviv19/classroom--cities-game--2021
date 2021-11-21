package com.drpicox.game.components.sails;

import org.springframework.stereotype.Component;

@Component
public class SailsController {

    private final SailsRepository sailsRepository;

    public SailsController(SailsRepository sailsRepository) {
        this.sailsRepository = sailsRepository;
    }

    public void create(String entityId) {
        var component = new Sail(entityId);
        sailsRepository.save(component);
    }

    public Sail orderSail(String entityId, int destinationLocation) {
        var sail = sailsRepository.findById(entityId).get();
        sail.orderSail(destinationLocation);
        sailsRepository.save(sail);

        return sail;
    }
    public Sail orderHalt(String entityId) {
        var sail = sailsRepository.findById(entityId).get();
        sail.orderHalt();
        sailsRepository.save(sail);

        return sail;
    }
}
