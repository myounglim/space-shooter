package model;

import controller.Main;
import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Created by student on 5/5/17.
 */
public class ShootingObject extends GameObject {
    float speed;
    boolean isShooting;

    public ShootingObject(Position pos, File file, int index, float speed) {
        super(pos, file, index);
        this.speed = speed;
        this.dimension = new Dimension(10, 25);
        isShooting = false;
    }

    public void projectForward() {
        this.position.moveRight(speed);
    }

    public void setLaserOutOfBounds() {
        this.getPosition().moveTo(new Position(Main.WINDOW_WIDTH, 0));
    }

    public void setToShootingMode(boolean mode) { isShooting = mode; }
    public boolean isShooting() { return isShooting; }
    public boolean laserOutOfBounds() {
        float x = this.getPosition().getXPosition();
        //float y = this.getPosition().getYPosition();
        return (x > Main.WINDOW_WIDTH);
    }
}
