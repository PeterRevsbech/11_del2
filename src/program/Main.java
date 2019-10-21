package program;

public class Main {
    public static void main(String[] args) {


        DiceCup kop = new DiceCup(2,6);
        kop.rollDice();
        System.out.println(kop.getDieSum());

    }



}
