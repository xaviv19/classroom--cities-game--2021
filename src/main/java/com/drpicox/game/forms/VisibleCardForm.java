package com.drpicox.game.forms;

import com.drpicox.game.cards.ICard;

public class VisibleCardForm implements Comparable<VisibleCardForm>, ICard {

    private String type;
    private String name;
    private String ownerName;
    private int square;
    private String pile;

    public VisibleCardForm(String type, String name, String ownerName, int square, String pile) {
        this.type = type;
        this.name = name;
        this.ownerName = ownerName;
        this.square = square;
        this.pile = pile;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public int getSquare() {
        return square;
    }

    public String getPile() {
        return pile;
    }

    @Override
    public int compareTo(VisibleCardForm o) {
        if (!ownerName.equals(o.ownerName)) return ownerName.compareTo(o.ownerName);
        if (!pile.equals(o.pile)) return pile.compareTo(o.pile);
        if (square != o.square) return square - o.square;
        if (!type.equals(o.type)) return type.compareTo(o.type);
        return name.compareTo(o.name);
    }

    public void play(String pile) {
        this.pile = pile;
    }

    public void play(String target, int square) {
        play(target + "-square-" + square);
    }

    @Override
    public String toString() {
        return "VisibleCardForm{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", square=" + square +
                ", pile='" + pile + '\'' +
                '}';
    }
}
