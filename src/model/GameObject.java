package model;

import controller.Main;
import javafx.geometry.Bounds;
import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Base object for all objects in the game
 */
public abstract class GameObject {
    Position position;
    File imageFile;
    Dimension dimension;
    int index;
    Position initialPosition;

    public GameObject(Position position, File imageFile, int index) {
        this.position = position;
        this.imageFile = imageFile;
        this.index = index;
        this.initialPosition = new Position(position.getXPosition(), position.getYPosition());
    }

    public File getImageFile() {
        return this.imageFile;
    }

    public Position getPosition() { return this.position; }

    public Position getInitialPosition() { return this.initialPosition; }

    public Dimension getDimension() { return this.dimension; }

    public int getIndex() { return this.index; }

    public void resetPosition() {
        position = new Position(initialPosition.getXPosition(), initialPosition.getYPosition());
    }

    public boolean outOfBounds() {
        float x = this.getPosition().getXPosition();
        float y = this.getPosition().getYPosition();
        return (x < -50 || y < -50);
    }

    public boolean obstacleOutOfBounds() {
        float x = this.getPosition().getXPosition();
        float y = this.getPosition().getYPosition();
        return (y > Main.WINDOW_HEIGHT + 10);
    }
}
