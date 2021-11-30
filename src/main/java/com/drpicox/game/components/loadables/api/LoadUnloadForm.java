package com.drpicox.game.components.loadables.api;

public class LoadUnloadForm {
    private int loadUnloadAmount;
    private String resource;
    private String dockId;

    public int getLoadUnloadAmount() {
        return loadUnloadAmount;
    }

    public String getDockId() {
        return dockId;
    }

    public String getResource() {
        return resource;
    }
}
