package com.drpicox.game.components.resourceds;

import java.io.Serializable;

public class Resource implements Serializable {

    private int count;
    private int maximum;
    private int roundIncrement;

    public Resource(int count, int maximum, int roundIncrement) {
        this.count = count;
        this.maximum = maximum;
        this.roundIncrement = roundIncrement;
    }

    public void replaceCount(int newValue) {
        this.count = newValue;
    }

    public void replaceMaximum(int maximum) {
        this.maximum = maximum;
    }

    void increaseAndMax() {
        this.count += roundIncrement;
        this.count = Math.min(this.maximum, this.count);
    }

    public void transfer(int amount, Resource to) {
        var from = this;

        var available = from.count;
        var room = to.maximum - to.count;
        var effective = min(amount, available, room);

        from.count -= effective;
        to.count += effective;
    }

    private final int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public void applyModifier(int roundIncrementModifier, int maximumModifier) {
        this.roundIncrement += roundIncrementModifier;
        this.maximum += maximumModifier;
    }

    public void consume(int quantity) {
        this.count -= quantity;
    }
}
