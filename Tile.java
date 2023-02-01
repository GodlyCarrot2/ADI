public class Tile { //Attributes for board tiles
    private int x;
    private int y;

    public Tile() {
        int x = 0;
        int y = 0;
    }

    public Tile(int a, int b) {
        x = a;
        y = b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int a) {
        x = a;
    }

    public void setY(int b) {
        y = b;
    }
}
