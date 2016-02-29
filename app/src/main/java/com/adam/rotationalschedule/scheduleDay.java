package com.adam.rotationalschedule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class scheduleDay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule_day);
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
        TextView errorMessage = (TextView) findViewById(R.id.test);
        ImageView schedule = (ImageView) findViewById(R.id.daySchedule);
        Map<String, Integer> hm = new HashMap<String, Integer>();
        hm.put("Feb 29", 2);
        int period = 3;
        for (int day = 1; day < 32; day++)
        {
            if(day != 5 && day != 6 && day != 12
                    && day != 13 && day != 19 && day != 20
                    && day != 26 && day != 27) {// all weekends in March should not be added
                if(period >= 7)
                    period = 1;
                hm.put("Mar " + Integer.toString(day), period);
                period++;
            }
        }
        for (int day = 1; day < 30; day++)
        {
            if(day != 2 && day != 3 && day != 4 && day != 5 && day != 6 && day != 7
                    && day != 8 && day != 9 && day != 10
                    && day != 16 && day != 17 && day != 23) {// all weekends in April and spring break should not be added
                if(period >= 7)
                    period = 1;
                hm.put("Apr " + Integer.toString(day), period);
                period++;
            }
        }
        for (int day = 1; day < 28; day++)
        {
            if(day != 1 && day != 7 && day != 8 && day != 14 && day != 15
                    && day != 21 && day != 22) {// all weekends in May should not be added
                if(period >= 7)
                    period = 1;
                hm.put("May " + Integer.toString(day), period);
                period++;
            }
        }
        String fullDate = DateFormat.getDateInstance().format(new Date());
        String curDate = fullDate.substring(5, Math.min(fullDate.length(), 6));
        int curPeriod = 0;
        if(curDate.equals(" "))
        {
            curDate = fullDate.substring(0, Math.min(fullDate.length(), 5));
        }
        else
            curDate = fullDate.substring(0, Math.min(fullDate.length(), 6));
        //curDate = "Feb 29";
        if(hm.get(curDate) != null) {
            curPeriod = hm.get(curDate);
        }
        else {
            errorMessage.setText("No school today.\n Enjoy your day off!");
            schedule.setImageResource(R.drawable.freedom);
            return;
        }
        //special cases: finals week
        if(curDate.equals("May 25")) {
            schedule.setImageResource(R.drawable.finals_day_1_nobg);
            return;
        }
        if(curDate.equals("May 26")) {
            schedule.setImageResource(R.drawable.finals_day_2_nobg);
            return;
        }
        if(curDate.equals("May 27")) {
            schedule.setImageResource(R.drawable.finals_day_3_nobg);
            return;
        }
        //special cases: collaboration days
        if(curDate.equals("Mar 2") || curDate.equals("Mar 16") || curDate.equals("Apr 13")
                || curDate.equals("Apr 27") || curDate.equals("May 4"))
        {
            switch (curPeriod)
            {
                case 1: {
                    schedule.setImageResource(R.drawable.start_with_1_collab_nobg);
                    break;
                }
                case 2: {
                    schedule.setImageResource(R.drawable.start_with_2_collab_nobg);
                    break;
                }
                case 3: {
                    schedule.setImageResource(R.drawable.start_with_3_collab_nobg);
                    break;
                }
                case 4: {
                    schedule.setImageResource(R.drawable.start_with_4_collab_nobg);
                    break;
                }
                case 5: {
                    schedule.setImageResource(R.drawable.start_with_5_collab_nobg);
                    break;
                }
                case 6: {
                    schedule.setImageResource(R.drawable.start_with_6_collab_nobg);
                    break;
                }
                default: {
                    schedule.setImageResource(R.drawable.homer_doh_nobg);
                    errorMessage.setText("Something went wrong...sorry");
                    break;
                }
            }
            return;
        }

        switch (curPeriod)
        {
            case 1: {
                schedule.setImageResource(R.drawable.start_with_1_nobg);
                break;
            }
            case 2: {
                schedule.setImageResource(R.drawable.start_with_2_nobg);
                break;
            }
            case 3: {
                schedule.setImageResource(R.drawable.start_with_3_nobg);
                break;
            }
            case 4: {
                schedule.setImageResource(R.drawable.start_with_4_nobg);
                break;
            }
            case 5: {
                schedule.setImageResource(R.drawable.start_with_5_nobg);
                break;
            }
            case 6: {
                schedule.setImageResource(R.drawable.start_with_6_nobg);
                break;
            }
            default: {
                schedule.setImageResource(R.drawable.homer_doh_nobg);
                break;
            }
        }
        /*
        if(hm.get("Mar 7") != null) {
            test2.setText("Mar 7 is in map");
        }
        else
            test2.setText("Mar 7 isn't in the map");

        String mapContents = "";
        Iterator<Map.Entry<String, Integer>> iter = hm.entrySet().iterator();
        while(iter.hasNext()) {
            String key = iter.next().getKey();
            mapContents = mapContents + (key + ", " + hm.get(key) + " \n");
        }
        test.setText(mapContents);
        */

    }
}


