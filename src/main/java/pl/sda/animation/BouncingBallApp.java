package pl.sda.animation;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@FunctionalInterface
interface Operation {
    double apply(double a, double b);
}

class BallHandler implements EventHandler<MouseEvent> {
    // ćwiczenie na ogarnięcie lambdy
    Operation add = (a, b) -> a + b;
    Operation diff = (a, b) -> a - b;
    Operation mult = (a, b) -> a * b;
    Operation div = (a, b) -> a / b;
    List<Operation> operations = new ArrayList<>(List.of(add, diff, mult, div));

    private Circle ball;
    private Scene scene;

    public BallHandler(Circle ball,Scene scene) {
        this.ball = ball;
        this.scene = scene;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Thread animation = new Thread(new BouncingBallAnimation(ball, scene));
        animation.start();
    }
}

public class BouncingBallApp extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 600, 800);
        scene.setFill(Color.BLACK);

        Circle ball = new Circle(300, 400, 50, Color.ORANGE);


//         ball.setOnMouseClicked(new BallHandler(ball, scene));        -> stary sposób na robienie tego bez użycia lambdy
//                                                                      przy użyciu klasy jawnie zadeklarowanej (na górze)
        // sposób z użyciem klasy anonimowej
//        ball.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent mouseEvent) {
//                Thread animation = new Thread(new BouncingBallAnimation(ball, scene));
//                animation.start();
//            }
        //lambdy można użyć do implementacji interfejsu funkcyjnego, czyli z jedną metodą (ewentualnie klas abstrakcyjnych z
        // jedną metodą)!!

        ExecutorService service = Executors.newSingleThreadExecutor();
        Button buttonStart = new Button("START");
        Button buttonStop = new Button("STOP");
        buttonStop.setLayoutX(60);

        AtomicBoolean isAnimationStarted = new AtomicBoolean(false);
        buttonStart.setOnAction(event -> {
            if (!service.isShutdown()) {
                buttonStart.setDisable(true);
                isAnimationStarted.set(true);
                service.execute(new BouncingBallAnimation(ball, scene));
            }
        });
        buttonStop.setOnAction(event -> {
            if (isAnimationStarted.get()) {
                service.shutdownNow();
            }
        });

        root.getChildren().addAll(ball, buttonStart, buttonStop);
        stage.setScene(scene);
        stage.show();
    }
}
