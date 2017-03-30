package com.example.philipp.lifetiles.db;

import com.example.philipp.lifetiles.ChartActivity;
import com.example.philipp.lifetiles.EditActivity;
import com.example.philipp.lifetiles.InfoActivity;
import com.example.philipp.lifetiles.ListActivity;
import com.example.philipp.lifetiles.R;
import com.example.philipp.lifetiles.TilesActivity;
import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.CategoryColor;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.TileMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Philipp on 09.12.2016.
 */

public class DBFixtures {

    private static int tileMenuWidth = 60;
    private static int tileMenuHeight = 60;
    private static int tileWidth = 100;
    private static int tileHeight = 100;

    public static List<TileMenu> getMenuTiles() {
        List<TileMenu> tiles = new ArrayList<>();
        tiles.add(new TileMenu(0, R.drawable.logo_small, R.drawable.logo_small_pressed_02, "logo", tileMenuWidth, tileMenuHeight, TilesActivity.class));
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
        return categories;
    }

    private static Category getCategorySport() {
        return new Category(0, "Sport", CategoryColor.CATEGORY_COLOR_YELLOW, getCategoryTilesSport());
    }

    private static Category getCategoryHealth() {
        return new Category(1, "Health", CategoryColor.CATEGORY_COLOR_BLUE, getCategoryTilesHealth());
    }

    private static Category getCategoryFinance() {
        return new Category(2, "Finance", CategoryColor.CATEGORY_COLOR_GREEN, getCategoryTilesFinance());
    }

    private static Category getCategoryLifestyle() {
        return new Category(3, "Lifestyle", CategoryColor.CATEGORY_COLOR_RED, getCategoryTilesLifestyle());
    }

    private static List<Tile> getCategoryTilesSport() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", "Your sports activity", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_badminton_01, "badminton", "Badminton match", tileWidth, tileHeight));
        tiles.add(new Tile(2, R.drawable.icon_barbell_01, "barbell", "Fitness Club", tileWidth, tileHeight));
        tiles.add(new Tile(3, R.drawable.icon_soccer_01, "soccer", "You played soccer", tileWidth, tileHeight));
        tiles.add(new Tile(4, R.drawable.icon_bike_01, "bike", "With bike to work", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesHealth() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(5, R.drawable.icon_apple_01, "apple", "An apple a day", tileWidth, tileHeight));
        tiles.add(new Tile(6, R.drawable.icon_bottle_01, "bottle", "Drinking enoiigh is important", tileWidth, tileHeight));
        tiles.add(new Tile(7, R.drawable.icon_pill_01, "pill", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(8, R.drawable.icon_plus_01, "plus", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(9, R.drawable.icon_burger_01, "burger", "This is a description", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesFinance() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(10, R.drawable.icon_money_01, "money", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(11, R.drawable.icon_shopping_01, "shopping", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(12, R.drawable.icon_pig_01, "pig", "This is a description", tileWidth, tileHeight));
        return tiles;
    }

    private static List<Tile> getCategoryTilesLifestyle() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(13, R.drawable.icon_phone_01, "phone", "So much phone this is", tileWidth, tileHeight));
        tiles.add(new Tile(14, R.drawable.icon_cocktail_01, "cocktail", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(15, R.drawable.icon_dance_01, "dance", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(16, R.drawable.icon_book_02, "book", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(17, R.drawable.icon_friends_01, "friends", "Go out with your friends", tileWidth, tileHeight));
        tiles.add(new Tile(18, R.drawable.icon_controller_01, "controller", "This is a description", tileWidth, tileHeight));
        return tiles;
    }

    public static Category getNewTileCategory(){
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_phone_01, "New Tile", "New Tile Description", tileWidth, tileHeight));
        return new Category(0, "Create new tiles here", CategoryColor.CATEGORY_COLOR_YELLOW, tiles);
    }

    public static List<Tile> getAllIconTiles() {
        List<Tile> tiles = new ArrayList<>();
        tiles.add(new Tile(0, R.drawable.icon_sport_01, "sport", "Your sports activity", tileWidth, tileHeight));
        tiles.add(new Tile(1, R.drawable.icon_badminton_01, "badminton", "Badminton match", tileWidth, tileHeight));
        tiles.add(new Tile(2, R.drawable.icon_barbell_01, "barbell", "Fitness Club", tileWidth, tileHeight));
        tiles.add(new Tile(3, R.drawable.icon_soccer_01, "soccer", "You played soccer today", tileWidth, tileHeight));
        tiles.add(new Tile(4, R.drawable.icon_bike_01, "bike", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(5, R.drawable.icon_apple_01, "apple", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(6, R.drawable.icon_bottle_01, "bottle", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(7, R.drawable.icon_pill_01, "pill", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(8, R.drawable.icon_plus_01, "plus", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(9, R.drawable.icon_burger_01, "burger", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(10, R.drawable.icon_money_01, "money", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(11, R.drawable.icon_shopping_01, "shopping", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(12, R.drawable.icon_pig_01, "pig", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(13, R.drawable.icon_phone_01, "phone", "So much phone this is", tileWidth, tileHeight));
        tiles.add(new Tile(14, R.drawable.icon_cocktail_01, "cocktail", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(15, R.drawable.icon_dance_01, "dance", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(16, R.drawable.icon_book_02, "book", "This is a description", tileWidth, tileHeight));
        tiles.add(new Tile(17, R.drawable.icon_friends_01, "friends", "Go out with your friends", tileWidth, tileHeight));
        tiles.add(new Tile(18, R.drawable.icon_controller_01, "controller", "This is a description", tileWidth, tileHeight));
        return tiles;
    }
}
