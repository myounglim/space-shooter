package controller;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import model.GameObject;
import model.PlayerShip;
import utility.Position;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerController extends Controller implements Initializable {
    ImageView player_ship_image;
    PlayerShip mPlayerShip;
    //Pane root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        mPlayerShip = new PlayerShip(
                new Position(10, Main.WINDOW_HEIGHT / 2),
                new File("src/images/player2.png"),
                0);
        //setImage();
        player_ship_image = setImage(mPlayerShip);
        setPosition(mPlayerShip, player_ship_image);
        addKeyListener();
        player_ship_image.setFocusTraversable(true);
        System.out.println("Bounds of my ship: " + player_ship_image.getBoundsInParent());
    }

    public ImageView getPlayerView() { return player_ship_image; }

    private void addKeyListener() {
        player_ship_image.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent key) {
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
                }
                setPosition(mPlayerShip, player_ship_image);
            }
        });
    }
}
