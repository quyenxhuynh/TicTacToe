import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class GameController {
    @FXML
    private Button b00, b01, b02, b10, b11, b12, b20, b21, b22;

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

    private String checkRow(int x) {
        String prev = board[x][0];
        for (int i = 1; i < ROWS; i++) {
            if (!prev.equals(board[x][i])) {
                return " ";
            }
        }
        return prev;
    }

    private String checkColumn(int y) {
        String prev = board[0][y];
        for (int i = 1; i < COLUMNS; i++) {
            if (!prev.equals(board[i][y])) {
                return " ";
            }
        }
        return prev;
    }

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

    private void nextTurn() {
        if (turn.equals("x")) {
            turn = "o";
        } else {
            turn = "x";
        }
        winnerLabel.setText("Current turn: " + turn.toUpperCase());
    }
}
