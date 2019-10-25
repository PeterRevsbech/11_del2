package program;

import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class GuiController {

    private Player p1 = new Player();
    private Player p2 = new Player();
    private GUI gui;
    public void mainMenu(){
        String selection = gui.getUserButtonPressed("Hovedmenu", "Nyt spil", "Spilleregler", "Ændr spillernavne", "Afslut");

    }
    public GuiController() {
        GUI.setNull_fields_allowed(true);
        GUI_Field[] fields = new GUI_Field[40];
        gui = new GUI(fields, Color.white);
        gui.displayChanceCard(" ");
    }

    public void setup(){
        gui.showMessage("Velkommen til terningespillet version 2.5!");

        String name1 = gui.getUserString("Spiller 1 skriv dit navn.");
        Player p1 = new Player(name1, 1000);
        gui.addPlayer(p1.getGuiPlayer());

        String name2 = gui.getUserString("Spiller 2 skriv dit navn.");
        Player p2 = new Player(name2, 1000);
        gui.addPlayer(p2.getGuiPlayer());
        DiceCup dc = new DiceCup(2,6);
        Game game = new Game(p1,p2,dc);
    }








}
