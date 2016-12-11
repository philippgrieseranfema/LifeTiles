package com.example.philipp.lifetiles;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableRow;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.Tile;

import java.util.List;

public class InfoActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_tiles);

        createMenu();

        LinearLayout myLayout = (LinearLayout) findViewById(R.id.fuckingLayout);

        Button myButton = new Button(this);
        myButton.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));
        myLayout.addView(myButton);
    }

    private void createMenu() {
        LinearLayout myLayout = (LinearLayout) findViewById(R.id.fuckingLayout);

        for(Tile tile : InitTiles.getMenuTiles()){
            Button buttonTile = new Button(this);
            buttonTile.setLayoutParams(
                    new LinearLayout.LayoutParams(tile.getWidth(), tile.getHeight()));
            buttonTile.setBackgroundResource(tile.getIcon());
            myLayout.addView(buttonTile);
        }
    }
}