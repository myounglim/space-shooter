package model;

import java.io.File;

/**
 * Class that player will control.
 */
public class PlayerShip extends GameObject {
    enum Item { EMPTY, BOMB, SHIELD }
    private Item item;
    private int numLives, currentScore;

    public PlayerShip(Position pos, File file) {
        super(pos, file);
        this.dimension = new Dimension(30, 30);
        this.item = Item.EMPTY;
        this.numLives = 3;
        this.currentScore = 0;
    }

    /** TODO */
    public void move() {

    }
}
