public class Player {
    private String name;
    private int color;

    public Player() {
        name = "";
        color = 0;
    }
    
    public Player(String a, int b) {
        name = a;
        color = b;
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int b) {
        color = b;
    }
}
