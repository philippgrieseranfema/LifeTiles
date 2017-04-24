package com.example.philipp.lifetiles;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.TileState;
import com.example.philipp.lifetiles.db.DBHandler;
import com.example.philipp.lifetiles.db.DBInit;

import static com.example.philipp.lifetiles.R.drawable.category;

public class InfoActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarInfoActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(InfoActivity.class);
        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityInfo);

        createHeadline(layout, "Information");
        createDatabaseView(layout);

        createHeadline(layout, "Buttons & Feedback");

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setGravity(Gravity.CENTER);
        layout.addView(linearLayout);

        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setPadding(0, 40, 0, 0);
        linearLayout.addView(frameLayout);

        final Vibrator vibrator = (Vibrator) this.getSystemService(VIBRATOR_SERVICE);
        final Tile tile = new Tile(33, R.drawable.icon_sport_01, "test", "Test Description", 100, 100);

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
                    vibrator.vibrate(10);
                    tile.setState(TileState.PRESSED);
                    buttonPressed.setBackgroundResource(R.drawable.tile_yellow_pressed);
                } else if (tile.getState() == TileState.PRESSED) {
                    vibrator.vibrate(10);
                    tile.setState(TileState.NOSTATE);
                    buttonPressed.setBackgroundResource(R.drawable.transparent);
                }
            }
        });
        buttonBorder.setBackgroundResource(R.drawable.tile_orange_02);
        LinearLayout.LayoutParams paramsBorder = new LinearLayout.LayoutParams(
                tile.getWidth(), tile.getHeight());
        buttonBorder.setLayoutParams(paramsBorder);
        frameLayout.addView(buttonBorder);




        final Snackbar mySnackbar = Snackbar.make(layout, "This is a Test", 3000);

        // border
        Button buttonSnackbar = new Button(this);
        buttonSnackbar.setOnClickListener(new View.OnClickListener() { // TODO extract
            @Override
            public void onClick(View v) {
                mySnackbar.show();
            }
        });
        buttonSnackbar.setBackgroundResource(R.drawable.edit);
        LinearLayout.LayoutParams paramsBorder4 = new LinearLayout.LayoutParams(50, 50);
        buttonSnackbar.setLayoutParams(paramsBorder4);
        layout.addView(buttonSnackbar);

    }

    private void createDatabaseView(LinearLayout layout) {
        TextView textView = new TextView(this);
        textView.setText("Create DB");
        layout.addView(textView);

        // border
        Button buttonDB = new Button(this);
        buttonDB.setOnClickListener(new View.OnClickListener() { // TODO extract
            @Override
            public void onClick(View v) {
                DBInit init = new DBInit();
                init.initDB(getBaseContext());
            }
        });
        buttonDB.setBackgroundResource(R.drawable.edit);
        LinearLayout.LayoutParams paramsBorder = new LinearLayout.LayoutParams(50, 50);
        buttonDB.setLayoutParams(paramsBorder);
        layout.addView(buttonDB);

        final TextView textView2 = new TextView(this);
        textView2.setText("Check first launch");
        layout.addView(textView2);

        // border
        Button buttonCheck = new Button(this);
        buttonCheck.setOnClickListener(new View.OnClickListener() { // TODO extract
            @Override
            public void onClick(View v) {
                DBInit init = new DBInit();
                System.out.println(init.isFirstLaunch(getBaseContext()));
                textView2.setText("" + init.isFirstLaunch(getBaseContext()));
            }
        });
        buttonCheck.setBackgroundResource(R.drawable.edit);
        LinearLayout.LayoutParams paramsBorder2 = new LinearLayout.LayoutParams(50, 50);
        buttonCheck.setLayoutParams(paramsBorder2);
        layout.addView(buttonCheck);

        final TextView textView3 = new TextView(this);
        textView3.setText("Drop db");
        layout.addView(textView3);

        // border
        Button buttonDrop = new Button(this);
        buttonDrop.setOnClickListener(new View.OnClickListener() { // TODO extract
            @Override
            public void onClick(View v) {
                getBaseContext().deleteDatabase(DBHandler.DATABASE_NAME);
                textView3.setText("drop");
            }
        });
        buttonDrop.setBackgroundResource(R.drawable.edit);
        LinearLayout.LayoutParams paramsBorder3 = new LinearLayout.LayoutParams(50, 50);
        buttonDrop.setLayoutParams(paramsBorder3);
        layout.addView(buttonDrop);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

}