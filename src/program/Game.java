package program;

public class Game {
    private Player p1;
    private Player p2;
    private DiceCup dc;

    public Game(Player p1, Player p2, DiceCup dc) {
        this.p1 = p1;
        this.p2 = p2;
        this.dc = dc;
    }
    int counter = 0;
    public String play(String eventType) {
        String message= "";
        if(eventType == "roll"){
            while (true) {

                counter++;
                if (counter%2 == 1) {
                    message = this.p1.playTurn(dc);
                }
                else if (counter%2 == 0) {
                    message = this.p2.playTurn(dc);
                }
                if (this.p1.getWon()) {
                    message = message + this.p1.getName() + " har vundet!";
                    //System.out.println(this.p1.getName() + " har vundet!");
                    break;
                } else if (this.p2.getWon()) {
                    message = message + this.p1.getName() + " har vundet!";
                    //System.out.println(this.p2.getName() + " har vundet!");
                    break;
                }

                break;

        }


        }
        return message;
    }

    public void printGameRules() {
        System.out.println("Regler...");
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
}
