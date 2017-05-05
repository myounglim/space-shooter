package model;

import utility.Position;

import java.io.File;

/**
 * Obstacle class that player must avoid
 */
public class Obstacle extends GameObject {
    boolean destructible;
    float angle;
    public Obstacle(Position pos, File file, int index, boolean destructible, float angle) {
        super(pos, file, index);
        this.destructible = destructible;
        this.angle = angle;
    }

    /** TODO */
    public void move() {

    }
}
