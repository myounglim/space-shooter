package model;

import utility.Position;

import java.io.File;

/**
 * Enemy that follows that player
 */
public class EnemyFollower extends Enemy {
    public EnemyFollower(Position pos, File file, float speed) {
        super(pos, file, speed);
    }

    /** TODO */
    public void followPlayer() {

    }

    public void moveForward() {
        this.position.moveLeft(2);
    }
}
