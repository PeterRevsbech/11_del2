package program;

public class Game {
    private int counter = -1;
    private Player p1;
    private Player p2;
    private DiceCup dc;

    public Game(Player p1, Player p2, DiceCup dc) {
        this.p1 = p1;
        this.p2 = p2;
        this.dc = dc;
    }

    public String play(String eventType) {
        String message= "";
        if(eventType.equals("roll")){
                if (!(p1.isLastSum10() || p2.isLastSum10())) {
                    counter++;
                }
                message ="Runde "+ ((counter/2)+1) +"\n" + message;

                if (counter%2 == 1) {
                    message = message + this.p1.playTurn(dc);
                }
                else if (counter%2 == 0) {
                    message = message + this.p2.playTurn(dc);
                }
                if (this.p1.getWon()) {
                    message = message +"\n"+ this.p1.getName() + " har vundet!";
                } else if (this.p2.getWon()) {
                    message = message +" \n"+ this.p2.getName() + " har vundet!";
                }
        }
        return message;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int X) {
        this.counter=X;
    }
}
