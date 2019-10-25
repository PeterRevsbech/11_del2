package program;

import gui_fields.GUI_Field;
import gui_main.GUI;

import java.awt.*;

public class GuiController {
    private GUI gui;

    public GuiController() {
        GUI.setNull_fields_allowed(true);
        GUI_Field[] fields = new GUI_Field[40];
        gui = new GUI(fields, Color.white);
        gui.displayChanceCard(" ");
    }






}
