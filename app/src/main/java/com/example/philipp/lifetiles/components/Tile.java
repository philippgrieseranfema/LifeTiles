package com.example.philipp.lifetiles.components;

import android.graphics.Color;

import com.example.philipp.lifetiles.R;

/**
 * Created by Philipp on 09.12.2016.
 */

public class Tile {

    private int id;
    private int icon;
    private String name;
    private int width;
    private int height;

    public Tile(int id, int icon, String name, int width, int height) {
        this.height = height;
        this.width = width;
        this.name = name;
        this.icon = icon;
        this.id = id;
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

}
