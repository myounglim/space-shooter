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
import model.Goal;
import model.PlayerShip;
import model.ShootingObject;
import utility.Position;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * PlayerController to control the player
 */

public class PlayerController extends Controller implements Initializable {
    ImageView player_ship_image;
    ImageView laserView;
    PlayerShip mPlayerShip;
    ShootingObject laser;
    Goal goal;
    ImageView goalView;
    public static final float INITIAL_X_POS = 10;
    public static final float INITIAL_Y_POS = Main.WINDOW_HEIGHT / 2;
    private Label scoreLabel, lifeLabel, scoreText, lifeText, levelLabel, levelText;
    private Label introLabel, goalLabel, instructionLabel, enterLabel;
    static boolean gameStarted = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mPlayerShip = new PlayerShip(
                new Position(INITIAL_X_POS, INITIAL_Y_POS),
                new File("src/images/player2.png"),
                0);
        player_ship_image = setImage(mPlayerShip);
        setViewPosition(mPlayerShip, player_ship_image);
        addKeyListener();
        player_ship_image.setFocusTraversable(true);
        System.out.println("Bounds of my ship: " + player_ship_image.getBoundsInParent());
        setUpHeader();
        displayLives();
        displayScore();
        displayLevel();
        laser = mPlayerShip.getShooting();
        laserView = setImage(laser);
        setViewPosition(mPlayerShip.getShooting(), laserView);
        goal = new Goal(
                new Position(Main.WINDOW_WIDTH - 75, Main.WINDOW_HEIGHT / 2 - 50),
                new File("src/images/goal-flag1.png"),
                0);
        goalView = setImage(goal);
        setViewPosition(goal, goalView);
    }

    public ImageView getPlayerView() { return player_ship_image; }
    public PlayerShip getPlayerShip() { return this.mPlayerShip; }
    public ShootingObject getLaser() { return this.laser; }
    public ImageView getLaserView() { return this.laserView; }
    public ImageView getGoalView() { return this.goalView; }

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

    public void increaseScore(int score) { mPlayerShip.increaseScore(score); }

    public void displayLevel() { levelText.setText(Integer.toString(Main.level)); }

    private void setUpHeader() {
        scoreLabel = new Label("Score:");
        lifeLabel = new Label("Lives:");
        scoreText = new Label();
        lifeText = new Label();
        levelLabel = new Label("Level:");
        levelText = new Label();
        setUpLabelDisplay(lifeLabel, new Position(15, 10));
        setUpLabelDisplay(lifeText, new Position(110, 10));
        setUpLabelDisplay(scoreLabel, new Position(150, 10));
        setUpLabelDisplay(scoreText, new Position(240, 10));
        setUpLabelDisplay(levelLabel, new Position(Main.WINDOW_WIDTH - 200, 10));
        setUpLabelDisplay(levelText, new Position(Main.WINDOW_WIDTH - 100, 10));
        setUpInstructions();
    }

    private void setUpInstructions() {
        introLabel = new Label("Welcome to Space Shooter!");
        goalLabel = new Label("Your goal is to reach the safezone flag");
        instructionLabel = new Label("Press arrow keys to move and space to shoot");
        enterLabel = new Label("Press enter to start the game");
        setUpLabelDisplay(introLabel, new Position(Main.WINDOW_WIDTH / 4, Main.WINDOW_HEIGHT / 2 - 90));
        setUpLabelDisplay(goalLabel, new Position(Main.WINDOW_WIDTH / 4, Main.WINDOW_HEIGHT / 2 - 60));
        setUpLabelDisplay(instructionLabel, new Position(Main.WINDOW_WIDTH / 4, Main.WINDOW_HEIGHT / 2 - 30));
        setUpLabelDisplay(enterLabel, new Position(Main.WINDOW_WIDTH / 4, Main.WINDOW_HEIGHT / 2));
    }

    private void startGameTimer() {
        Main.gameTimer.start();
    }


    private void addKeyListener() {
        player_ship_image.setOnKeyPressed(key -> {
            if (key.getCode().equals(KeyCode.UP)) {
                if (mPlayerShip.getPosition().getYPosition() > -5)
                    mPlayerShip.moveUp();
                //System.out.println("Y pos: " + mPlayerShip.getPosition().getYPosition());
            } else if (key.getCode().equals(KeyCode.DOWN)) {
                if (mPlayerShip.getPosition().getYPosition() < Main.WINDOW_HEIGHT - 70)
                    mPlayerShip.moveDown();
                //System.out.println("Y pos: " + mPlayerShip.getPosition().getYPosition());
            } else if (key.getCode().equals(KeyCode.RIGHT)) {
                if (mPlayerShip.getPosition().getXPosition() < Main.WINDOW_WIDTH - 70)
                    mPlayerShip.moveRight();
                //System.out.println("X pos: " + mPlayerShip.getPosition().getXPosition());
            } else if (key.getCode().equals(KeyCode.LEFT)) {
                if (mPlayerShip.getPosition().getXPosition() > -5)
                    mPlayerShip.moveLeft();
                //System.out.println("X pos: " + mPlayerShip.getPosition().getXPosition());
            } else if (key.getCode().equals(KeyCode.SPACE)) {
                if (!laser.isShooting()) {
                    positionLaser();
                    System.out.println("Pew Pew");
                }
            } else if (key.getCode().equals(KeyCode.ENTER)) {
                if (!gameStarted) {
                    removeInstructions(introLabel, goalLabel, instructionLabel, enterLabel);
                    startGameTimer();
                }
            }
            setViewPosition(mPlayerShip, player_ship_image);
        });
    }
}
