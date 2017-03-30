package com.example.philipp.lifetiles.components;

/**
 * Created by Philipp on 09.12.2016.
 */

public class Tile {

    private String description;
    private int id;
    private int icon;
    private String name;
    private int width;
    private int height;
    private TileState state;

    public Tile(int id, int icon, String name, String description, int width, int height) {
        this.height = height;
        this.width = width;
        this.name = name;
        this.description = description;
        this.icon = icon;
        this.id = id;
        this.state = TileState.valueOf("NOSTATE");
    }

    public String toString() {
        return "Tile: " + name;
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

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public TileState getState() {
        return state;
    }

    public void setState(TileState state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
