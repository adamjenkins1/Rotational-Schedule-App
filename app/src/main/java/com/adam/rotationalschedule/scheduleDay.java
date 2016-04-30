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

        TextView errorMessage = (TextView) findViewById(R.id.test);
        ImageView schedule = (ImageView) findViewById(R.id.daySchedule);
        ImageView finalSchedule = (ImageView) findViewById(R.id.finalSchedule);
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
            if(day == 11) //holidays count in the rotational schedule but shouldn't be in the map
                period = 2;

            // all weekends in April and spring break should not be added
            if( !(day >= 2 && day <= 10) && day != 16 && day != 17 && day != 23 && day != 24) {
                if(period >= 7)
                    period = 1;
                hm.put("Apr " + Integer.toString(day), period);
                period++;
            }
        }
        for (int day = 2; day < 28; day++)
        {
            // all weekends in May should not be added
            if(day != 7 && day != 8 && day != 14 && day != 15 && day != 21 && day != 22) {
                if(period >= 7)
                    period = 1;
                hm.put("May " + Integer.toString(day), period);
                period++;
            }
        }
        int iHour = 0;
        String fullDate = DateFormat.getDateInstance().format(new Date());
        String fullTime = DateFormat.getTimeInstance().format(new Date());
        String sHour = fullTime.substring(1, Math.min(fullDate.length(), 2));
        if(sHour.equals(":"))
            iHour = Integer.parseInt(fullTime.substring(0, Math.min(fullTime.length(), 1)));
        else
            iHour = Integer.parseInt(fullTime.substring(0, Math.min(fullTime.length(), 2)));
        String curMonth = fullDate.substring(0, Math.min(fullDate.length(), 3));
        int day = 0;
        String AMPM = "";

        if(fullTime.length() == 10)
            AMPM = fullTime.substring(8, Math.min(fullTime.length(), 10));
        else //fullTime.length() = 11
            AMPM = fullTime.substring(9, Math.min(fullTime.length(), 11));
        String curDate = "";

        if(fullDate.length() == 11) { //fullDate = "Mar 1, 2016"
            curDate = fullDate.substring(0, Math.min(fullDate.length(), 5));
        }
        else //fullDate.length() == 12 //fullDate = "Mar 11, 2016"
            curDate = fullDate.substring(0, Math.min(fullDate.length(), 6));

        //iHour = 3;
        //curDate = "Apr 29";
        if (iHour >= 3 && iHour != 12 && AMPM.equals("PM")) {
            if(curDate.length() == 5) { //curDate = "Feb 1"
                day = Integer.parseInt(curDate.substring(4, Math.min(curDate.length(), 5)));
                day++;
            }
            else if (curDate.equals("Feb 29")){
                day = 1;
                curMonth = "Mar";
            }
            else if(curDate.equals("Mar 31")) {
                day = 1;
                curMonth = "Apr";
            }
            else if(curDate.equals("Apr 30")) {
                day = 1;
                curMonth = "May";
            }
            else {
                day = Integer.parseInt(curDate.substring(4, Math.min(curDate.length(), 6)));
                day++;
            }
            errorMessage.setText("Tomorrow's Schedule");
            curDate = (curMonth + " " + Integer.toString(day));
        }
        //curDate = "May 2";
        //errorMessage.setText(curDate);
        int curPeriod = 0;
        if(hm.get(curDate) != null) {
            curPeriod = hm.get(curDate);
        }
        else {
            errorMessage.setText("No school today.\n Enjoy your day off!");
            //errorMessage.setText(fullDate);
            //errorMessage.setText(Integer.toString(iHour));
            //errorMessage.setText(sHour);
            schedule.setImageResource(R.drawable.freedom);
            return;
        }

        //special cases: finals week
        if(curDate.equals("May 25")) {
            finalSchedule.setImageResource(R.drawable.finals_day_1_nobg);
            return;
        }
        if(curDate.equals("May 26")) {
            finalSchedule.setImageResource(R.drawable.finals_day_2_nobg);
            return;
        }
        if(curDate.equals("May 27")) {
            finalSchedule.setImageResource(R.drawable.finals_day_3_nobg);
            return;
        }

        curPeriod--;
        int[] collabDays = new int[6];
        collabDays[0] = R.drawable.start_with_1_collab_nobg;
        collabDays[1] = R.drawable.start_with_2_collab_nobg;
        collabDays[2] = R.drawable.start_with_3_collab_nobg;
        collabDays[3] = R.drawable.start_with_4_collab_nobg;
        collabDays[4] = R.drawable.start_with_5_collab_nobg;
        collabDays[5] = R.drawable.start_with_6_collab_nobg;

        //special cases: collaboration days
        if(curDate.equals("Mar 2") || curDate.equals("Mar 16") || curDate.equals("Apr 13")
                || curDate.equals("Apr 27") || curDate.equals("May 4")) {

            schedule.setImageResource(collabDays[curPeriod]);
            return;
        }

        int[] regularDays = new int[6];
        regularDays[0] = R.drawable.start_with_1_nobg;
        regularDays[1] = R.drawable.start_with_2_nobg;
        regularDays[2] = R.drawable.start_with_3_nobg;
        regularDays[3] = R.drawable.start_with_4_nobg;
        regularDays[4] = R.drawable.start_with_5_nobg;
        regularDays[5] = R.drawable.start_with_6_nobg;

        schedule.setImageResource(regularDays[curPeriod]);

    } //end onCreate()
}