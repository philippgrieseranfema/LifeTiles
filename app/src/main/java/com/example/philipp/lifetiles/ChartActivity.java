package com.example.philipp.lifetiles;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.philipp.lifetiles.components.Category;
import com.example.philipp.lifetiles.components.Entry;
import com.example.philipp.lifetiles.components.Tile;
import com.example.philipp.lifetiles.db.DBFixtures;
import com.example.philipp.lifetiles.db.DBHandler;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChartActivity extends RootActivity {

    DBHandler dbHandler = new DBHandler(this);
    List<Integer> colors = Arrays.asList(
            new Color().rgb(247, 205, 115), // yellow
            new Color().rgb(108, 171, 240), // blue
            new Color().rgb(141, 243, 151), // green
            new Color().rgb(246, 104, 97)); // red

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarChartActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(ChartActivity.class);

        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityChart);
        createHeadline(layout, "Your Activities");

        createButtonTodayWeek(layout);
        createBarChart(layout);
        createButtonBottom(layout);
        createSelectionPreview(layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

    private void createButtonTodayWeek(LinearLayout layout) {
        LinearLayout linearLayout = new LinearLayout(this);
        final Button buttonDay = new Button(this);
        final Button buttonWeek = new Button(this);

        LinearLayout relativeLayoutDay = new LinearLayout(this);

        buttonDay.setBackgroundResource(R.drawable.button_today_pressed);
        LinearLayout.LayoutParams paramsButtonDay = new LinearLayout.LayoutParams(
                100, 50);
        relativeLayoutDay.addView(buttonDay, paramsButtonDay);
        buttonDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDay.setBackgroundResource(R.drawable.button_today_pressed);
                buttonWeek.setBackgroundResource(R.drawable.button_week);
            }
        });
        relativeLayoutDay.setGravity(Gravity.LEFT);
        linearLayout.addView(relativeLayoutDay);

        RelativeLayout relativeLayoutWeek = new RelativeLayout(this);
        buttonWeek.setBackgroundResource(R.drawable.button_week);
        LinearLayout.LayoutParams paramsButtonWeek = new LinearLayout.LayoutParams(
                100, 50);
        relativeLayoutWeek.addView(buttonWeek, paramsButtonWeek);
        buttonWeek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonDay.setBackgroundResource(R.drawable.button_today);
                buttonWeek.setBackgroundResource(R.drawable.button_week_pressed);
            }
        });
        relativeLayoutWeek.setGravity(Gravity.RIGHT);
        linearLayout.addView(relativeLayoutWeek);

        linearLayout.setPadding(40, 40, 40, 0);
        linearLayout.setGravity(Gravity.RIGHT);

        layout.addView(linearLayout);
    }

    private void createButtonBottom(LinearLayout layout) {
        RelativeLayout relativeLayout2 = new RelativeLayout(this);
        Button buttonChartBottom = new Button(this);
        buttonChartBottom.setBackgroundResource(R.drawable.chart_bottom);
        LinearLayout.LayoutParams paramsButton2 = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 6);
        relativeLayout2.addView(buttonChartBottom, paramsButton2);
        relativeLayout2.setPadding(20, 0, 20, 20);
        relativeLayout2.setGravity(Gravity.RIGHT);
        layout.addView(relativeLayout2);
    }

    private void createBarChart(LinearLayout layout) {
        BarChart barchart = new BarChart(this);

        List<IBarDataSet> barDataSets = new ArrayList<>();
        int i = 0;
        for (Category category : dbHandler.getCategories()) {
            ArrayList<BarEntry> barEntries = new ArrayList<>();
            ArrayList<Integer> alreadyInChart = new ArrayList<>();

            for (Entry entry : dbHandler.getEntriesOfCategory(category.getId())) {
                int count = dbHandler.getEntryCount(entry.getTile().getId());

                if (!alreadyInChart.contains(entry.getTile().getId())) {
                    if (0 < count) {
                        barEntries.add(new BarEntry(i, count));
                        i++;
                    }
                }
                alreadyInChart.add(entry.getTile().getId());
            }

            BarDataSet barDataSet = new BarDataSet(barEntries, "data");
            barDataSet.setColor(colors.get(category.getColor())); // TODO
            barDataSets.add(barDataSet);
        }


        BarData barData = new BarData(barDataSets);
        barchart.setData(barData);

        Description d = new Description();// no description
        d.setText("");
        barchart.setDescription(d);
        barchart.setNoDataTextColor(Color.WHITE);
        barchart.animateY(2000); // animate
        barchart.getAxisLeft().setDrawGridLines(false); // hide background grid
        barchart.getAxisLeft().setEnabled(false);
        barchart.getAxisRight().setDrawGridLines(false);
        barchart.getAxisRight().setEnabled(false);
        barchart.getXAxis().setDrawGridLines(false);
        barchart.getXAxis().setEnabled(false);
        barchart.getAxisLeft().setStartAtZero(true);
        barchart.getAxisLeft().setAxisMaximum(3);
        barchart.getAxisLeft().setAxisMinimum(0);
        barchart.setMaxVisibleValueCount(0); // hide bar values
        barchart.getLegend().setEnabled(false); // hide legend


        RelativeLayout relativeLayout = new RelativeLayout(this);
        LinearLayout.LayoutParams barChartParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 350);
        barchart.setLayoutParams(barChartParams);
        barchart.setTouchEnabled(true);
        relativeLayout.addView(barchart);
        relativeLayout.setPadding(0, 0, 0, 30 * -1);

        layout.addView(relativeLayout);
        layout.invalidate();
    }

    private void createSelectionPreview(LinearLayout layout) {
        createHeadline(layout, "Selection Detail");

        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setPadding(30, 30, 0, 30);


        Tile newTile = DBFixtures.getNewTileCategory().getTiles().get(0);
        Button buttonNew = new Button(this);
        buttonNew.setBackgroundResource(R.drawable.tile_white);
        LinearLayout.LayoutParams paramsButton = new LinearLayout.LayoutParams(
                newTile.getWidth(), newTile.getHeight());
        buttonNew.setPadding(20, 0, 0, 20);
        relativeLayout.addView(buttonNew, paramsButton);

        RelativeLayout relativeLayoutSave = new RelativeLayout(this);
        relativeLayoutSave.setPadding(600, 10, 0, 0);
        Button buttonSave = new Button(this);
        buttonSave.setBackgroundResource(R.drawable.save_02);
        LinearLayout.LayoutParams paramsButtonSave = new LinearLayout.LayoutParams(
                newTile.getWidth(), newTile.getHeight());
        relativeLayoutSave.addView(buttonSave, paramsButtonSave);
        relativeLayout.addView(relativeLayoutSave);


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
}
