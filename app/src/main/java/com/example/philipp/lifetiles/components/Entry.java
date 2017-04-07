package com.example.philipp.lifetiles.components;

/**
 * Created by Philipp on 06.04.2017.
 */

public class Entry {

    private int id;
    private Tile tile;
    private String date;

    public Entry(int id, Tile tile, String date) {
        this.id = id;
        this.tile = tile;
        this.date = date;
    }

    public String toString() {
        return "Entry: Tile " + tile.getName() + " (" + tile.getId() + ") on " + date;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
