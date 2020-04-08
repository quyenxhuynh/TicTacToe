import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Starts the program with the main screen
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tic-Tac-Toe");

        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene s = new Scene(root, 600, 400);
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
