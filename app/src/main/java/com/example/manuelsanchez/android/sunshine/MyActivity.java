package com.example.manuelsanchez.android.sunshine;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends ActionBarActivity {

    private final String LOG_TAG = MyActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // The activity is being created.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }
        Log.d(LOG_TAG, "onCreate()");

    }

    @Override
    protected void onStart() {
        // The activity is about to become visible.
        super.onStart();

        Log.d(LOG_TAG, "onStart()");

    }

    @Override
    protected void onResume() {
        // The activity has become visible (it is now "resumed").
        super.onResume();
        Log.d(LOG_TAG, "onResume()");

    }

    @Override
    protected void onPause() {
        // Another activity is taking focus (this activity is about to be "paused").
        super.onPause();
        Log.d(LOG_TAG, "onPause()");

    }

    @Override
    protected void onStop() {
        // The activity is no longer visible (it is now "stopped")
        super.onStop();
        Log.d(LOG_TAG, "onStop()");

    }

    @Override
    protected void onDestroy() {
        // The activity is about to be destroyed.
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy()");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }
        if (id == R.id.action_map) {
            openPreferredLocationInMap();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openPreferredLocationInMap() {

        String location = Utility.getPreferredLocation(this);
        // Using the URI scheme for showing a location found on a map.  This super-handy
        // intent can is detailed in the "Common Intents" page of Android's developer site:
        // http://developer.android.com/guide/components/intents-common.html#Maps
        Uri geoLocation = Uri.parse("geo:0,0?").buildUpon()
                .appendQueryParameter("q", location)
                .build();

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d(LOG_TAG, "Couldn't call " + location + ", no receiving apps installed!");
        }
    }



}
