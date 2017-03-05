package com.example.philipp.lifetiles;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.philipp.lifetiles.Fixtures.InitTiles;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.components.TileMenu;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;


public class ChartActivity extends RootActivity {

    public Calendar month;
    public CalendarAdapter adapter;
    public Handler handler;
    public ArrayList<String> items; // container to store some random calendar items
    public Runnable calendarUpdater = new Runnable() {

        @Override
        public void run() {
            items.clear();
            // format random values. You can implement a dedicated class to provide real values
            for (int i = 0; i < 31; i++) {
                Random r = new Random();

                if (r.nextInt(10) > 6) {
                    items.add(Integer.toString(i));
                }
            }

            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);
        createMenu();
        month = Calendar.getInstance();
        onNewIntent(getIntent());

        items = new ArrayList<String>();
        adapter = new CalendarAdapter(this, month);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(adapter);

        handler = new Handler();
        handler.post(calendarUpdater);

        TextView title = (TextView) findViewById(R.id.title);
        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));

        TextView previous = (TextView) findViewById(R.id.previous);
        previous.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (month.get(Calendar.MONTH) == Calendar.SUNDAY) {
                    month.set((month.get(Calendar.YEAR) - 1), month.getActualMaximum(Calendar.MONTH), 1);
                } else {
                    month.set(Calendar.MONTH, month.get(Calendar.MONTH) - 1);
                }
                refreshCalendar();
            }
        });

        TextView next = (TextView) findViewById(R.id.next);
        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (month.get(Calendar.MONTH) == Calendar.SUNDAY) {
                    month.set((month.get(Calendar.YEAR) + 1), month.getActualMinimum(Calendar.MONTH), 1);
                } else {
                    month.set(Calendar.MONTH, month.get(Calendar.MONTH) + 1);
                }
                refreshCalendar();

            }
        });

        gridview.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                // TODO what happens if click on date
                TextView date = (TextView) v.findViewById(R.id.date);
                System.out.println(date);
                System.out.println(date.getText());
                /*if(date instanceof TextView && !date.getText().equals("")) {

                    Intent intent = new Intent();
                    String day = date.getText().toString();
                    if(day.length()==1) {
                        day = "0"+day;
                    }
                    // return chosen date as string format
                    intent.putExtra("date", android.text.format.DateFormat.format("yyyy-MM", month)+"-"+day);
                    setResult(RESULT_OK, intent);
                    finish();
                }*/

            }
        });
    }

    public void refreshCalendar() {
        TextView title = (TextView) findViewById(R.id.title);

        adapter.refreshDays();
        adapter.notifyDataSetChanged();
        handler.post(calendarUpdater); // generate some random calendar items

        title.setText(android.text.format.DateFormat.format("MMMM yyyy", month));
    }

    public void onNewIntent(Intent intent) {
        // TODO rem intent & get real date
        month.set(2017, 2, 3);
    }

    private void createMenu() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.chart_tiles);

        // horizontal layout
        LinearLayout layoutMenu = new LinearLayout(this);
        layoutMenu.setOrientation(LinearLayout.HORIZONTAL);
        ViewGroup.LayoutParams paramsMenu = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        layoutMenu.setLayoutParams(paramsMenu);
        layoutMenu.setPadding(14, 0, 0, 0);
        layout.addView(layoutMenu);

        // menu buttons
        for (final Tile tile : InitTiles.getMenuTiles()) {
            Button buttonTile = new Button(this);
            buttonTile.setBackgroundResource(tile.getIcon());
            buttonTile.setOnClickListener(new View.OnClickListener() { // TODO extract
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(ChartActivity.this, ((TileMenu) tile).getClassToSwitch());
                    startActivity(intent);
                }
            });
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    tile.getWidth(), tile.getHeight());
            params.setMargins(10, 0, 10, 0);
            buttonTile.setLayoutParams(params);
            layoutMenu.addView(buttonTile);
        }
    }
}
