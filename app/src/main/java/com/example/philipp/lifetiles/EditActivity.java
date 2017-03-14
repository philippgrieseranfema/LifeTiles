package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.TileState;

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
        createSelectType(layout);
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
        for (final Tile tile : InitTiles.getAllIconTiles()) {

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

    private void createSelectType(LinearLayout layout) {
        createHeadline(layout, "Type");
    }

    private void createChooseCategory(LinearLayout layout) {
        createHeadline(layout, "Category");

        for (Category category : InitTiles.getCategories()) {
            TextView textViewCategoryName = new TextView(this);
            textViewCategoryName.setText(category.getName());
            layout.addView(textViewCategoryName);
        }
    }

    private void createNameDescription(LinearLayout layout) {
        createHeadline(layout, "Description");

        EditText textViewName = new EditText(this);
        textViewName.setText("Title");
        textViewName.setPadding(0, 0, 0, 0);
        layout.addView(textViewName);

        EditText textViewDescription = new EditText(this);
        textViewDescription.setText("Description");
        textViewDescription.setPadding(0, 0, 0, 0);
        layout.addView(textViewDescription);
    }

    private void createPreview(LinearLayout layout) {
        createHeadline(layout, "Preview");

        RelativeLayout relativeLayout = new RelativeLayout(this);

        LinearLayout linearLayout = new LinearLayout(this);
        Tile newTile = InitTiles.getNewTileCategory().getTiles().get(0);
        Button buttonNew = new Button(this);
        buttonNew.setBackgroundResource(R.drawable.tile_white);
        LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                newTile.getWidth(), newTile.getHeight());
        buttonNew.setPadding(20,0,0,20);
        linearLayout.addView(buttonNew, paramsButton);
        relativeLayout.addView(linearLayout);

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

    private void createHeadline(LinearLayout layout, String title) {
        Button headline = new Button(this);
        headline.setBackgroundResource(R.drawable.categorie_00);
        headline.setText(title);
        headline.setTextColor(Color.DKGRAY);
        headline.setTextSize(14);
        headline.setPadding(0, 0, 0, 40);
        headline.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
        layout.addView(headline);
    }
}
