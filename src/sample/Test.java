package sample;

public class Test {
    public static void main(String[] args) {
        Board b = new Board();
        b.printBoard();

        b.add(0, 1);
        b.add(0, 2);
        b.add(0, 3);
        b.add(0, 4);

        b.printBoard();
    }
}
