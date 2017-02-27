package com.example.philipp.lifetiles.components;

import java.util.List;

/**
 * Created by Philipp on 09.12.2016.
 */
public class Category {

    private int id;
    private int icon;
    private int pressedIcon;
    private String name;
    private List<Tile> tiles;
    private int color;

    public Category(int id, int icon, int pressedIcon, String name, int color, List<Tile> tiles) {
        this.id = id;
        this.icon = icon;
        this.pressedIcon = pressedIcon;
        this.name = name;
        this.tiles = tiles;
        this.color = color;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public List<Tile> getTiles() {
        return tiles;
    }

    public void setTiles(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPressedIcon() {
        return pressedIcon;
    }

    public void setPressedIcon(int pressedIcon) {
        this.pressedIcon = pressedIcon;
    }
}
