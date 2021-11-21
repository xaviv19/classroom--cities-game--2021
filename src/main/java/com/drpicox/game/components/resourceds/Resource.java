package com.drpicox.game.components.resourceds;

import java.io.Serializable;

public class Resource implements Serializable {

    private int count;
    private int maximum;
    private int increment;

    public Resource(int count, int maximum, int increment) {
        this.count = count;
        this.maximum = maximum;
        this.increment = increment;
    }

    void increaseAndMax() {
        this.count += increment;
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
}
