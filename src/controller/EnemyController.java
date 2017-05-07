package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EnemyFollower;
import model.EnemyShooter;
import model.GameObject;
import utility.Position;
import model.Enemy;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by student on 5/5/17.
 */
public class EnemyController extends Controller implements Initializable {
    private ArrayList<Enemy> mEnemies;
    private ArrayList<ImageView> mEnemiesView;
    public static final int NUM_FOLLOWERS = 3;
    public static final int NUM_SHOOTERS = 2;
    public static final int[] Y_ALIGNED = {30, 290, 550, 160, 420};
    //Pane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mEnemies = new ArrayList<>();
        mEnemiesView = new ArrayList<>();
        initializeEnemies();
//        mEnemyFollower = new EnemyFollower(new Position(750, 200), new File("src/images/enemy1.png"), 1.5f);
//        followerView = setImage(mEnemyFollower);
//        setPosition(mEnemyFollower, followerView);
    }

    private void initializeEnemies() {
        initializeFollowers();
        initializeShooters();
    }

    private void initializeFollowers() {
        float speed = 1.0f;
        for (int i = 0; i < NUM_FOLLOWERS; i++) {
            mEnemies.add(new EnemyFollower(
                    new Position(Main.WINDOW_WIDTH + i * 50, Y_ALIGNED[i]),
                    new File("src/images/enemy1.png"),
                    i,
                    speed));
            mEnemiesView.add(setImage(mEnemies.get(i)));
            setViewPosition(mEnemies.get(i), mEnemiesView.get(i));
            speed += 1.0;
        }
    }

    private void initializeShooters() {
        float speed = 1.0f;
        for (int i = NUM_FOLLOWERS; i < NUM_FOLLOWERS + NUM_SHOOTERS; i++) {
            mEnemies.add(new EnemyShooter(
                    new Position(Main.WINDOW_WIDTH + i * 50, Y_ALIGNED[i]),
                    new File("src/images/enemy2.png"),
                    i, speed));
            mEnemiesView.add(setImage(mEnemies.get(i)));
            setViewPosition(mEnemies.get(i), mEnemiesView.get(i));
            speed += 1.0;
        }
    }


    public void resetEnemyPosition(Enemy enemy, ImageView enemyView) {
        resetPosition(enemy);
        setViewPosition(enemy, enemyView);
    }

    public Enemy getEnemy(int index) {
        return this.mEnemies.get(index);
    }

    public ImageView getEnemyView(int index) {
        return this.mEnemiesView.get(index);
    }
}
