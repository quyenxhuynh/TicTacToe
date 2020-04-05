import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    private Button button;

    @FXML
    private void startButtonClicked(ActionEvent event) throws IOException {
        if (event.getSource() == button) {
            Stage stage = (Stage) button.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
