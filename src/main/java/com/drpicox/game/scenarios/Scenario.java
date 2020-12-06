package com.drpicox.game.scenarios;

import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.function.BiConsumer;

public class Scenario {
    private String name;
    private SortedMap<String,String> values = new TreeMap<>();

    public Scenario(String name, Properties props) {
        this.name = name;
        props.forEach((key, value) -> values.put(""+key, ""+value));
    }

    public String getName() {
        return name;
    }

    public SortedMap<String, String> getValues() {
        return values;
    }

    public void forEach(String prefix, BiConsumer<String, String> action) {
        values.forEach((key, value) -> {
            if (!key.startsWith(prefix)) return;
            action.accept(key, value);
        });
    }

    public void forEachInteger(String prefix, BiConsumer<String, Integer> action) {
        values.forEach((key, value) -> {
            if (!key.startsWith(prefix)) return;
            action.accept(key, Integer.parseInt(value));
        });
    }

    public int getInt(String key) {
        return Integer.parseInt(values.get(key));
    }
}
