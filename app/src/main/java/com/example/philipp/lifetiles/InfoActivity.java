package com.example.philipp.lifetiles;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Tile;

public class InfoActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_tiles);

        createMenu();
        createCategories();
    }

    private void createCategories() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutInfo);

        for(Category category : InitTiles.getCategories()){
            // category
            Button buttonCategory = new Button(this);
            buttonCategory.setBackgroundResource(category.getIcon());
            buttonCategory.setText(category.getName());
            buttonCategory.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            buttonCategory.setPadding(0, 0, 0, 0);
            layout.addView(buttonCategory);

            // horizontal scroll layout
            HorizontalScrollView layoutCategoryScroll = new HorizontalScrollView(this);
            layoutCategoryScroll.setPadding(0, 0, 0, 0);
            layout.addView(layoutCategoryScroll);

            // horizontal layout
            LinearLayout layoutCategoryTiles = new LinearLayout(this);
            layoutCategoryTiles.setOrientation(LinearLayout.HORIZONTAL);
            layoutCategoryTiles.setPadding(0, 0, 0, 0);
            layoutCategoryScroll.addView(layoutCategoryTiles);

            // category tiles
            for(Tile tile : category.getTiles()){
                Button buttonTile = new Button(this);
                buttonTile.setBackgroundResource(tile.getIcon());
                LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                        tile.getWidth(), tile.getHeight());
                paramsButton.setMargins(10, 0, 10, 0);
                buttonTile.setLayoutParams(paramsButton);
                layoutCategoryTiles.addView(buttonTile);
            }
        }
    }

    private void createMenu() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.layoutInfo);

        // horizontal layout
        LinearLayout layoutMenu = new LinearLayout(this);
        layoutMenu.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams paramsMenu = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutMenu.setLayoutParams(paramsMenu);
        layoutMenu.setPadding(14, 0, 0, 0);
        layout.addView(layoutMenu);

        // menu buttons
        for(Tile tile : InitTiles.getMenuTiles()){
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