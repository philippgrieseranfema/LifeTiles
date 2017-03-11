package com.example.philipp.lifetiles.components;

/**
 * Created by Philipp on 04.03.2017.
 */

public class TileMenu extends Tile {
    private int iconPressed;
    private Class classToSwitch;

    public TileMenu(int id, int icon, String name, int width, int height) {
        super(id, icon, name, "MenuTile", width, height);
    }

    public TileMenu(int id, int icon, int iconPressed, String name, int width, int height, Class classToSwitch) {
        super(id, icon, name, "MenuTile", width, height);
        this.iconPressed = iconPressed;
        this.classToSwitch = classToSwitch;
    }

    public Class getClassToSwitch() {
        return classToSwitch;
    }

    public void setClassToSwitch(Class classToSwitch) {
        this.classToSwitch = classToSwitch;
    }

    public int getIconPressed() {
        return iconPressed;
    }

    public void setIconPressed(int iconPressed) {
        this.iconPressed = iconPressed;
    }
}
