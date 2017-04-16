package model;

import java.io.File;

/**
 * Base object for all objects in the game
 */
public abstract class GameObject {
    class Position {
        int x, y;
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void moveTo(Position position) {
            this.x = position.x;
            this.y = position.y;
        }

        public void moveLeft() { this.x--; }
        public void moveRight() { this.x++; }
        public void moveUp() { this.y--; }
        public void moveDown() { this.y++; }
    }
    class Dimension {
        int width, height;
        public Dimension(int height, int width) {
            this.width = width;
            this.height = height;
        }
    }
    Position position;
    File imageFile;
    Dimension dimension;

    public GameObject(Position position, File imageFile) {
        this.position = position;
        this.imageFile = imageFile;
    }
}
