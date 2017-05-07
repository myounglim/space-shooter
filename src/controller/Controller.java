package controller;

import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import model.GameObject;
import utility.Position;

/**
 * Created by student on 5/5/17.
 */
public abstract class Controller {
    Pane root;
    public void setRoot(Pane root) {
        this.root = root;
    }

    public ImageView setImage(GameObject object) {
        Image image = new Image(object.getImageFile().toURI().toString());
        ImageView view = new ImageView(image);
        view.setFitWidth(object.getDimension().getWidth());
        view.setFitHeight(object.getDimension().getHeight());
        root.getChildren().add(view);
        return view;
    }

    public void setViewPosition(GameObject object, ImageView view) {
        view.setY(object.getPosition().getYPosition());
        view.setX(object.getPosition().getXPosition());
    }

    public void resetPosition(GameObject obj) {
        obj.resetPosition();
    }

    public void setUpLabelDisplay(Label label, Position pos) {
        label.setLayoutX(pos.getXPosition());
        label.setLayoutY(pos.getYPosition());
        label.setFont(new Font("Courier New", 25));
        label.setTextFill(Color.ANTIQUEWHITE);
        root.getChildren().add(label);
    }

//    public Bounds getBounds(ImageView obj) {
//        return obj.getBoundsInParent();
//    }
}
