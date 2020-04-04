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


// SCENE SWITCHING RESOURCE: https://stackoverflow.com/questions/37200845/how-to-switch-scenes-in-javafx

public class Main extends Application {
    Label placeholder;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        primaryStage.setTitle("Tic-Tac-Toe");

        Scene s = new Scene(root, 500, 300);

        ScreenController screenController = new ScreenController(s);
        screenController.add("start", FXMLLoader.load(getClass().getResource( "start.fxml" )));
        screenController.add("game", FXMLLoader.load(getClass().getResource( "game.fxml" )));
        screenController.activate("start");

        primaryStage.setScene(s);

//
//        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }



    private class ButtonHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            placeholder.setVisible(true);
            placeholder.setText("START");
        }
    }
}
