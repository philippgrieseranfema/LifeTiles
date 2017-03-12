package com.example.philipp.lifetiles;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class InfoActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarInfoActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(InfoActivity.class);
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityInfo);

        TextView textView = new TextView(this);
        textView.setText("Infos ...");
        layout.addView(textView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

}