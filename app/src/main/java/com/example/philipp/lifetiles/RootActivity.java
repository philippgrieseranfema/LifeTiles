package com.example.philipp.lifetiles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
}