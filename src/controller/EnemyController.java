package controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.EnemyFollower;
import utility.Position;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by student on 5/5/17.
 */
public class EnemyController extends Controller implements Initializable {
    EnemyFollower mEnemyFollower;
    ImageView followerView;
    //Pane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mEnemyFollower = new EnemyFollower(new Position(750, 200), new File("src/images/enemy1.png"), 1.5f);
        setImage();
        setPosition();
    }

    private void setImage() {
        Image image = new Image(mEnemyFollower.getImageFile().toURI().toString());
        followerView = new ImageView(image);
        followerView.setFitWidth(mEnemyFollower.getDimension().getWidth());
        followerView.setFitHeight(mEnemyFollower.getDimension().getHeight());
        root.getChildren().add(followerView);
    }

    public void setPosition() {
        followerView.setY(mEnemyFollower.getPosition().getYPosition());
        followerView.setX(mEnemyFollower.getPosition().getXPosition());
    }

    public EnemyFollower getEnemyFollower() {
        return this.mEnemyFollower;
    }
}
