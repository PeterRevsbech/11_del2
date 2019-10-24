package program;

import gui_main.GUI;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.showMessage("Velkommen til terningespillet version 2!");
        String navn1 = gui.getUserString("Spiller 1 skriv dit navn.");
        String navn2 = gui.getUserString("Spiller 2 skriv dit navn.");
        Player p1 = new Player(navn1, 1000);
        Player p2 = new Player(navn2, 1000);
        gui.addPlayer(p1.getGuiPlayer());
        gui.addPlayer(p2.getGuiPlayer());

        boolean afslut = false;
        while (afslut == false) {
        String selection = gui.getUserButtonPressed("Hovedmenu", "Nyt spil", "Spilleregler", "Ændre spillernavne", "Afslut");
        switch (selection) {
            case "Nyt spil":
                p1 = new Player(navn1, 1000);
                p2 = new Player(navn2, 1000);
                DiceCup dc = new DiceCup(2,6);
                Game game = new Game(p1,p2,dc);
                game.play();

                break;
            case "Spilleregler":
                gui.showMessage("Regler...");
                break;
            case "Ændre spillernavne":
                navn1 = gui.getUserString("Spiller 1 skriv dit navn.");
                navn2 = gui.getUserString("Spiller 2 skriv dit navn.");
                break;
            case "Afslut":
                afslut = true;
                break;


        }
        }











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
