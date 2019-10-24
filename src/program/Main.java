package program;

public class Main {
    public static void main(String[] args) {

        Player p1 = new Player("Bashar", 1000);
        Player p2 = new Player("Hugo", 1000);
        DiceCup dc = new DiceCup(2,6);
        Game game = new Game(p1,p2,dc);
        game.play();














        /*DiceCup kop = new DiceCup(2,6 );
        kop.rollDice();
        System.out.println(kop.getDieSum());

        Player spiller = new Player("Svend",3000);
        DiceCup DC = new DiceCup(2,6);
        for (int i=1; i<=10; i++) {
            System.out.println(spiller.getAccountBalance());
            spiller.playTurn(DC);


        }

    */



    }



}
