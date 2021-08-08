package com.drpicox.game.old.forms;

public class VisiblePlayerForm {
    private final String name;
    private final int totalReceivedFoodCount;

    public VisiblePlayerForm(String name, int totalReceivedFoodCount) {
        this.name = name;
        this.totalReceivedFoodCount = totalReceivedFoodCount;
    }

    public String getName() {
        return name;
    }

    public int getTotalReceivedFoodCount() {
        return totalReceivedFoodCount;
    }
}
