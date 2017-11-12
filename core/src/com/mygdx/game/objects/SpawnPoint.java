package com.mygdx.game.objects;

/**
 * Created by Elias on 12.11.2017.
 */

public class SpawnPoint {
    private int x;
    private int y;

    public SpawnPoint (int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
