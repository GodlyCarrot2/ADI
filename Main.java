import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Board.gameStart();
        Board.randomColors();
        Board.displayBoard();
        for (int x = 0; x < 6; x++) {
        Board.gameTurn();}
        
    }
}