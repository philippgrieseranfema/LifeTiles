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

    private static int tileMenuWidth = 50;
    private static int tileMenuHeight = 50;
    private static int tileWidth = 100;
    private static int tileHeight = 100;

    public static List<Tile> getMenuTiles(){
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.logo_02, "logo", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(1, R.drawable.logo_list_01, "list", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(0, R.drawable.logo_edit, "edit", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(1, R.drawable.logo_chart, "chart", tileMenuWidth, tileMenuHeight));
        tiles.add(new Tile(0, R.drawable.logo_info, "info", tileMenuWidth, tileMenuHeight));
        return tiles;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(getCategorySport());
        categories.add(getCategoryHealth());
        categories.add(getCategoryFinance());
        categories.add(getCategoryLifestyle());
        return categories;
    }

    private static Category getCategorySport() {
        return new Category(0, R.drawable.categorie_00, "Sport", getCategoryTilesSport());
    }

    private static Category getCategoryHealth() {
        return new Category(0, R.drawable.categorie_00, "Health", getCategoryTilesHealth());
    }

    private static Category getCategoryFinance() {
        return new Category(0, R.drawable.categorie_00, "Finance", getCategoryTilesFinance());
    }

    private static Category getCategoryLifestyle() {
        return new Category(0, R.drawable.categorie_00, "Lifestyle", getCategoryTilesLifestyle());
    }

    private static List<Tile> getCategoryTilesSport() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_soccer_01, "soccer", tileWidth, tileHeight));
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_soccer_01, "soccer", tileWidth, tileHeight));
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_soccer_01, "soccer", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesHealth() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_apple_01, "apple", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_bottle_01, "bottle", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesFinance() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_money_01, "money", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_shopping_01, "shopping", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesLifestyle() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_cocktail_01, "cockteail", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_dance_01, "dance", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_book_02, "book", tileWidth, tileHeight));
        return tiles;
    }
}
