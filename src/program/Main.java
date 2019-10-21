package program;

public class Main {
    public static void main(String[] args) {


        DiceCup kop = new DiceCup(2,6 );
        kop.rollDice();
        System.out.println(kop.getDieSum());

        Player spiller = new Player("Svend",3000);
        DiceCup DC = new DiceCup(2,6);
        for (int i=1; i<=10; i++) {
            System.out.println(spiller.getPoint());
            spiller.playTurn(DC);

        }


    }



}
