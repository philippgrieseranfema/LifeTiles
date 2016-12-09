package com.example.philipp.lifetiles.components;

import android.graphics.Color;

/**
 * Created by Philipp on 09.12.2016.
 */

public class BooleanTile {

    private int id;
    private String icon;
    private boolean value;
    private Category category;
    private Color color;

    public BooleanTile(int id, String icon, boolean value, Category category) {
        this.id = id;
        this.icon = icon;
        this.value = value;
        this.category = category;
        this.color = this.category.color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
