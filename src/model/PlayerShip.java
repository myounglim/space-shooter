package model;

import utility.Dimension;
import utility.Position;

import java.io.File;

/**
 * Class that player will control.
 */
public class PlayerShip extends GameObject {
    enum Item { EMPTY, BOMB, SHIELD }
    private Item item;
    private int numLives, currentScore;

    public PlayerShip(Position pos, File file, int index) {
        super(pos, file, index);
        this.dimension = new Dimension(75, 75);
        this.item = Item.EMPTY;
        this.numLives = 3;
        this.currentScore = 0;
    }

    /** TODO */
    public void move() {

    }

    public void moveUp() {
        this.position.moveUp(10);
    }

    public void moveDown() {
        this.position.moveDown(10);
    }

    public void moveRight() {
        this.position.moveRight(10);
    }
    public void moveLeft() {
        this.position.moveLeft(10);
    }
}
