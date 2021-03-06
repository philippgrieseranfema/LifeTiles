package com.example.philipp.lifetiles.components;

import android.graphics.Color;

import java.util.List;

/**
 * Created by Philipp on 09.12.2016.
 */
public class Category {

    private int id;
    private int icon;
    private String name;
    private List<Tile> tiles;
    private Color color;

    public Category(int id, int icon, String name, List<Tile> tiles) {
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.tiles = tiles;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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

}
