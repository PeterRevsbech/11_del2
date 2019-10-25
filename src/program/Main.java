package program;

import gui_fields.GUI_Field;
import gui_main.GUI;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        GuiController guiController = new GuiController();
        guiController.setup();
        guiController.mainMenu();









        GUI.setNull_fields_allowed(true);
        GUI_Field[] fields = new GUI_Field[40];
        GUI gui = new GUI(fields, Color.white);
        gui.displayChanceCard(" ");

        //gui.displayChanceCard("     ");

        final String regler = "Spilleregler:" +
                "\nSpillet spilles af to spillere, som skiftes til at slå med terningerne. Man starter med 1000 point. "
                + "Antallet af øjne afgør hvilket felt man lander på. På hvert felt fratrækkes eller tillægges et antal point til spillerens pointbeholdning. "+
                "Den spiller som først opnår 3000 point har vundet. Det er ikke muligt at tabe flere point end man har. Man kan altså ikke opnå negative point.";


        gui.showMessage("Velkommen til terningespillet version 2.5!");

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
        String selection = gui.getUserButtonPressed("Hovedmenu", "Nyt spil", "Spilleregler", "Ændr spillernavne", "Afslut");
        switch (selection) {
            case "Nyt spil":

                /*String name1NewName = gui.getUserString("Spiller 1 skriv dit navn.");
                String name2NewName = gui.getUserString("Spiller 1 skriv dit navn.");
                p1.name = name1NewName;
                p2.name = name2NewName;
                */
                p1.getAccount().setBalance(1000);
                p2.getAccount().setBalance(1000);
                gui.addPlayer(p1.getGuiPlayer());
                gui.addPlayer(p2.getGuiPlayer());
                //game = new Game(p1,p2,dc);


                while (true) {
                    String selection2 = gui.getUserButtonPressed("Næste tur", "Ruld");
                    if (p1.getWon() == true) {
                        gui.showMessage(p1.getName() + " vandt! Tillykke!");
                        break;
                    }
                    if (p2.getWon() == true) {
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
                name1 = gui.getUserString("Spiller 1 skriv dit navn.");
                p1.setName(name1);
                name2 = gui.getUserString("Spiller 2 skriv dit navn.");
                p2.setName(name2);
                break;
            case "Afslut":
                afslut = true;
                gui.close();
                break;

            /*case "Rold":
                if(p1.getWon()==true){
                    gui.showMessage("spiller "+p1.getName()+" Won");
                    break;
                }
                if (p2.getWon()==true){
                    gui.showMessage("spiller "+p2.getName()+" Won");
                    break;
                }
                game.play("rold");
                break;

             */
        }
        }


    }



}
