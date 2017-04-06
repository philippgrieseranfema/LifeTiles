package com.example.philipp.lifetiles.db;

import android.content.Context;

import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Tile;

import java.io.File;

/**
 * Created by Philipp on 25.03.2017.
 */

public class DBInit {

    DBHandler dbHandler;

    public DBInit() {
        // this class handles first launch of app
    }

    public boolean isFirstLaunch(Context context) {
        File dbFile = context.getDatabasePath(DBHandler.DATABASE_NAME);
        return dbFile.exists();
    }

    public void initDB(Context context) {
        this.dbHandler = new DBHandler(context);
        initTiles();
    }

    private void initTiles() {
        // add tiles
        for (Tile tile : DBFixtures.getAllIconTiles()) {
            dbHandler.addTile(tile);
        }
        // add categories
        for (Category category : DBFixtures.getCategories()) {
            dbHandler.addCategory(category);
        }
        // add matches
        for (Category category : DBFixtures.getCategories()) {
            for (Tile tile : category.getTiles()) {
                dbHandler.addMatch(category, tile);
            }
        }
    }

}
