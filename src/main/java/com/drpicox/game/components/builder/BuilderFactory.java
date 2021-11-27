package com.drpicox.game.components.builder;

public interface BuilderFactory {
    String getName();
    String getType();
    String build(String containerId);
}
