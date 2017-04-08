package com.example.philipp.lifetiles.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Entry;
import com.example.philipp.lifetiles.components.Tile;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

    private static final String TABLE_ENTRIES = "entries";
    private static final String KEY_ENTRIES_TILE_ID = "tile";
    private static final String KEY_ENTRIES_DATE = "date";

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
        // ENTRY
        String CREATE_ENTRIES_TABLE = "CREATE TABLE " + TABLE_ENTRIES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_ENTRIES_TILE_ID + " NUMERIC,"
                + KEY_ENTRIES_DATE + " DATE" + ")";
        db.execSQL(CREATE_ENTRIES_TABLE);
        System.out.println("Created table: " + TABLE_ENTRIES);
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
        values.put(KEY_CATEGORY_COLOR, category.getColor());
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
        System.out.println("Added match: " + category.getId() + " - " + tile.getId() + " - " + tile.getName());
    }

    public void addEntry(Entry entry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ENTRIES_TILE_ID, entry.getTile().getId());
        values.put(KEY_ENTRIES_DATE, entry.getDate());
        db.insert(TABLE_ENTRIES, null, values);
        db.close();
        System.out.println("Added entry: " + entry);
    }

    public void addEntryToday(Tile tile) {
        // current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ENTRIES_TILE_ID, tile.getId());
        values.put(KEY_ENTRIES_DATE, date);
        db.insert(TABLE_ENTRIES, null, values);
        db.close();
        System.out.println("Added entry: " + tile.getName() + " (" + tile.getId() + "):  " + date);
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
        db.close();
        return tile;
    }

    public Category getCategory(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_CATEGORIES,
                new String[]{KEY_ID, KEY_TILE_NAME, KEY_CATEGORY_ICON, KEY_CATEGORY_ICON_PRESSED, KEY_CATEGORY_ICON_CATEGORY, KEY_CATEGORY_COLOR},
                KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }

        Cursor cursor2 = db.query(TABLE_MATCH,
                new String[]{KEY_ID, KEY_MATCH_CATEGORY_ID, KEY_MATCH_TILE_ID},
                KEY_MATCH_CATEGORY_ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        int i = 0;
        List<Integer> tileIds = new ArrayList<>();
        while (cursor2.moveToNext()) {
            tileIds.add(cursor2.getInt(cursor2.getColumnIndex(KEY_MATCH_TILE_ID)));
            i++;
            if (cursor2.getCount() <= i) {
                break;
            }
        }
        db.close();

        List<Tile> tiles = new ArrayList<>();
        for (int tileId : tileIds) {
            System.out.println(tileId);
            tiles.add(getTile(tileId));
        }
        return new Category(cursor.getInt(0), cursor.getString(1), cursor.getInt(5), tiles);
    }

    public Entry getEntry(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ENTRIES, new String[]{KEY_ID,
                        KEY_ENTRIES_TILE_ID, KEY_ENTRIES_DATE}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        db.close();
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Entry entry = new Entry(cursor.getInt(0),
                getTile(cursor.getInt(1)), cursor.getString(2));

        return entry;
    }

    public int getEntryCount(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ENTRIES, new String[]{KEY_ID,
                        KEY_ENTRIES_TILE_ID, KEY_ENTRIES_DATE}, KEY_ENTRIES_TILE_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        int count = cursor.getCount();
        db.close();
        return count;
    }

    public List<Category> getCategories() {
        SQLiteDatabase db = this.getReadableDatabase();
        long numRows = DatabaseUtils.queryNumEntries(db, TABLE_CATEGORIES);
        db.close();

        List<Category> categories = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            categories.add(getCategory(i));
        }

        return categories;
    }

    public List<Entry> getEntries() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_ENTRIES, new String[]{KEY_ID,
                        KEY_ENTRIES_TILE_ID, KEY_ENTRIES_DATE}, null,
                new String[]{}, null, null, null, null);

        int i = 0;
        List<Entry> entries = new ArrayList<>();
        List<Integer> entryIds = new ArrayList<>();
        List<Integer> tileIds = new ArrayList<>();
        List<String> dates = new ArrayList<>();
        while (cursor.moveToNext()) {
            entryIds.add(cursor.getInt(0));
            tileIds.add(cursor.getInt(1));
            dates.add(cursor.getString(2));
            i++;
            if (cursor.getCount() <= i) {
                break;
            }
        }
        db.close();

        int j = 0;
        for (int entryId : entryIds) {
            entries.add(new Entry(entryId, getTile(tileIds.get(j)), dates.get(j)));
            j++;
        }

        return entries;
    }

    public List<Entry> getEntriesOfCategory(int id) { // TODO not cost efficient
        List<Entry> entries = new ArrayList<>();
        for (Tile categoryTile : getCategory(id).getTiles()) {
            for (Entry entry : getEntries()) {
                if (entry.getTile().getId() == categoryTile.getId()) {
                    entries.add(entry);
                }
            }
        }
        return entries;
    }

    public void removeEntriesToday(Tile tile) {
        SQLiteDatabase db = this.getWritableDatabase();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        String tileId = String.valueOf(tile.getId());

        try {
            db.delete(TABLE_ENTRIES, KEY_ENTRIES_TILE_ID + " = ? AND " + KEY_ENTRIES_DATE + " = ?",
                    new String[]{tileId, date});
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }
}