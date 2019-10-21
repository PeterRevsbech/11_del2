package program;

public class Player {
    private int point;
    private String name;

    public Player(String name,int pointStart){
        pointStart=point;
        this.name = name;

    }

    public void playTurn(){
        
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
