package pl.sda.animation;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;

public class BouncingBallAnimation implements Runnable{
    private Circle ball;
    private Scene scene;
    private double dx, dy;
    Random random = new Random();

    public BouncingBallAnimation(Circle ball, Scene scene) {
        this.ball = ball;
        this.scene = scene;
        dx = 2;
        dy = 2;
        }

    @Override
    public void run() {
        Thread thisThread = Thread.currentThread();
        // wątek będzie można przerwać wysyłając do wątku interrupt()
        while (!thisThread.isInterrupted()) {
        if (ball.getCenterY() + ball.getRadius() + 1 > scene.getHeight()
        || ball.getCenterY() - ball.getRadius() - 1 < 0) {
            dy *= -1;
            ball.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }
        if (ball.getCenterX() + ball.getRadius() + 1 > scene.getWidth()
        || ball.getCenterX() + ball.getRadius() - 1 < 0) {
            dx *= -1;
            ball.setFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
        }
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            thisThread.interrupt();
        }
            Platform.runLater(() -> {
                ball.setCenterX(ball.getCenterX() + dx);
                ball.setCenterY(ball.getCenterY() + dy);
            });
        }
        System.out.println("Koniec animacji");
    }
}
