package controller;

import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import model.Obstacle;
import utility.Position;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by student on 5/6/17.
 */
public class ObstacleController extends Controller implements Initializable {
    private ArrayList<Obstacle> mObstacles;
    private ArrayList<ImageView> mObstacleView;
    public static final int NUM_OBSTACLES = 1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mObstacles = new ArrayList<>();
        mObstacleView = new ArrayList<>();
        initializeAsteroids();
    }

    private void initializeAsteroids() {
        float speed = 1.0f;
        for (int i = 0; i < NUM_OBSTACLES; i++) {
            mObstacles.add(new Obstacle(
                    new Position(Main.WINDOW_WIDTH / 2 + i * 50, -10),
                    new File("src/images/asteroid3.png"),
                    i,
                    speed,
                    true,
                    45.0f
            ));
            mObstacleView.add(setImage(mObstacles.get(i)));
            setViewPosition(mObstacles.get(i), mObstacleView.get(i));
            speed += 0.5;
        }
    }
}
