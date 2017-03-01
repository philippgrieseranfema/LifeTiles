package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.os.Bundle;
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

        createMenu();
        createCategories();
    }

    private void createCategories() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_tiles);

        for (final Category category : InitTiles.getCategories()) {
            // category
            Button buttonCategory = new Button(this);
            buttonCategory.setBackgroundResource(category.getIcon());
            buttonCategory.setText(category.getName());
            buttonCategory.setTextColor(Color.DKGRAY);
            buttonCategory.setTextSize(14);
            buttonCategory.setPadding(0, 8, 0, 0);
            buttonCategory.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            layout.addView(buttonCategory);

            // horizontal scroll layout
            HorizontalScrollView layoutCategoryScroll = new HorizontalScrollView(this);
            layout.addView(layoutCategoryScroll);

            // horizontal layout
            LinearLayout layoutCategoryTiles = new LinearLayout(this);
            layoutCategoryTiles.setOrientation(LinearLayout.HORIZONTAL);
            //layoutCategoryTiles.setPadding(15, 0, 0, 0);
            layoutCategoryScroll.addView(layoutCategoryTiles);

            // category tiles
            for (final Tile tile : category.getTiles()) {

                FrameLayout frameLayout = new FrameLayout(this);
                frameLayout.setPadding(15, 0, 15, 0);
                layoutCategoryTiles.addView(frameLayout);

                // icon
                final Button buttonTile = new Button(this);
                buttonTile.setBackgroundResource(tile.getIcon());
                LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight());
                frameLayout.addView(buttonTile, paramsButton);

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


                // border
                Button buttonBorder = new Button(this);
                buttonBorder.setOnClickListener(new View.OnClickListener() { // TODO extract
                    @Override
                    public void onClick(View v) {
                        if (tile.getState() == TileState.NOSTATE) {
                            tile.setState(TileState.PRESSED);
                            buttonPressed.setBackgroundResource(category.getPressedIcon());
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
                buttonBorder.setBackgroundResource(category.getColor());
                LinearLayout.LayoutParams paramsBorder = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight());
                buttonBorder.setLayoutParams(paramsBorder);
                frameLayout.addView(buttonBorder);
            }
        }
    }

    private void createMenu() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_tiles);

        // horizontal layout
        LinearLayout layoutMenu = new LinearLayout(this);
        layoutMenu.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams paramsMenu = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutMenu.setLayoutParams(paramsMenu);
        layoutMenu.setPadding(14, 0, 0, 0);
        layout.addView(layoutMenu);

        // menu buttons
        for (Tile tile : InitTiles.getMenuTiles()) {
            Button buttonTile = new Button(this);
            buttonTile.setBackgroundResource(tile.getIcon());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    tile.getWidth(), tile.getHeight());
            params.setMargins(10, 0, 10, 0);
            buttonTile.setLayoutParams(params);
            layoutMenu.addView(buttonTile);
        }
    }
}

