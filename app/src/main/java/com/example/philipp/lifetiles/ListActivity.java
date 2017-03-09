package com.example.philipp.lifetiles;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

public class ListActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarListActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(ListActivity.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

}
