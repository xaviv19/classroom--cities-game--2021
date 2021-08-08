package com.drpicox.game.old.cards;

public interface ICard {

    String getType();
    String getName();
    String getOwnerName();
    int getSquare();
    String getPile();

    default String asString(String format) {
        return format
                .replaceAll("TYPE", getType())
                .replaceAll("NAME", getName());
    }
}
