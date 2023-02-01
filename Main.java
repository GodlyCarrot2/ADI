import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        //Runs game functions
        Board.gameStart();
        Board.randomColors();
        Board.displayBoard();
        Board.gameTurn();
    }
}