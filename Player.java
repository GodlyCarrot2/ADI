import java.util.Scanner;

public class Player {
    private String name;
    private int color;
    private int factor;
    private int position;

    public Player() {
        name = "";
        color = 0;
        factor = 0;
    }
    
    public Player(int a) {
        name = "";
        color = 0;
        factor = a;
        
    }
    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }

    public void setName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name?");
        String a = sc.nextLine();
        name = a;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int b) {
        color = b;
    }

    public int getFactor() {
        return factor;
    }
}
