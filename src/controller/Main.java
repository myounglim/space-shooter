package controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    AnimationTimer gameTimer;
    Pane root;
    PlayerController playerController;
    EnemyController enemyController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        playerController = new PlayerController();
        playerController.setRoot(root);
        playerController.initialize(null, null);
        enemyController = new EnemyController();
        enemyController.setRoot(root);
        enemyController.initialize(null, null);
        primaryStage.setTitle("Space Shooter");
        primaryStage.setScene(new Scene(root, 950, 500));
        primaryStage.show();
        startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void startGame() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                enemyController.getEnemyFollower().moveForward();
                enemyController.setPosition();
            }
        };

        gameTimer.start();
    }
}
