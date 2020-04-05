public class Board {
    private static final int ROWS = 5;
    private static final int COLUMNS = 5;
    private static char[][] board = new char[ROWS][COLUMNS];
    private static char turn = 'x';

    public Board() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public Board(char[] board) {
        for (int i = 0; i < board.length; i++) {
            Board.board[i / ROWS][i % COLUMNS] = board[i];
        }
    }

    public char[][] add(int x, int y) {
        if (board[x][y] == ' ') {
            board[x][y] = turn;
            nextTurn();
        }
        return board;
    }

    public boolean checkDiagonals() {
        //TODO: we could brute force it - there's only 8 cases

        return false;
    }

    public boolean checkColumns() {
        int count = 1;
        char prev = '0'; // null
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[j][i] == prev) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
                prev = board[i][j];
            }
            count = 1;
        }
        return false;
    }

    public boolean checkRows() {
        int count = 1;
        char prev = '0'; // null
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (board[i][j] == prev && board[i][j] != ' ') {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
                prev = board[i][j];
            }
            count = 1;
        }
        return false;
    }

    private void nextTurn(){
        if (turn == 'x') {
            turn = 'o';
        }
        else {
            turn = 'x';
        }
    }

    public void printBoard() {
        System.out.println(this);
    }

    public String toString() {
        StringBuilder s = new StringBuilder("");
        s.append("---------------------\n");
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                s.append("| ").append(board[i][j]).append(" ");
                if (j == COLUMNS - 1) {
                    s.append("|");
                }
            }
            s.append("\n---------------------\n");
        }
        return s.toString();
    }
}
