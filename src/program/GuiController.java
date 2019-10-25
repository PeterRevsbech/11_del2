package program;

import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class GuiController {

    private Player p1 = new Player("ukendt1",1000);
    private Player p2 = new Player("ukendt2",1000);
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
        p1.setName(name1);
        p1.getGuiPlayer().setName(name1);
        gui.addPlayer(p1.getGuiPlayer());

        String name2 = gui.getUserString("Spiller 2 skriv dit navn.");
        p2.setName(name2);
        p2.getGuiPlayer().setName(name2);
        gui.addPlayer(p2.getGuiPlayer());
        DiceCup dc = new DiceCup(2,6);
        Game game = new Game(p1,p2,dc);
    }








}
