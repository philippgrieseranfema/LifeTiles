package com.example.philipp.lifetiles.Fixtures;

import com.example.philipp.lifetiles.ChartActivity;
import com.example.philipp.lifetiles.EditActivity;
import com.example.philipp.lifetiles.InfoActivity;
import com.example.philipp.lifetiles.ListActivity;
import com.example.philipp.lifetiles.R;
import com.example.philipp.lifetiles.TilesActivity;
import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.TileMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philipp on 09.12.2016.
 */

public class InitTiles {

    private static int tileMenuWidth = 60;
    private static int tileMenuHeight = 60;
    private static int tileWidth = 100;
    private static int tileHeight = 100;

    public static List<TileMenu> getMenuTiles() {
        List<TileMenu> tiles = new ArrayList<>();
        tiles.add(new TileMenu(0, R.drawable.logo_small, R.drawable.logo_small_pressed, "logo", tileMenuWidth, tileMenuHeight, TilesActivity.class));
        tiles.add(new TileMenu(1, R.drawable.logo_list_small, R.drawable.logo_list_small_pressed, "list", tileMenuWidth, tileMenuHeight, ListActivity.class));
        tiles.add(new TileMenu(2, R.drawable.logo_edit_small, R.drawable.logo_edit_small_pressed, "edit", tileMenuWidth, tileMenuHeight, EditActivity.class));
        tiles.add(new TileMenu(3, R.drawable.logo_chart_small, R.drawable.logo_chart_small_pressed, "chart", tileMenuWidth, tileMenuHeight, ChartActivity.class));
        tiles.add(new TileMenu(4, R.drawable.logo_info_small, R.drawable.logo_info_small_pressed, "info", tileMenuWidth, tileMenuHeight, InfoActivity.class));
        return tiles;
    }

    public static List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categories.add(getCategorySport());
        categories.add(getCategoryHealth());
        categories.add(getCategoryFinance());
        categories.add(getCategoryLifestyle());
        categories.add(getCategoryLifestyle());
        return categories;
    }

    private static Category getCategorySport() {
        return new Category(0, R.drawable.categorie_00, R.drawable.tile_yellow_pressed, "Sport",
                R.drawable.tile_orange_02, getCategoryTilesSport());
    }

    private static Category getCategoryHealth() {
        return new Category(1, R.drawable.categorie_00, R.drawable.tile_blue_pressed, "Health",
                R.drawable.tile_blue_02, getCategoryTilesHealth());
    }

    private static Category getCategoryFinance() {
        return new Category(2, R.drawable.categorie_00, R.drawable.tile_green_pressed, "Finance",
                R.drawable.tile_green_02, getCategoryTilesFinance());
    }

    private static Category getCategoryLifestyle() {
        return new Category(3, R.drawable.categorie_00, R.drawable.tile_red_pressed, "Lifestyle",
                R.drawable.tile_red_02, getCategoryTilesLifestyle());
    }

    private static List<Tile> getCategoryTilesSport() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", "Your sports activity", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_badminton_01, "badminton", "Badminton match", tileWidth, tileHeight));
        tiles.add(new Tile(2, R.drawable.icon_barbell_01, "barbell", "Fitness Club", tileWidth, tileHeight));
        tiles.add(new Tile(3, R.drawable.icon_soccer_01, "soccer", "You played soccer today", tileWidth, tileHeight));
        tiles.add(new Tile(4, R.drawable.icon_bike_01, "bike", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(5, R.drawable.icon_soccer_01, "soccer", "This is a description", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesHealth() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_apple_01, "apple", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_bottle_01, "bottle", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_pill_01, "pill", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(0, R.drawable.icon_plus_01, "plus", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_burger_01, "burger", "This is a description", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesFinance() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_money_01, "money", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_shopping_01, "shopping", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(2, R.drawable.icon_pig_01, "pig", "This is a description", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesLifestyle() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_phone_01, "friends", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_cocktail_01, "cocktail", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(2, R.drawable.icon_dance_01, "dance", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(3, R.drawable.icon_book_02, "book", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(4, R.drawable.icon_controller_01, "controller", "This is a description", tileWidth, tileHeight));
        return tiles;
    }
}
