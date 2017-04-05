package com.example.philipp.lifetiles.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.CategoryColor;
import com.example.philipp.lifetiles.components.Tile;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "lifetile";
    private static final int DATABASE_VERSION = 1;
    private static final String KEY_ID = "id";

    private static final String TABLE_TILES = "tiles";
    private static final String KEY_TILE_NAME = "name";
    private static final String KEY_TILE_DESCRIPTION = "description";
    private static final String KEY_TILE_ICON = "icon";

    private static final String TABLE_CATEGORIES = "categories";
    private static final String KEY_CATEGORY_NAME = "name";
    private static final String KEY_CATEGORY_ICON = "icon";
    private static final String KEY_CATEGORY_ICON_PRESSED = "iconPressed";
    private static final String KEY_CATEGORY_ICON_CATEGORY = "iconCategory";
    private static final String KEY_CATEGORY_COLOR = "color";

    private static final String TABLE_MATCH = "match";
    private static final String KEY_MATCH_CATEGORY_ID = "category";
    private static final String KEY_MATCH_TILE_ID = "tile";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // categories
        String CREATE_CATEGORIES_TABLE = "CREATE TABLE " + TABLE_CATEGORIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_CATEGORY_NAME + " TEXT,"
                + KEY_CATEGORY_ICON + " NUMERIC," + KEY_CATEGORY_ICON_PRESSED + " NUMERIC,"
                + KEY_CATEGORY_ICON_CATEGORY + " NUMERIC," + KEY_CATEGORY_COLOR + " NUMERIC" + ")";
        db.execSQL(CREATE_CATEGORIES_TABLE);
        System.out.println("Created table: " + TABLE_CATEGORIES);
        // tiles
        String CREATE_TILES_TABLE = "CREATE TABLE " + TABLE_TILES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_TILE_NAME + " TEXT,"
                + KEY_TILE_DESCRIPTION + " TEXT," + KEY_TILE_ICON + " NUMERIC" + ")";
        db.execSQL(CREATE_TILES_TABLE);
        System.out.println("Created table: " + TABLE_TILES);
        // match
        String CREATE_MATCH_TABLE = "CREATE TABLE " + TABLE_MATCH + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_MATCH_CATEGORY_ID + " NUMERIC,"
                + KEY_MATCH_TILE_ID + " NUMERIC" + ")";
        db.execSQL(CREATE_MATCH_TABLE);
        System.out.println("Created table: " + TABLE_MATCH);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TILES);
        // Creating tables again
        onCreate(db);
    }

    public void addTile(Tile tile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TILE_NAME, tile.getName());
        values.put(KEY_TILE_DESCRIPTION, tile.getDescription());
        values.put(KEY_TILE_ICON, tile.getIcon());
        db.insert(TABLE_TILES, null, values);
        db.close();
        System.out.println("Added tile: " + tile);
    }

    public void addCategory(Category category) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CATEGORY_NAME, category.getName());
        values.put(KEY_CATEGORY_ICON, category.getIcon());
        values.put(KEY_CATEGORY_ICON_PRESSED, category.getIconPressed());
        values.put(KEY_CATEGORY_ICON_CATEGORY, category.getIconCategory());
        // values.put(KEY_CATEGORY_COLOR, category.getColor()); TODO
        db.insert(TABLE_CATEGORIES, null, values);
        db.close();
        System.out.println("Added category: " + category);
    }

    public void addMatch(Category category, Tile tile) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MATCH_CATEGORY_ID, category.getId());
        values.put(KEY_MATCH_TILE_ID, tile.getId());
        db.insert(TABLE_MATCH, null, values);
        db.close();
        System.out.println("Added match: " + category.getId() + " - " + tile.getId());
    }

    public Tile getTile(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_TILES, new String[]{KEY_ID,
                        KEY_TILE_NAME, KEY_TILE_DESCRIPTION, KEY_TILE_ICON}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Tile tile = new Tile(Integer.parseInt(cursor.getString(0)),
                Integer.parseInt(cursor.getString(3)), cursor.getString(1), cursor.getString(2), 100, 100);

        return tile;
    }

    public Category getCategory(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CATEGORIES,
                new String[]{KEY_ID, KEY_TILE_NAME, KEY_CATEGORY_ICON, KEY_CATEGORY_ICON_PRESSED, KEY_CATEGORY_ICON_CATEGORY},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Cursor cursor2 = db.query(TABLE_MATCH,
                new String[]{KEY_ID, KEY_MATCH_CATEGORY_ID, KEY_MATCH_TILE_ID},
                KEY_MATCH_CATEGORY_ID + " = 2",
                new String[]{}, null, null, null, null);

        int i = 0;
        List<Integer> tileIds = new ArrayList<>();
        while (cursor2.moveToNext()) {
            tileIds.add(cursor2.getInt(cursor2.getColumnIndex(KEY_MATCH_TILE_ID)));
            i++;
            if (cursor2.getCount() <= i) {
                break;
            }
        }

        List<Tile> tiles = new ArrayList<>();
        for (int tileId : tileIds) {
            tiles.add(getTile(tileId));
        }

        return new Category(cursor.getInt(0), cursor.getString(1), CategoryColor.CATEGORY_COLOR_YELLOW, tiles); // TODO color
    }
}