package com.example.philipp.lifetiles;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;


public class ChartActivity extends RootActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chart_tiles);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbarChartActivity);
        this.setSupportActionBar(myToolbar);
        createMenu(ChartActivity.class);

        LinearLayout layout = (LinearLayout) findViewById(R.id.theActivityChart);
        createHeadline(layout, "Diagram");
        createBarChart(layout);
    }

    private void createBarChart(LinearLayout layout) {
        BarChart barchart = new BarChart(this);

        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(22f,0));
        barEntries.add(new BarEntry(12f,1));
        barEntries.add(new BarEntry(33f,2));
        barEntries.add(new BarEntry(56f,3));
        barEntries.add(new BarEntry(14f,4));
        BarDataSet barDataSetNumbers = new BarDataSet(barEntries, "Numbers");

        ArrayList<String> dates = new ArrayList<>();
        dates.add("aaaa");
        dates.add("bbbb");
        dates.add("cccc");
        dates.add("dddd");
        dates.add("eeee");
        BarDataSet barDataSetDates = new BarDataSet(barEntries, "Dates");

        BarData barData = new BarData(barDataSetDates, barDataSetNumbers);
        barchart.setData(barData);
        LinearLayout.LayoutParams barChartParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 400);
        barchart.setLayoutParams(barChartParams);

        barchart.setTouchEnabled(true);

        layout.addView(barchart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tiles, menu);
        return true;
    }

   /*  public Calendar month;
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
    }; */

   /* public void onCreate(Bundle savedInstanceState) {

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
                }/

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
*/
}
