package model;

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

    public GameObject(Position position, File imageFile) {
        this.position = position;
        this.imageFile = imageFile;
    }

    public File getImageFile() {
        return this.imageFile;
    }

    public Position getPosition() { return this.position; }

    public Dimension getDimension() { return this.dimension; }
}
