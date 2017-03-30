package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.db.DBFixtures;

public class EditActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarEditActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(EditActivity.class);
        createCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

    private void createCategories() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityEdit);
        createPreview(layout);
        createChooseCategory(layout);
        createNameDescription(layout);
        createGetIcon(layout);
    }

    private void createGetIcon(LinearLayout layout) {
        createHeadline(layout, "Icon");

        // horizontal scroll layout
        HorizontalScrollView layoutCategoryScroll = new HorizontalScrollView(this);
        layout.addView(layoutCategoryScroll);

        // horizontal layout
        LinearLayout layoutCategoryTiles = new LinearLayout(this);
        layoutCategoryTiles.setOrientation(LinearLayout.HORIZONTAL);
        layoutCategoryTiles.setPadding(15, 0, 0, 0);
        layoutCategoryScroll.addView(layoutCategoryTiles);

        // category tiles
        for (final Tile tile : DBFixtures.getAllIconTiles()) {

            FrameLayout frameLayout = new FrameLayout(this);
            frameLayout.setPadding(15, 0, 15, 15);
            layoutCategoryTiles.addView(frameLayout);

            // icon
            final Button buttonTile = new Button(this);
            buttonTile.setBackgroundResource(tile.getIcon());
            LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                    tile.getWidth(), tile.getHeight());
            frameLayout.addView(buttonTile, paramsButton);

        }
    }

    private void createChooseCategory(LinearLayout layout) {
        createHeadline(layout, "Tile Type");

        String[] array = new String[DBFixtures.getCategories().size()];
        for (int i = 0; i < DBFixtures.getCategories().size(); i++) {
            array[i] = (DBFixtures.getCategories().get(i).getName());
        }

        Spinner spinner = new Spinner(this);
        ArrayAdapter<String> spinnerArrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array);
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerArrayAdapter);
        layout.addView(spinner);

        String[] arrayType = new String[3];
        arrayType[0] = "Simple One Click Tile";
        arrayType[1] = "Three Clicks Tile";
        arrayType[2] = "Number Field Tile";

        Spinner spinnerType = new Spinner(this);
        ArrayAdapter<String> spinnerArrayAdapterType =
                new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayType);
        spinnerArrayAdapterType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerType.setAdapter(spinnerArrayAdapterType);
        layout.addView(spinnerType);

    }

    private void createNameDescription(LinearLayout layout) {
        createHeadline(layout, "Description");

        EditText textViewName = new EditText(this);
        textViewName.setText("Title");
        textViewName.setHighlightColor(Color.DKGRAY);
        textViewName.setPadding(20, 0, 0, 0);
        layout.addView(textViewName);

        EditText textViewDescription = new EditText(this);
        textViewDescription.setText("Description");
        textViewDescription.setPadding(20, 0, 0, 0);
        layout.addView(textViewDescription);
    }

    private void createPreview(LinearLayout layout) {
        createHeadline(layout, "Preview");

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setPadding(30, 30, 0, 30);


        Tile newTile = DBFixtures.getNewTileCategory().getTiles().get(0);
        Button buttonNew = new Button(this);
        buttonNew.setBackgroundResource(R.drawable.tile_white);
        LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                newTile.getWidth(), newTile.getHeight());
        buttonNew.setPadding(20,0,0,20);
        relativeLayout.addView(buttonNew, paramsButton);

        RelativeLayout relativeLayoutSave = new RelativeLayout(this);
        relativeLayoutSave.setPadding(600, 10, 0, 0);
        Button buttonSave = new Button(this);
        buttonSave.setBackgroundResource(R.drawable.save_02);
        LinearLayout.LayoutParams paramsButtonSave = new LinearLayout.LayoutParams(
                newTile.getWidth(), newTile.getHeight());
        relativeLayoutSave.addView(buttonSave, paramsButtonSave);
        relativeLayout.addView(relativeLayoutSave);


        TextView textViewName = new TextView(this);
        textViewName.setText(newTile.getName());
        textViewName.setPadding(140, 5, 0, 0);
        relativeLayout.addView(textViewName);

        TextView textViewDescription = new TextView(this);
        textViewDescription.setText(newTile.getDescription());
        textViewDescription.setPadding(140, 45, 0, 0);
        relativeLayout.addView(textViewDescription);

        layout.addView(relativeLayout);
    }
}
