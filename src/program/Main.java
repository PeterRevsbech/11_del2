package program;

import gui_fields.GUI_Field;
import gui_main.GUI;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //Setting the GUI up
        GUI.setNull_fields_allowed(true);
        GUI_Field[] fields = new GUI_Field[40];

        GUI gui = new GUI(fields, Color.white);
        gui.displayChanceCard(" ");

        final String regler = "Spilleregler:" +
                "\nSpillet spilles af to spillere, som skiftes til at slå med terningerne. Man starter med 1000 point. "
                + "Antallet af øjne afgør hvilket felt man lander på. På hvert felt fratrækkes eller tillægges et antal point til spillerens pointbeholdning. "+
                "Den spiller som først opnår 3000 point har vundet. Det er ikke muligt at tabe flere point end man har. Man kan altså ikke opnå negative point.";

        //Initializing the game
        gui.showMessage("Velkommen til terningespillet version 2!");
        String name1;
        while (true) {
            name1 = gui.getUserString("Spiller 1 skriv dit navn.");
            if (name1.equals("")) {
                gui.showMessage("Navnet må ikke være identisk med et en nuværende spillers navn eller tomt. Prøv igen.");
            } else {
                break;
            }
        }

        Player p1 = new Player(name1, 1000);
        gui.addPlayer(p1.getGuiPlayer());
        String name2;
        while (true) {
            name2 = gui.getUserString("Spiller 2 skriv dit navn.");
            if (name2.equals(p1.getName()) || name2.equals("")) {
                gui.showMessage("Navnet må ikke være identisk med et en nuværende spillers navn eller tomt. Prøv igen.");
            } else {
                break;
            }
        }

        Player p2 = new Player(name2, 1000);
        gui.addPlayer(p2.getGuiPlayer());

        DiceCup dc = new DiceCup(2,6);
        Game game = new Game(p1,p2,dc);

        //Setting up the main menu
        boolean afslut = false;
        while (!afslut) {
        String selection = gui.getUserButtonPressed("Hovedmenu", "Nyt spil", "Spilleregler", "Ændr spillernavne", "Afslut");
        switch (selection) {
            case "Nyt spil":
                game.setCounter(0);
                p1.getAccount().setBalance(1000);
                p1.getGuiPlayer().setBalance(1000);
                p1.setWon(false);

                p2.getAccount().setBalance(1000);
                p2.getGuiPlayer().setBalance(1000);
                p2.setWon(false);

                while (true) {
                    String selection2 = gui.getUserButtonPressed("Runde "+ (game.getCounter()+1), "Rul");
                    if (p1.getWon()) {
                        gui.showMessage(p1.getName() + " vandt! Tillykke!");
                        break;
                    }
                    if (p2.getWon()) {
                        gui.showMessage( p2.getName() + " vandt! Tillykke!");
                        break;
                    }
                    gui.showMessage(game.play("roll"));
                }

                break;
            case "Spilleregler":
                gui.showMessage(regler);
                break;
            case "Ændr spillernavne":
                while (true) {
                    name1 = gui.getUserString("Spiller 1 skriv dit navn.");
                    if (name1.equals(p2.getName()) || name1.equals(p1.getName()) || name1.equals("")) {
                        gui.showMessage("Navnet må ikke være identisk med et en nuværende spillers navn eller tomt. Prøv igen.");
                    } else {
                        p1.setName(name1);
                        break;
                    }
                }

                while (true) {
                    name2 = gui.getUserString("Spiller 2 skriv dit navn.");
                    if (name2.equals(p2.getName()) || name2.equals(p1.getName())|| name2.equals("")) {
                        gui.showMessage("Navnet må ikke være identisk med et en nuværende spillers navn eller tomt. Prøv igen.");
                    } else {
                        p2.setName(name2);
                        break;
                    }
                }
                break;
            case "Afslut":
                afslut = true;
                gui.close();
                break;
        }
        }


    }



}
