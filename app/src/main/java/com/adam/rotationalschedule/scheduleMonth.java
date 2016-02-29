package com.adam.rotationalschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;

public class scheduleMonth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_month);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("2015-16");
        //setSupportActionBar(toolbar);
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

    protected void onStart() {
        super.onStart();
        TextView errorMessage = (TextView) findViewById(R.id.errorMessage);
        ImageView monthPicture = (ImageView) findViewById(R.id.monthPicture);
        String curDate = DateFormat.getDateInstance().format(new Date());
        Button next = (Button) findViewById(R.id.next);
        Button prev = (Button) findViewById(R.id.prev);
        final String curMonth = curDate.substring(0, Math.min(curDate.length(), 3));
        //errorMessage.setText(curMonth);
        //String curMonth = "Mar";
        errorMessage.setText("");
        int integerCurMonth = 0;
        switch(curMonth) {
            case "Feb": {
                monthPicture.setImageResource(R.drawable.feburary_nobg);
                integerCurMonth = 2;
                break;
            }
            case "Mar": {
                monthPicture.setImageResource(R.drawable.march_nobg);
                integerCurMonth = 3;
                break;
            }
            case "Apr": {
                monthPicture.setImageResource(R.drawable.april_nobg);
                integerCurMonth = 4;
                break;
            }
            case "May": {
                monthPicture.setImageResource(R.drawable.may_nobg);
                integerCurMonth = 5;
                break;
            }
            default: {
                //errorMessage.setText("Month could not be found");
                errorMessage.setText("Month could not be found");
                monthPicture.setImageResource(R.drawable.homer_doh_nobg);
                break;
            }
        }// end switch(curMonth)
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*switch (curMonth)
                {
                    case "Feb": {
                        startActivity(new Intent(scheduleMonth.this, scheduleMonth.class));
                        android.os.Process.killProcess(android.os.Process.myPid());
                        break;
                    }
                }
                */
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //integerCurMonth--;
            }
        });

    } // end onStart()
}