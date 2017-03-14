package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.TileState;

public class TilesActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarTilesActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(TilesActivity.class);
        createCategories();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

    private void createCategories() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityTiles);

        for (final Category category : InitTiles.getCategories()) {
            // category
            Button buttonCategory = new Button(this);
            buttonCategory.setBackgroundResource(R.drawable.category);
            LinearLayout.LayoutParams paramsCategory = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 70); // image scale
            buttonCategory.setLayoutParams(paramsCategory);
            buttonCategory.setText(category.getName());
            buttonCategory.setTextColor(Color.DKGRAY);
            buttonCategory.setTextSize(14);
            buttonCategory.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            layout.addView(buttonCategory);

            // category stripe
            Button buttonCategoryStripe = new Button(this);
            buttonCategoryStripe.setBackgroundResource(category.getIconCategory());
            LinearLayout.LayoutParams paramsCategoryStripe = new LinearLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 8); // image scale
            buttonCategoryStripe.setLayoutParams(paramsCategoryStripe);
            layout.addView(buttonCategoryStripe);

            // horizontal scroll layout
            HorizontalScrollView layoutCategoryScroll = new HorizontalScrollView(this);
            layoutCategoryScroll.setPadding(0, 15, 0, 0);
            layout.addView(layoutCategoryScroll);

            // horizontal layout
            LinearLayout layoutCategoryTiles = new LinearLayout(this);
            layoutCategoryTiles.setOrientation(LinearLayout.HORIZONTAL);
            layoutCategoryTiles.setPadding(0, 15, 0, 0);
            layoutCategoryScroll.addView(layoutCategoryTiles);

            // category tiles
            for (final Tile tile : category.getTiles()) {

                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setPadding(15, 0, 15, 15);
                layoutCategoryTiles.addView(frameLayout);

                // pressed overlay sticks
                final Button buttonSticks = new Button(this);
                buttonSticks.setBackgroundResource(R.drawable.transparent);
                LinearLayout.LayoutParams bbb = new LinearLayout.LayoutParams(
                        tile.getWidth(), (int) (tile.getHeight() * 1.18)); // image scale
                buttonSticks.setLayoutParams(bbb);
                frameLayout.addView(buttonSticks);

                // pressed overlay
                final Button buttonPressed = new Button(this);
                buttonPressed.setBackgroundResource(R.drawable.transparent);
                LinearLayout.LayoutParams aaa = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight());
                buttonPressed.setLayoutParams(aaa);
                frameLayout.addView(buttonPressed);

                // icon
                final Button buttonTile = new Button(this);
                buttonTile.setBackgroundResource(tile.getIcon());
                LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight());
                frameLayout.addView(buttonTile, paramsButton);


                // border
                Button buttonBorder = new Button(this);
                buttonBorder.setOnClickListener(new View.OnClickListener() { // TODO extract
                    @Override
                    public void onClick(View v) {
                        if (tile.getState() == TileState.NOSTATE) {
                            tile.setState(TileState.PRESSED);
                            buttonPressed.setBackgroundResource(category.getIconPressed());
                            buttonSticks.setBackgroundResource(R.drawable.tile_pressed_stick);
                        } else if (tile.getState() == TileState.PRESSED) {
                            tile.setState(TileState.PRESSED2);
                            buttonSticks.setBackgroundResource(R.drawable.tile_pressed_stick2);
                        } else if (tile.getState() == TileState.PRESSED2) {
                            tile.setState(TileState.PRESSED3);
                            buttonSticks.setBackgroundResource(R.drawable.tile_pressed_stick3);
                        } else if (tile.getState() == TileState.PRESSED3) {
                            tile.setState(TileState.NOSTATE);
                            buttonPressed.setBackgroundResource(R.drawable.transparent);
                            buttonSticks.setBackgroundResource(R.drawable.transparent);
                        }
                    }
                });
                buttonBorder.setBackgroundResource(category.getIcon());
                LinearLayout.LayoutParams paramsBorder = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight());
                buttonBorder.setLayoutParams(paramsBorder);
                frameLayout.addView(buttonBorder);
            }
        }
    }
}

