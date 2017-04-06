package com.example.philipp.lifetiles.components;

import com.example.philipp.lifetiles.R;

import java.util.List;

/**
 * Created by Philipp on 09.12.2016.
 */
public class Category {

    private int id;
    private int icon;
    private int iconPressed;
    private int iconCategory;
    private String name;
    private List<Tile> tiles;
    private int color;

    public Category(int id, String name, int color, List<Tile> tiles) {
        this.id = id;
        this.name = name;
        this.tiles = tiles;
        this.color = color;
        if (color == 0) {
            this.icon = R.drawable.tile_orange_02;
            this.iconPressed = R.drawable.tile_yellow_pressed;
            this.iconCategory = R.drawable.category_stripe_yellow;
        } else if (color == 1) {
            this.icon = R.drawable.tile_blue_02;
            this.iconPressed = R.drawable.tile_blue_pressed;
            this.iconCategory = R.drawable.category_stripe_blue;
        } else if (color == 2) {
            this.icon = R.drawable.tile_green_02;
            this.iconPressed = R.drawable.tile_green_pressed;
            this.iconCategory = R.drawable.category_stripe_green;
        } else if (color == 3) {
            this.icon = R.drawable.tile_red_02;
            this.iconPressed = R.drawable.tile_red_pressed;
            this.iconCategory = R.drawable.category_stripe_red;
        }
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

    public int getIconPressed() {
        return iconPressed;
    }

    public void setIconPressed(int iconPressed) {
        this.iconPressed = iconPressed;
    }

    public int getIconCategory() {
        return iconCategory;
    }

    public void setIconCategory(int iconCategory) {
        this.iconCategory = iconCategory;
    }
}
