package com.drpicox.game.old.cards;

import com.drpicox.game.old.games.Game;
import com.drpicox.game.old.players.OldPlayer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Card implements ICard {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Game game;

    private String type;
    private String name;

    @ManyToOne
    private OldPlayer owner;
    @ManyToOne
    private OldPlayer beforeSaveOwner;
    private int square;

    private String pile;

    public Card(Game game, String type, String name) {
        this.game = game;
        this.type = type;
        this.name = name;
        this.pile = "";
    }

    public Card() {} // JPA

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public String getOwnerName() {
        return owner != null ? owner.getName() : "";
    }

    public OldPlayer getOwner() {
        return owner;
    }

    public OldPlayer getBeforeSaveOwner() {
        return beforeSaveOwner;
    }

    public void resetBeforeSaveOwner() {
        beforeSaveOwner = owner;
    }

    public int getSquare() {
        return square;
    }

    public String getPile() {
        return pile;
    }

    public boolean hasType(String type) {
        return this.type.equals(type);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public void onPick(OldPlayer oldPlayer, int square) {
        this.owner = oldPlayer;
        this.square = square;
    }

    public void discard() {
        this.pile = "";
        this.owner = null;
        this.square = 0;
    }

    public void pile(String pile) {
        this.pile = pile;
    }

    public void moveToSquare(int square) {
        this.pile = "";
        this.square = square;
    }

    public void moveToSquare(OldPlayer oldPlayer, int square) {
        this.pile = "";
        this.owner = oldPlayer;
        this.square = square;
    }

    public void stealCard(OldPlayer newOwner) {
        this.pile = "";
        this.square = 0;
        this.owner = newOwner;
    }


    @Override
    public String toString() {
        return toSimpleString() +
                "#" + id + ";" +
                owner +
                "[" + square + "]" +
                "|p:" + pile + "|";
    }

    public String toSimpleString() {
        return type + "-" + name;
    }
}
