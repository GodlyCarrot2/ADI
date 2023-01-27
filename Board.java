public class Board {
    private static int dimension = 7;
    private static int[][] board = new int[dimension][dimension];

    public static final String RESET = "\u001B[0m";
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
               board[i][j] = (int) (Math.random() * 6);
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
                if (board[i][j] == 1) {
                    display += (BLACK + "  " + RESET);
                }
                if (board[i][j] == 2) {
                    display += (GREEN + "  " + RESET);
                }
                if (board[i][j] == 3) {
                    display += (YELLOW + "  " + RESET);
                }
                if (board[i][j] == 4) {
                    display += (BLUE + "  " + RESET);
                }
                if (board[i][j] == 5) {
                    display += (PURPLE + "  " + RESET);
                }
            }
            display += "\n";
        }
        System.out.println(display);
    }

    public static void changeColor(int color, int x, int y) {
                board[x][y] = color; 
    }
    

    public static void checkColor(int color) {
        int temp_x = dimension;
        int temp_y = 0;
        while (temp_x < 7 || temp_y > 0) {
            
        }
    }

    
}