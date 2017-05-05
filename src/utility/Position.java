package utility;

/**
 * Created by student on 5/4/17.
 */
public class Position {
    int x, y;
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    public void moveLeft(int off) { this.x -= off; }
    public void moveRight(int off) { this.x += off; }
    public void moveUp(int off) { this.y -= off; }
    public void moveDown(int off) { this.y += off; }
    public int getYPosition() { return this.y; }
    public int getXPosition() { return this.x; }
}
