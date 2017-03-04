package com.example.philipp.lifetiles.components;

/**
 * Created by Philipp on 04.03.2017.
 */

public class TileMenu extends Tile {
    private Class classToSwitch;

    public TileMenu(int id, int icon, String name, int width, int height) {
        super(id, icon, name, width, height);
    }

    public TileMenu(int id, int icon, String name, int width, int height, Class classToSwitch) {
        super(id, icon, name, width, height);
        this.classToSwitch = classToSwitch;
    }

    public Class getClassToSwitch() {
        return classToSwitch;
    }

    public void setClassToSwitch(Class classToSwitch) {
        this.classToSwitch = classToSwitch;
    }
}
