package com.drpicox.game.scenarios;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;

@Service
public class ScenarioController {

    public Optional<Scenario> find(String name) {
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

        var result = new Scenario(props);

        return Optional.of(result);
    }

    private String getScenariosPath() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource("scenarios");
        return url.getPath().replaceAll("%20", " ");
    }
}
