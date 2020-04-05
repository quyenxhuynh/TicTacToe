import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class GameController {
    @FXML
    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

    private String turn = "x";

    @FXML
    private void gameButtonHandler(ActionEvent event) {
        if (event.getSource() == b1) {
            b1.setText(turn);
            b1.setVisible(true);
        }

        nextTurn();
    }

    private void nextTurn() {
        if (turn.equals("x")) {
            turn = "o";
        } else {
            turn = "x";
        }
    }
}
