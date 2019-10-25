package program;

import gui_fields.GUI_Field;
import gui_main.GUI;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        GUI.setNull_fields_allowed(true);
        GUI_Field[] fields = new GUI_Field[40];
        GUI gui = new GUI(fields, Color.white);
        //gui.displayChanceCard("     ");

        final String regler = "Spilleregler:" +
                "\nSpillet spilles af to spillere, som skiftes til at slå med terningerne. Man starter med 1000 point. "
                + "Antallet af øjne afgør hvilket felt man lander på. På hvert felt fratrækkes eller tillægges et antal point til spillerens pointbeholdning. "+
                "Den spiller som først opnår 3000 point har vundet. Det er ikke muligt at tabe flere point end man har. Man kan altså ikke opnå negative point.";


        gui.showMessage("Velkommen til terningespillet version 2!");

        String name1 = gui.getUserString("Spiller 1 skriv dit navn.");
        Player p1 = new Player(name1, 1000);
        gui.addPlayer(p1.getGuiPlayer());

        String name2 = gui.getUserString("Spiller 2 skriv dit navn.");
        Player p2 = new Player(name2, 1000);
        gui.addPlayer(p2.getGuiPlayer());
        DiceCup dc = new DiceCup(2,6);
        Game game = new Game(p1,p2,dc);
        boolean afslut = false;
        while (afslut == false) {
        String selection = gui.getUserButtonPressed("Hovedmenu", "Nyt spil", "Spilleregler", "Ændr spillernavne", "Afslut","Rold");
        switch (selection) {
            case "Nyt spil":
                p1.setWon(false);
                p2.setWon(false);
                p1.getAccount().setBalance(1000);
                p2.getAccount().setBalance(1000);


                break;
            case "Spilleregler":
                gui.showMessage(regler);
                break;
            case "Ændr spillernavne":
                name1 = gui.getUserString("Spiller 1 skriv dit navn.");
                p1.setName(name1);
                name2 = gui.getUserString("Spiller 2 skriv dit navn.");
                p2.setName(name2);
                break;
            case "Afslut":
                afslut = true;
                gui.close();
                break;

            case "Rold":
                if(p1.getWon()==true){
                    break;
                }
                if (p2.getWon()==true){
                    break;
                }
                game.play();
                break;
        }
        }


    }



}
