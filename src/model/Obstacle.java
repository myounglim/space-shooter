package model;

import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Obstacle class that player must avoid
 */
public class Obstacle extends GameObject {
    boolean destructible;
    float angle;
    float speed;
    public Obstacle(Position pos, File file, int index, float speed, boolean destructible, float angle) {
        super(pos, file, index);
        this.speed = speed;
        this.destructible = destructible;
        this.angle = angle;
        this.dimension = new Dimension(50, 50);
    }

    /** TODO */
    public void move() {

    }
}
