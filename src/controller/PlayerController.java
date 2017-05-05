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
        mPlayerShip = new PlayerShip(new Position(10, 200), new File("src/images/player2.png"));
        setImage();
        setPosition();
        addKeyListener();
        player_ship_image.setFocusTraversable(true);
        System.out.println("Bounds of my ship: " + player_ship_image.getBoundsInParent());
    }

    public Bounds getPlayerBounds() {
        return player_ship_image.getBoundsInParent();
    }

    private void setPosition() {
        player_ship_image.setY(mPlayerShip.getPosition().getYPosition());
        player_ship_image.setX(mPlayerShip.getPosition().getXPosition());
    }

    private void setImage() {
        Image image = new Image(mPlayerShip.getImageFile().toURI().toString());
        player_ship_image = new ImageView(image);
        player_ship_image.setFitWidth(mPlayerShip.getDimension().getWidth());
        player_ship_image.setFitHeight(mPlayerShip.getDimension().getHeight());
        root.getChildren().add(player_ship_image);
    }

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
                setPosition();
            }
        });
    }
}
