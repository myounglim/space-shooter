package model;

import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Abstract enemy class that will be the parent class for all enemies
 */
public abstract class Enemy extends GameObject {
    float speed;
    public Enemy(Position pos, File file, int index, float speed) {
        super(pos, file, index);
        this.speed = speed;
        this.dimension = new Dimension(75, 75);
    }

    public void moveForward() {
        this.position.moveLeft(speed);
    }
}
