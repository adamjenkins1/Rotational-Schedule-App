package com.adam.rotationalschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class popup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("2015-16");
        //setSupportActionBar(toolbar);

        TextView message = (TextView) findViewById(R.id.message);
        String welcome = "If you find this app useful, tell your friends and drop " +
                "a rating at the Play Store! \nI strongly advise enabling automatic updating " +
                "for this app, so when I release an update for the next school year, you won't have to worry about it.";
        message.setText(welcome);

    }

}
