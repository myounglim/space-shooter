package model;

import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Goal for the player to reach
 */
public class Goal extends GameObject {
    public Goal(Position pos, File file, int index) {
        super(pos, file, index);
        this.dimension = new Dimension(50, 50);
    }
}
