import java.util.ArrayList;
import java.util.Scanner;

public class Board { // Sets up variables to be used across the board
    private static int dimension = 9;
    private static int numColors = 6;
    private static int[][] board = new int[dimension][dimension];
    private static ArrayList<Player> players = new ArrayList<Player>();
    private static Player currentPlayer;
    private static int turnCounter = 0;
    private static boolean continuePlaying = true;
    
    
    public static void gameStart() { //Sets names and initial square colors
        Player player1 = new Player(1);
        Player player2 = new Player(-1);
        player1.setName();
        System.out.println("Now it's the next players turn");
        player2.setName();
        players.add(player1);
        players.add(player2); 
    }

    public static final String RESET = "\u001B[0m"; //Color Codes for the board
    public static final String BLACK = "\u001B[40m";
    public static final String RED = "\u001B[41m";
    public static final String GREEN = "\u001B[42m";
    public static final String YELLOW = "\u001B[43m";
    public static final String BLUE = "\u001B[44m";
    public static final String PURPLE = "\u001B[45m";

    // Randomly populates colors across the board
    public static void randomColors() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
               board[i][j] = (int) (Math.random() * numColors);
            }
        }
    }

    // Displays Board
    public static void displayBoard() {
        String display = "";
        display += "\n";

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == 0) {
                    display += (RED + "  " + RESET);
                }
                else if (board[i][j] == 1) {
                    display += (BLACK + "  " + RESET);
                }
                else if (board[i][j] == 2) {
                    display += (GREEN + "  " + RESET);
                }
                else if (board[i][j] == 3) {
                    display += (YELLOW + "  " + RESET);
                }
                else if (board[i][j] == 4) {
                    display += (BLUE + "  " + RESET);
                }
                else if (board[i][j] == 5) {
                    display += (PURPLE + "  " + RESET);
                }
            }
            display += "\n";
        }
        System.out.println(display);
    }

    public static void checkColor(int a, int b, ArrayList<Tile> surface, int playerFactor) { //Recursively checks if a color is within the surface of a player
        int position;
        if (playerFactor == 1) {
            position = 0;
        }
        else {
            position = dimension -1;
        }
        try {
            if (board[a + playerFactor][b] == board[position][position]) {
                surface.add(new Tile(a+playerFactor, b));
                checkColor(a+playerFactor, b, surface, playerFactor);
            }
                if (board[a][b+playerFactor] == board[position][position]) {
                surface.add(new Tile(a, b+playerFactor));
                checkColor(b, a+playerFactor, surface, playerFactor);
            }
        }
        catch(Exception e) {}
    }

    public static ArrayList<Tile> recursiveCheck(Player player) { //Sets up the initial checkcolor square to initiate recursion
        ArrayList<Tile> surface = new ArrayList<Tile>();
        if (currentPlayer.getFactor() == 1) {
            surface.add(new Tile(0, 0));
            checkColor(0, 0, surface, player.getFactor());
        }
        else {
            surface.add(new Tile(dimension-1, dimension-1));
            checkColor(dimension-1, dimension-1, surface,player.getFactor());
        }

        return surface;
    }

    public static void gameTurn() { //Gameplay through a turn
        while (continuePlaying) {
        if (turnCounter % 2 == 0) {
            currentPlayer = players.get(0);
            System.out.println("It is " + players.get(0).getName() + "'s turn");
        }
        else {
            currentPlayer = players.get(1);
            System.out.println("It is " + players.get(1).getName() + "'s turn");
        }
        boolean isColor = true;
        int color = 0;
        while (isColor) {
            Scanner sc = new Scanner(System.in);
            System.out.println("What color would you like to change to?\n0 = red\n1 = black\n2 = green\n3 = yellow\n4 = blue\n5 = purple"); 
            color = sc.nextInt(); 
            if (color == board[0][0]|| color == board[dimension - 1][dimension - 1]) {
                System.out.println("That color is already taken");
                displayBoard();
            }
            else {
                isColor = false;
            }
        }
        
        ArrayList<Tile> surface = recursiveCheck(currentPlayer);

        if (currentPlayer.getFactor() == 1) {
            board[0][0] = color;
        }
        else {
            board[dimension - 1][dimension - 1] = color;
        }
        for (Tile tile : surface) {
            board[tile.getX()][tile.getY()] = color;
        }

        displayBoard();

        if (checkBoard()) {
            int player1Squares = 0;
            int player2Squares = 0;
            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (board[i][j] == board[0][0]) {
                        player1Squares++;
                    }
                    if (board[i][j] == board[dimension-1][dimension-1]) {
                        player2Squares++;
                    }
                }
            }
            if (player2Squares > player1Squares) {
                System.out.println("Congrats " + players.get(1).getName() + " you won!");
            }
            else {
                System.out.println("Congrats " + players.get(0).getName() + " you won!");
            }
            continuePlaying = false;
        }
       

        turnCounter++;
    }
    }

    public static boolean checkBoard() { //Win Condition
        boolean gameEnd = true;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if ((board[i][j] != board[0][0]) && (board[i][j] != board[dimension -1][dimension -1])) {
                    gameEnd = false;
                }
            }
        }
        return gameEnd;

    }
}