package com.ajay.maplocation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

/*
 Created by : Ajay P. Prajapati
 */

public class MainActivity extends AppCompatActivity {

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        // Initialize UI elements
        final EditText addrText = (EditText) findViewById(R.id.location);
        final Button button = (Button) findViewById(R.id.mapButton);

        // Link UI elements to actions in code
        button.setOnClickListener(new View.OnClickListener() {

            // Called when user clicks the Show Map button
            public void onClick(View v) {
                try {

                    // Process text for network transmission
                    String address = addrText.getText().toString();
                    address = address.replace(' ', '+');

                    // Create Intent object for starting Google Maps application
                    Intent geoIntent = new Intent(
                            android.content.Intent.ACTION_VIEW, Uri
                            .parse("geo:0,0?q=" + address));

                    // Use the Intent to start Google Maps application using Activity.startActivity()
                    startActivity(geoIntent);

                } catch (Exception e) {
                    // Log any error messages to LogCat using Log.e()
                    Log.e("TAG", e.toString());
                }
            }
        });


    }

    //Button onClick method
    public void implicitSendText(View v){

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_TEXT, "Hello From CodeMeaning.com");
        intent.setType("text/plain");

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    //Button onClick method
    public void explictButton(View v){
        Intent intent = new Intent(this, ActivityB.class);

        // Verify that the intent will resolve to an activity
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG", "The activity is visible and about to be started.");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("TAG", "The activity is visible and about to be restarted.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("TAG", "The activity is and has focus (it is now \"resumed\")");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("TAG",
                "Another activity is taking focus (this activity is about to be \"paused\")");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("TAG", "The activity is no longer visible (it is now \"stopped\")");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "The activity is about to be destroyed.");
    }
}
