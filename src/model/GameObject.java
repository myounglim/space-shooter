package model;

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

    public GameObject(Position position, File imageFile, int index) {
        this.position = position;
        this.imageFile = imageFile;
        this.index = index;
    }

    public File getImageFile() {
        return this.imageFile;
    }

    public Position getPosition() { return this.position; }

    public Dimension getDimension() { return this.dimension; }

    public int getIndex() { return this.index; }

}
