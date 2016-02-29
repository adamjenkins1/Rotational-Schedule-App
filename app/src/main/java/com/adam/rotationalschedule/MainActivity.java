package com.adam.rotationalschedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.text.DateFormat;
import java.util.Date;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setTitle("2015-16");

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */


    }
    @Override
    protected void onStart() {
        super.onStart();
        TextView date = (TextView) findViewById(R.id.date);
        String curDate = DateFormat.getDateTimeInstance().format(new Date());
        date.setText("Today is " + curDate);
        Button scheduleDay = (Button) findViewById(R.id.scheduleDay);
        Button scheduleMonth = (Button) findViewById(R.id.scheduleMonth);
        //Button calcBtn = (Button) findViewById(R.id.calcBtn);
        //calcBtn.setOnClickListener(new View.OnClickListener() {
        scheduleDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, scheduleDay.class));
            }
        });

        scheduleMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, scheduleMonth.class));
            }
        });
    }



    /*
    Calendar c = Calendar.getInstance();
    System.out.println("Current time => " + c.getTime());

    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
    String formattedDate = df.format(c.getTime());
    */
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */

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
}
