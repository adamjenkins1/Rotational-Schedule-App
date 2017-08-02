package com.adam.rotationalschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class scheduleMonth extends AppCompatActivity {
    int curMonth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_month);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("2017-18");
        //setSupportActionBar(toolbar);
    }

    protected void onStart() {
        super.onStart();
        final TextView errorMessage = (TextView) findViewById(R.id.errorMessage);
        final ImageView monthPicture = (ImageView) findViewById(R.id.monthPicture);
        //final ImageView freedom = (ImageView) findViewById(R.id.freedom);
        Calendar calendar = Calendar.getInstance();
        String curDate = DateFormat.getDateInstance().format(new Date());
        Button next = (Button) findViewById(R.id.next);
        Button prev = (Button) findViewById(R.id.prev);
        //String curMonth = curDate.substring(0, Math.min(curDate.length(), 3));
        curMonth = calendar.get(Calendar.MONTH);
        //errorMessage.setText(Integer.toString(curMonth));
        //errorMessage.setText(curDate);
        //curMonth--;
        //errorMessage.setText(curMonth);
        //String curMonth = "Mar";
        errorMessage.setText("");
        final int[] monthArray = new int[12];
        monthArray[0] = R.drawable.january_nobg;
        monthArray[1] = R.drawable.february_nobg;
        monthArray[2] = R.drawable.march_nobg;
        monthArray[3] = R.drawable.april_nobg;
        monthArray[4] = R.drawable.may_nobg;
        monthArray[5] = 0;
        monthArray[6] = 0;
        monthArray[7] = R.drawable.august_nobg;
        monthArray[8] = R.drawable.september_nobg;
        monthArray[9] = R.drawable.october_nobg;
        monthArray[10] = R.drawable.november_nobg;
        monthArray[11] = R.drawable.december_nobg;

        monthPicture.setImageResource(monthArray[curMonth]);

        //curMonth = 5;
        if(curMonth == 5 || curMonth == 6) {
            errorMessage.setText("Enjoy your break!\n School will resume in August");
            monthPicture.setImageResource(R.drawable.freedom);
            //monthPicture.setImageResource(0);
            //freedom.setImageResource(R.drawable.freedom);
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    curMonth++;
                    if(curMonth > 11)
                        curMonth = 0;
                while(monthArray[curMonth] == 0)
                    curMonth++;
                monthPicture.setImageResource(monthArray[curMonth]);
                errorMessage.setText("");
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curMonth--;
                if(curMonth < 0)
                    curMonth = 11;
                while(monthArray[curMonth] == 0)
                    curMonth--;
                monthPicture.setImageResource(monthArray[curMonth]);
                errorMessage.setText("");
            }
        });
    } // end onStart()
}