package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class EditActivity extends RootActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarEditActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(EditActivity.class);
        createCategories();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }


    private void createCategories() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityEdit);

        LinearLayout layoutTiles = new LinearLayout(this);
        //layoutTiles.setOrientation(LinearLayout.HORIZONTAL);
        layoutTiles.setPadding(0, 0, 0, 0);
        layoutTiles.setBackgroundColor(Color.BLUE);
        layout.addView(layoutTiles);

        Button testButton = new Button(this);
        testButton.setBackgroundResource(R.drawable.icon_sport_01);
        layoutTiles.addView(testButton);

        TextView textView = new TextView(this);
        textView.setText("Das ist ein Test");
        layoutTiles.addView(textView);


    }
}
