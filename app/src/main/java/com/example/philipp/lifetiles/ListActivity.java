package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Tile;

public class ListActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarListActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(ListActivity.class);
        createCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

    private void createCategories() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityList);

        for (final Category category : InitTiles.getCategories()) {
            // category
            Button buttonCategory = new Button(this);
            buttonCategory.setBackgroundResource(category.getIcon());
            buttonCategory.setText(category.getName());
            buttonCategory.setTextColor(Color.DKGRAY);
            buttonCategory.setTextSize(14);
            buttonCategory.setPadding(0, 0, 0, 40);
            buttonCategory.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
            layout.addView(buttonCategory);

            // category tiles
            for (final Tile tile : category.getTiles()) {
                RelativeLayout layoutTiles = new RelativeLayout(this);
                layoutTiles.setPadding(0, 0, 0, 20);
                layout.addView(layoutTiles);

                Button testButton = new Button(this);
                testButton.setBackgroundResource(tile.getIcon());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight()); // image scale
                testButton.setLayoutParams(params);
                testButton.setPadding(200, 0, 0, 0);
                layoutTiles.addView(testButton);

                TextView textView = new TextView(this);
                textView.setText(toUpperCase(tile.getName()));
                textView.setPadding(150, 5, 0, 0);
                textView.setTypeface(null, Typeface.BOLD);
                layoutTiles.addView(textView);

                TextView textView2 = new TextView(this);
                textView2.setText(toUpperCase(tile.getDescription()));
                textView2.setPadding(150, 45, 0, 0);
                layoutTiles.addView(textView2);
            }
        }

    }

    private String toUpperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}
