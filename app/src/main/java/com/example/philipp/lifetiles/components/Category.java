package com.example.philipp.lifetiles.components;

import android.graphics.Color;

/**
 * Created by Philipp on 09.12.2016.
 */
public class Category {

    private int id;
    private String name;
    public Color color;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
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
