package controller;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import model.Enemy;
import model.EnemyFollower;
import model.GameObject;
import model.Obstacle;

public class Main extends Application {
    public static final int WINDOW_WIDTH = 1250;
    public static final int WINDOW_HEIGHT = 650;
    public static final int WINDOW_DIVISION = 650 / 5;
    AnimationTimer gameTimer;
    Pane root;
    PlayerController playerController;
    EnemyController enemyController;
    ObstacleController obstacleController;

    @Override
    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        initializeControllers();
        primaryStage.setTitle("Space Shooter");
        primaryStage.setScene(new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT));
        primaryStage.show();
        BackgroundImage myBI = new BackgroundImage(new Image("https://ak8.picdn.net/shutterstock/videos/14996698/thumb/1.jpg"),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        //then you set to your node
        root.setBackground(new Background(myBI));
        startGame();
    }

    public void startGame() {
        gameTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                for (int i = 0; i < EnemyController.NUM_FOLLOWERS + EnemyController.NUM_SHOOTERS; i++) {
                    enemyController.getEnemy(i).moveForward();
                    enemyController.setViewPosition(enemyController.getEnemy(i), enemyController.getEnemyView(i));
                    if (collisionDetected(playerController.getPlayerView(), enemyController.getEnemyView(i))) {
                        resetAfterCollision(i, true);
                    }
                    checkOutOfBounds(i);
                }
                if (playerController.getLaser().isShooting()) {
                    for (int i = 0; i < EnemyController.NUM_FOLLOWERS + EnemyController.NUM_SHOOTERS; i++) {
                        if (targetHit(enemyController.getEnemyView(i), playerController.getLaserView())) {
                            resetAnEnemy(i);
                            playerController.getLaser().setToShootingMode(false);
                            playerController.getLaser().setLaserOutOfBounds();
                        }
                    }
                    if (playerController.getLaser().laserOutOfBounds()) {
                        playerController.getLaser().setToShootingMode(false);
                    }
                    playerController.shootLaser();
                }

                for (int i = 0; i < ObstacleController.NUM_OBSTACLES; i++) {
                    obstacleController.getObstacle(i).move();
                    obstacleController.setViewPosition(obstacleController.getObstacle(i), obstacleController.getObstacleView(i));
                    if (collisionDetected(playerController.getPlayerView(), obstacleController.getObstacleView(i))) {
                        resetAfterCollision(i, false);
                    }
                    checkObstacleOutOfBounds(i);
                }

            }
        };

        gameTimer.start();
    }

    private boolean collisionDetected(ImageView obj1, ImageView obj2) {
        Bounds bound1 = obj1.getBoundsInParent();
        Bounds bound2 = obj2.getBoundsInParent();
        double dx1 = (bound1.getMaxX() + bound1.getMinX()) / 2;
        double dy1 = (bound1.getMaxY() + bound1.getMinY()) / 2;
        double dx2 = (bound2.getMaxX() + bound2.getMinX()) / 2;
        double dy2 = (bound2.getMaxY() + bound2.getMinY()) / 2;
        double dx = Math.abs(dx2 - dx1);
        double dy = Math.abs(dy2 - dy1);
        double dxSquared = Math.pow(dx, 2);
        double dySquared = Math.pow(dy, 2);
        double result = Math.sqrt(dxSquared + dySquared);
        return result < 60;
    }

    private boolean targetHit(ImageView enemy, ImageView laser) {
        Bounds bound1 = enemy.getBoundsInParent();
        Bounds bound2 = laser.getBoundsInParent();
        double dx = Math.abs(bound1.getMinX() - bound2.getMaxX());
        double dy = Math.abs(bound1.getMaxY() - bound2.getMinY());
        //return bound2.getMaxY() < bound1.getMaxY() && bound2.getMaxY() > bound1.getMinY() && dx < 2.0;
        return dy < 75 && dx < 2.5;
    }

    private void checkOutOfBounds(int index) {
        Enemy enemy = enemyController.getEnemy(index);
        if (enemy.outOfBounds())
            resetAnEnemy(index);
    }

    private void checkObstacleOutOfBounds(int index) {
        Obstacle obstacle = obstacleController.getObstacle(index);
        if (obstacle.obstacleOutOfBounds())
            resetAnObstacle(index);
    }

    private void resetAnEnemy(int index) {
        enemyController.resetEnemyPosition(enemyController.getEnemy(index), enemyController.getEnemyView(index));
    }

    private void resetAnObstacle(int index) {
        obstacleController.resetObstaclePosition(obstacleController.getObstacle(index), obstacleController.getObstacleView(index));
    }

    private void resetAfterCollision(int index, boolean isEnemy) {
        System.out.println("Collision!");
        playerController.resetPlayerPosition();
        if (isEnemy) resetAnEnemy(index);
        else resetAnObstacle(index);
        playerController.decreaseLife();
        playerController.displayLives();
    }

    private void initializeControllers() {
        playerController = new PlayerController();
        playerController.setRoot(root);
        playerController.initialize(null, null);
        enemyController = new EnemyController();
        enemyController.setRoot(root);
        enemyController.initialize(null, null);
        obstacleController = new ObstacleController();
        obstacleController.setRoot(root);
        obstacleController.initialize(null, null);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
