public class Tile {
    private int x;
    private int y;
    private String color;

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
