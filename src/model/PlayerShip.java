package model;

import controller.Main;
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
    private ShootingObject shooting;

    public PlayerShip(Position pos, File file, int index) {
        super(pos, file, index);
        this.dimension = new Dimension(75, 75);
        this.item = Item.EMPTY;
        this.numLives = 3;
        this.currentScore = 0;
        this.shooting = new ShootingObject(
                new Position(pos.getXPosition(), Main.WINDOW_WIDTH + 50),
                new File("src/images/yellow-green.png"),
                0, 3f);
    }

    public int getLives() { return numLives; }
    public int getCurrentScore() { return this.currentScore; }
    public void decreaseLife() { this.numLives--; }
    public void increaseScore() { this.currentScore += 10; }
    public ShootingObject getShooting() { return this.shooting; }

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
