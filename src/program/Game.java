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

    public void play() {
        int counter = 0;
        while (true) {
            counter++;
            if (counter%2 == 1) {
             this.p1.playTurn(dc);
            }
         else if (counter%2 == 0) {
             this.p2.playTurn(dc);
            }
         if (this.p1.getWon()) {
             System.out.println(this.p1.getName() + " har vundet!");
             break;
         } else if (this.p2.getWon()) {
             System.out.println(this.p2.getName() + " har vundet!");
             break;
         }

        }



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
