package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    Label placeholder;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Tic Tac Toe");

        Label text = new Label("Let's play tic-tac-toe!");
        placeholder = new Label("");
        placeholder.setVisible(true);

        Button button = new Button("Start Game");
        button.setOnAction(new ButtonHandler());


        FlowPane pane = new FlowPane();
        pane.getChildren().addAll(text, button, placeholder);

        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            placeholder.setVisible(true);
            placeholder.setText("START");
        }
    }
}
