package com.example.philipp.lifetiles.Fixtures;

import com.example.philipp.lifetiles.R;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.Category;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philipp on 09.12.2016.
 */

public class InitTiles {

    private static int tileMenuWidth = 60;
    private static int tileMenuHeight = 60;
    private static int tileWidth = 60;
    private static int tileHeight = 60;

    public static List<Tile> getMenuTiles(){
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.logo_02, "logo", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(1, R.drawable.logo_list_01, "list", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(0, R.drawable.logo_edit, "edit", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(1, R.drawable.logo_chart, "chart", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(0, R.drawable.logo_info, "info", tileMenuWidth, tileMenuHeight));
        return tiles;
    }

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(getCategorySport());
        categories.add(getCategoryHealth());
        return categories;
    }

    private Category getCategorySport() {
        return new Category(0, "sport", getCategoryTilesSport());
    }

    private Category getCategoryHealth() {
        return new Category(0, "health", getCategoryTilesHealth());
    }

    private List<Tile> getCategoryTilesSport() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_soccer_01, "soccer", tileWidth, tileHeight));
        return tiles;
    }

    private List<Tile> getCategoryTilesHealth() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_apple_01, "apple", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_bottle_01, "bottle", tileWidth, tileHeight));
        return tiles;
    }
}
