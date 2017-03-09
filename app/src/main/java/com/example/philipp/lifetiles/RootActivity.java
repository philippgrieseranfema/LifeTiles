package com.example.philipp.lifetiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.TileMenu;

public abstract class RootActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.overridePendingTransition(0, 0); // no transition animations
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.overridePendingTransition(0, 0); // no transition animations
    }

    public void openTilesView(View view) {
        startActivityIntent(TilesActivity.class);
    }

    public void openListView(View view) {
        startActivityIntent(ListActivity.class);
    }

    public void openChartView(View view) {
        startActivityIntent(ChartActivity.class);
    }

    public void openEditView(View view) {
        startActivityIntent(EditActivity.class);
    }

    public void openInfoView(View view) {
        startActivityIntent(InfoActivity.class);
    }

    private void startActivityIntent(Class activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    public void createMenu(Class activityClass) {
        LinearLayout layout = null;
        if (activityClass.equals(TilesActivity.class)) {
            layout = (LinearLayout) findViewById(R.id.theActivityTiles);
        } else if (activityClass.equals(ListActivity.class)) {
            layout = (LinearLayout) findViewById(R.id.theActivityList);
        } else if (activityClass.equals(EditActivity.class)) {
            layout = (LinearLayout) findViewById(R.id.theActivityEdit);
        } else if (activityClass.equals(ChartActivity.class)) {
            layout = (LinearLayout) findViewById(R.id.theActivityChart);
        } else if (activityClass.equals(InfoActivity.class)) {
            layout = (LinearLayout) findViewById(R.id.theActivityInfo);
        }

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
            if (tile.getClassToSwitch().equals(activityClass)) {
                buttonTile.setBackgroundResource(tile.getIconPressed());
            } else {
                buttonTile.setBackgroundResource(tile.getIcon());
            }
            final RootActivity rootActivity = this;
            buttonTile.setOnClickListener(new View.OnClickListener() { // TODO extract
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(rootActivity, tile.getClassToSwitch());
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