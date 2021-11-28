package com.drpicox.game.components.locateds;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocatedsController {

    private final LocatedsRepository locatedsRepository;

    public LocatedsController(LocatedsRepository locatedsRepository) {
        this.locatedsRepository = locatedsRepository;
    }

    public void create(String entityId, int initialLocation) {
        var component = new Located(entityId, initialLocation);
        locatedsRepository.save(component);
    }

    public int getLocation(String entityId) {
        return locatedsRepository.findById(entityId).get().getLocation();
    }

    public void moveTo(String entityId, int destination) {
        var located = locatedsRepository.findById(entityId).get();
        located.moveTo(destination);
        locatedsRepository.save(located);
    }

    public List<Located> findByLocation(int location) {
        return locatedsRepository.findByLocation(location);
    }

    public List<Located> findByLocationOf(String entityId) {
        var location = getLocation(entityId);
        return findByLocation(location);
    }
}
