package com.drpicox.game.forms;

import com.drpicox.game.scenarios.Scenario;

import java.util.SortedMap;

public class ScenarioForm {
    private String name;
    private SortedMap<String, String> values;

    public ScenarioForm(Scenario scenario) {
        this.name = scenario.getName();
        this.values = scenario.getValues();
    }

    public int getInt(String key) {
        return Integer.parseInt(values.get(key));
    }
}
