package utility;

/**
 * Created by student on 5/4/17.
 */
public class Position {
    float x, y;
    public Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(Position newPosition) {
        this.x = newPosition.x;
        this.y = newPosition.y;
    }

    public void moveLeft(float off) { this.x -= off; }
    public void moveRight(float off) { this.x += off; }
    public void moveUp(float off) { this.y -= off; }
    public void moveDown(float off) { this.y += off; }
    public float getYPosition() { return this.y; }
    public float getXPosition() { return this.x; }
}
