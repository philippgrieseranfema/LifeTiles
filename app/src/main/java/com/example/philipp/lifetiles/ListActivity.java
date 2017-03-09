package com.example.philipp.lifetiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.TileMenu;

public class ListActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarListActivity);
        this.setSupportActionBar(myToolbar);
        createMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

    private void createMenu() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityList);

        // horizontal layout
        LinearLayout layoutMenu = new LinearLayout(this);
        layoutMenu.setBackgroundColor(getResources().getColor(R.color.toolbarColor));
        layoutMenu.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams paramsMenu = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 100);
        layoutMenu.setLayoutParams(paramsMenu);
        layoutMenu.setPadding(0, 0, 0, 0);
        layout.addView(layoutMenu);

        // menu buttons
        for (final TileMenu tile : InitTiles.getMenuTiles()) {
            final Button buttonTile = new Button(this);
            if (tile.getClassToSwitch().equals(ListActivity.class)) {
                buttonTile.setBackgroundResource(tile.getIconPressed());
            } else {
                buttonTile.setBackgroundResource(tile.getIcon());
            }
            buttonTile.setOnClickListener(new View.OnClickListener() { // TODO extract
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ListActivity.this, (tile).getClassToSwitch());
                    startActivity(intent);
                }
            });
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    tile.getWidth(), tile.getHeight());
            params.setMargins(32, 10, 10, 0);
            buttonTile.setLayoutParams(params);
            layoutMenu.addView(buttonTile);
        }
    }
}
