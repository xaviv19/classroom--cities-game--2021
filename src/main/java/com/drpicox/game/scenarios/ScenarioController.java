package com.drpicox.game.scenarios;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

@Service
public class ScenarioController {

    private Map<String,Scenario> cache = new HashMap<>();

    public Optional<Scenario> find(String name) {
        if (cache.containsKey(name))
            return Optional.of(cache.get(name));

        var props = new Properties();
        var fileName = name.toLowerCase().replaceAll("[^\\w\\d]+", "-") + ".properties";
        var path = getScenariosPath();
        var file = new File(path, fileName);
        try {
            var reader = new FileReader(file);
            props.load(reader);
        } catch (IOException e) {
            throw new Error("Error while loading scenario '"+name+"'", e);
        }

        var result = new Scenario(name, props);
        cache.put(name, result);

        return Optional.of(result);
    }

    private String getScenariosPath() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("scenarios");
        return url.getPath().replaceAll("%20", " ");
    }
}
