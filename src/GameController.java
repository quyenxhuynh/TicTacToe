import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;


public class GameController {
    @FXML
    private Button b00, b01, b02, b10, b11, b12, b20, b21, b22;

    @FXML
    private Button restartButton;

    @FXML
    private Label winnerLabel;

    private final int ROWS = 3;
    private final int COLUMNS = 3;
    private String[][] board = new String[][] {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };
    private String turn = "x";
    private int playsMade = 0;

    /**
     * Handles all game buttons; changes turn
     * @param event
     */
    @FXML
    private void gameButtonHandler(ActionEvent event) {
        Button b = (Button) (event.getSource());
        b.setText(turn);
        b.setVisible(true);
        b.setDisable(true);

        int x = Integer.parseInt(b.getId().substring(1, 2));
        int y = Integer.parseInt(b.getId().substring(2, 3));
        board[x][y] = turn;

        if (++playsMade == 9) {
            winnerLabel.setText("It's a tie!");
        }
        else {
            nextTurn();
            String winner = getWinner(x, y);
            if (!winner.equals(" ")) {
                winnerLabel.setText(winner.toUpperCase() + " wins!");
                disableAllButtons();
            }
        }
    }

    /**
     * Handles restart button; restarts the game board
     * @param event
     * @throws IOException
     */
    @FXML
    private void restartButtonHandler(ActionEvent event) throws IOException {
        if (event.getSource() == restartButton) {
            Stage stage = (Stage) restartButton.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("game.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    /**
     * Disables all the game board buttons
     */
    private void disableAllButtons() {
        b00.setDisable(true);
        b01.setDisable(true);
        b02.setDisable(true);
        b10.setDisable(true);
        b11.setDisable(true);
        b12.setDisable(true);
        b20.setDisable(true);
        b21.setDisable(true);
        b22.setDisable(true);
    }

    /**
     * Invokes other methods to determine who won; returns " " if there is no winner (thus far)
     * @param x x-coordinate of most-recent play
     * @param y y-coordinate of most-recent play
     * @return winning player
     */
    private String getWinner(int x, int y) {
        if (!checkRow(x).equals(" ")) {
            return checkRow(x);
        } else if (!checkColumn(y).equals(" ")) {
            return checkColumn(y);
        } else if (!checkDiagonals().equals(" ")){
            return checkDiagonals();
        } else {
            return " ";
        }
    }

    /**
     * Checks the row of most recent play to see if there is a 3-in-a-row
     * @param x x-coordinate of most recent play
     * @return winner of the row if exists
     */
    private String checkRow(int x) {
        String prev = board[x][0];
        for (int i = 1; i < ROWS; i++) {
            if (!prev.equals(board[x][i])) {
                return " ";
            }
        }
        return prev;
    }

    /**
     * Checks column of most recent play to see if there is a 3-in-a-column
     * @param y y-coordinate of most recent play
     * @return winner of the column if it exists
     */
    private String checkColumn(int y) {
        String prev = board[0][y];
        for (int i = 1; i < COLUMNS; i++) {
            if (!prev.equals(board[i][y])) {
                return " ";
            }
        }
        return prev;
    }

    /**
     * Checks two possible cases of winning via diagonals
     * @return winner of diagonal if it exists
     */
    private String checkDiagonals() {
        String prev = board[0][0];
        if (board[1][1].equals(prev) && board[2][2].equals(prev)) {
            return prev;
        }
        prev = board[0][2];
        if (board[1][1].equals(prev) && board[2][0].equals(prev)) {
            return prev;
        }
        return " ";
    }

    /**
     * Changes the turn variable, updates the turn label
     */
    private void nextTurn() {
        if (turn.equals("x")) {
            turn = "o";
        } else {
            turn = "x";
        }
        winnerLabel.setText("Current turn: " + turn.toUpperCase());
    }
}
