package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.GameObject;
import model.PlayerShip;
import model.ShootingObject;
import utility.Position;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerController extends Controller implements Initializable {
    ImageView player_ship_image;
    ImageView laserView;
    PlayerShip mPlayerShip;
    ShootingObject laser;
    public static final float INITIAL_X_POS = 10;
    public static final float INITIAL_Y_POS = Main.WINDOW_HEIGHT / 2;
    private Label scoreLabel, lifeLabel, scoreText, lifeText;
    //Pane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mPlayerShip = new PlayerShip(
                new Position(INITIAL_X_POS, INITIAL_Y_POS),
                new File("src/images/player2.png"),
                0);
        //setImage();
        player_ship_image = setImage(mPlayerShip);
        setViewPosition(mPlayerShip, player_ship_image);
        addKeyListener();
        player_ship_image.setFocusTraversable(true);
        System.out.println("Bounds of my ship: " + player_ship_image.getBoundsInParent());
        setUpHeader();
        displayLives();
        displayScore();
        laser = mPlayerShip.getShooting();
        laserView = setImage(laser);
        setViewPosition(mPlayerShip.getShooting(), laserView);
    }

    public ImageView getPlayerView() { return player_ship_image; }
    public PlayerShip getPlayerShip() { return this.mPlayerShip; }
    public ShootingObject getLaser() { return this.laser; }
    public ImageView getLaserView() { return this.laserView; }

    public void resetPlayerPosition() {
        resetPosition(mPlayerShip);
        setViewPosition(mPlayerShip, player_ship_image);
    }

    public void positionLaser() {
        Position playerPosition = mPlayerShip.getPosition();
        laser.getPosition().moveTo(
                new Position(playerPosition.getXPosition() + 75/2, playerPosition.getYPosition() + 75/2));
        laser.setToShootingMode(true);
        setViewPosition(laser, laserView);
    }

    public void shootLaser() {
        laser.projectForward();
        setViewPosition(laser, laserView);
    }

    public void displayLives() { lifeText.setText(Integer.toString(mPlayerShip.getLives())); }

    public void decreaseLife() { mPlayerShip.decreaseLife(); }

    public void displayScore() { scoreText.setText(Integer.toString(mPlayerShip.getCurrentScore())); }

    public void increaseScore() { mPlayerShip.increaseScore(); }

    private void setUpHeader() {
        scoreLabel = new Label("Score:");
        lifeLabel = new Label("Lives:");
        scoreText = new Label();
        lifeText = new Label();
        setUpLabelDisplay(lifeLabel, new Position(15, 10));
        setUpLabelDisplay(lifeText, new Position(60, 10));
        setUpLabelDisplay(scoreLabel, new Position(120, 10));
        setUpLabelDisplay(scoreText, new Position(160, 10));
    }

    private void addKeyListener() {
        player_ship_image.setOnKeyPressed(key -> {
            if (key.getCode().equals(KeyCode.UP)) {
                mPlayerShip.moveUp();
                System.out.println("Y pos: " + mPlayerShip.getPosition().getYPosition());
            } else if (key.getCode().equals(KeyCode.DOWN)) {
                mPlayerShip.moveDown();
                System.out.println("Y pos: " + mPlayerShip.getPosition().getYPosition());
            } else if (key.getCode().equals(KeyCode.RIGHT)) {
                mPlayerShip.moveRight();
                System.out.println("X pos: " + mPlayerShip.getPosition().getXPosition());
            } else if (key.getCode().equals(KeyCode.LEFT)) {
                mPlayerShip.moveLeft();
                System.out.println("X pos: " + mPlayerShip.getPosition().getXPosition());
            } else if (key.getCode().equals(KeyCode.SPACE)) {
                if (!laser.isShooting()) {
                    positionLaser();
                    System.out.println("Pew Pew");
                }
            }
            setViewPosition(mPlayerShip, player_ship_image);
        });
    }
}
