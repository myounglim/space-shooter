package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EnemyFollower;
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
    EnemyFollower mEnemyFollower;
    ImageView followerView;
    private ArrayList<Enemy> mFollowers;
    private ArrayList<ImageView> mFollowersView;
    public static final int NUM_FOLLOWERS = 3;
    //Pane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //mEnemyFollower = new EnemyFollower(new Position(750, 200), new File("src/images/enemy1.png"), 1.5f);
        mFollowers = new ArrayList<>();
        mFollowersView = new ArrayList<>();
        initializeEnemies();
//        followerView = setImage(mEnemyFollower);
//        setPosition(mEnemyFollower, followerView);
    }

    private void initializeEnemies() {
        float speed = 1.0f;
        for (int i = 0; i < NUM_FOLLOWERS; i++) {
            mFollowers.add(new EnemyFollower(
                    new Position(Main.WINDOW_WIDTH + i * 50, Main.WINDOW_HEIGHT / 2 + 100 * i),
                    new File("src/images/enemy1.png"),
                    i,
                    speed));
            mFollowersView.add(setImage(mFollowers.get(i)));
            setViewPosition(mFollowers.get(i), mFollowersView.get(i));
            speed += 1.0;
        }
    }


    public void resetEnemyPosition(Enemy enemy, ImageView enemyView) {
        resetPosition(enemy);
        setViewPosition(enemy, enemyView);
    }

    public Enemy getEnemy(int index) {
        return this.mFollowers.get(index);
    }

    public ImageView getEnemyView(int index) {
        return this.mFollowersView.get(index);
    }
}
