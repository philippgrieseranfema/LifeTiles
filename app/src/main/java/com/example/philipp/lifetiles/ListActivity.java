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

                LinearLayout linearLayoutTileButton = new LinearLayout(this);
                Button tileButton = new Button(this);
                tileButton.setBackgroundResource(tile.getIcon());
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight()); // image scale
                tileButton.setLayoutParams(params);
                linearLayoutTileButton.addView(tileButton);
                linearLayoutTileButton.setPadding(20,00,0,0);
                layoutTiles.addView(linearLayoutTileButton);

                TextView textView = new TextView(this);
                textView.setText(toUpperCase(tile.getName()));
                textView.setPadding(140, 5, 0, 0);
                textView.setTypeface(null, Typeface.BOLD);
                layoutTiles.addView(textView);

                TextView textView2 = new TextView(this);
                textView2.setText(toUpperCase(tile.getDescription()));
                textView2.setPadding(140, 45, 0, 0);
                layoutTiles.addView(textView2);

                LinearLayout linearLayoutEditButton = new LinearLayout(this);
                Button buttonEdit = new Button(this);
                buttonEdit.setBackgroundResource(R.drawable.edit);
                LinearLayout.LayoutParams buttonEditParams = new LinearLayout.LayoutParams(
                        40, 40); // image scale
                buttonEdit.setLayoutParams(buttonEditParams);
                //buttonEdit.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                linearLayoutEditButton.addView(buttonEdit);
                linearLayoutEditButton.setPadding(560,20,0,0);
                layoutTiles.addView(linearLayoutEditButton);

                LinearLayout linearLayoutDeleteButton = new LinearLayout(this);
                Button buttonDelete = new Button(this);
                buttonDelete.setBackgroundResource(R.drawable.delete);
                LinearLayout.LayoutParams buttonDeleteParams = new LinearLayout.LayoutParams(
                        40, 40); // image scale
                buttonDelete.setLayoutParams(buttonDeleteParams);
                //buttonDelete.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
                linearLayoutDeleteButton.addView(buttonDelete);
                linearLayoutDeleteButton.setPadding(640,20,0,0);
                layoutTiles.addView(linearLayoutDeleteButton);
            }
        }

    }

    private String toUpperCase(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}
