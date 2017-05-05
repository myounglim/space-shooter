package model;

import utility.Position;

import java.io.File;

/**
 * Obstacle class that player must avoid
 */
public class Obstacle extends GameObject {
    boolean destructible;
    float angle;
    public Obstacle(Position pos, File file, boolean destructible, float angle) {
        super(pos, file);
        this.destructible = destructible;
        this.angle = angle;
    }

    /** TODO */
    public void move() {

    }
}
