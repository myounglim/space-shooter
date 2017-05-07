package model;

import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Created by student on 5/6/17.
 */
public class Goal extends GameObject {
    public Goal(Position pos, File file, int index) {
        super(pos, file, index);
        this.dimension = new Dimension(50, 50);
    }
}
