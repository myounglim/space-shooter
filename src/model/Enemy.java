package model;

import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Abstract enemy class that will be the parent class for all enemies
 */
public abstract class Enemy extends GameObject {
    float speed;
    public Enemy(Position pos, File file, float speed) {
        super(pos, file);
        this.speed = speed;
        this.dimension = new Dimension(75, 75);
    }
}
