package com.example.philipp.lifetiles;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.philipp.lifetiles.db.DBHandler;
import com.example.philipp.lifetiles.db.DBInit;

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

        TextView textView = new TextView(this);
        textView.setText("Create");
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