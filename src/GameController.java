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
        if (event.getSource() == b2) {
            b2.setText(turn);
            b2.setVisible(true);
        }
        if (event.getSource() == b3) {
            b3.setText(turn);
            b3.setVisible(true);
        }
        if (event.getSource() == b4) {
            b4.setText(turn);
            b4.setVisible(true);
        }
        if (event.getSource() == b5) {
            b5.setText(turn);
            b5.setVisible(true);
        }
        if (event.getSource() == b6) {
            b6.setText(turn);
            b6.setVisible(true);
        }
        if (event.getSource() == b7) {
            b7.setText(turn);
            b7.setVisible(true);
        }
        if (event.getSource() == b8) {
            b8.setText(turn);
            b8.setVisible(true);
        }
        if (event.getSource() == b9) {
            b9.setText(turn);
            b9.setVisible(true);
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
