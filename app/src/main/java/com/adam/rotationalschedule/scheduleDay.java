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
        toolbar.setTitle("2017-18");
        //setSupportActionBar(toolbar);

        TextView errorMessage = (TextView) findViewById(R.id.test);
        ImageView schedule = (ImageView) findViewById(R.id.daySchedule);
        ImageView finalSchedule = (ImageView) findViewById(R.id.finalSchedule);
        Map<String, Integer> hm = new HashMap<>();
        Map<Integer, Integer> regularDays = new HashMap<>();
        regularDays.put(1, R.drawable.start_with_1_nobg);
        regularDays.put(2, R.drawable.start_with_2_nobg);
        regularDays.put(3, R.drawable.start_with_3_nobg);
        regularDays.put(4, R.drawable.start_with_4_nobg);
        regularDays.put(5, R.drawable.start_with_5_nobg);
        regularDays.put(6, R.drawable.start_with_6_nobg);

        Map<Integer, Integer> collabDays = new HashMap<>();
        collabDays.put(1, R.drawable.start_with_1_collab_nobg);
        collabDays.put(2, R.drawable.start_with_2_collab_nobg);
        collabDays.put(3, R.drawable.start_with_3_collab_nobg);
        collabDays.put(4, R.drawable.start_with_4_collab_nobg);
        collabDays.put(5, R.drawable.start_with_5_collab_nobg);
        collabDays.put(6, R.drawable.start_with_6_collab_nobg);

        Map<Integer, Integer> minDays = new HashMap<>();
        minDays.put(1, R.drawable.start_with_1_min_nobg);
        minDays.put(2, R.drawable.start_with_2_min_nobg);
        minDays.put(3, R.drawable.start_with_3_min_nobg);
        minDays.put(4, R.drawable.start_with_4_min_nobg);
        minDays.put(5, R.drawable.start_with_5_min_nobg);
        minDays.put(6, R.drawable.start_with_6_min_nobg);

        int period = 1;
        for (int day = 10; day < 32; day++)
        {
            if(day != 12 && day != 13 && day != 19 && day != 20 && day != 26 && day != 27) {
                if(period >= 7)
                    period = 1;
                if(day == 16)
                    hm.put("Aug " + Integer.toString(day), collabDays.get(period));
                else if(day == 10)
                    hm.put("Aug " + Integer.toString(day), minDays.get(period));
                else
                    hm.put("Aug " + Integer.toString(day), regularDays.get(period));
                period++;
            }
        }

        for (int day = 1; day < 30; day++)
        {
            if(day != 2 && day != 3 && day != 9 && day != 10 && day != 16 && day != 17
                    && day != 23 && day != 24) {
                if(period >= 7)
                    period = 1;
                if(day != 4) {
                    if(day == 6 || day == 20)
                        hm.put("Sep " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Sep " + Integer.toString(day), regularDays.get(period));
                }
                period++;
            }
        }

        for (int day = 2; day < 32; day++)
        {
            if(day != 7 && day != 8 && day != 14 && day != 15 && day != 21 && day != 22
                    && day != 28 && day != 29) {
                if(period >= 7)
                    period = 1;
                if(day != 9) {
                    if(day == 4 || day == 18)
                        hm.put("Oct " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Oct " + Integer.toString(day), regularDays.get(period));
                }
                period++;
            }
        }

        for (int day = 1; day < 31; day++)
        {
            if(day != 4 && day != 5 && day != 11 && day != 12 && day != 18 && day != 19
                    && day != 25 && day != 26) {
                if(period >= 7)
                    period = 1;
                if(day != 10 && (day < 20 || day > 24)) {
                    if(day == 1 || day == 15)
                        hm.put("Nov " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Nov " + Integer.toString(day), regularDays.get(period));
                }
                period++;
            }
        }

        for (int day = 1; day < 19; day++)
        {
            if(day != 2 && day != 3 && day != 9 && day != 10 && day != 16 && day != 17) {
                if(period >= 7)
                    period = 1;
                if(day == 6)
                    hm.put("Dec " + Integer.toString(day), collabDays.get(period));
                else
                    hm.put("Dec " + Integer.toString(day), regularDays.get(period));
                period++;
            }
        }

        hm.put("Dec 19", R.drawable.finals_day_1_nobg);
        hm.put("Dec 20", R.drawable.finals_day_2_nobg);
        hm.put("Dec 21", R.drawable.finals_day_3_nobg);

        period = 1;
        for (int day = 8; day < 32; day++)
        {
            if(day != 13 && day != 14 && day != 20 && day != 21 && day != 27 && day != 28) {
                if(period >= 7)
                    period = 1;
                if(day != 15) {
                    if(day == 17 || day == 31)
                        hm.put("Jan " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Jan " + Integer.toString(day), regularDays.get(period));
                }
                period++;
            }
        }

        for (int day = 1; day < 29; day++)
        {
            if(day != 3 && day != 4 && day != 10 && day != 11 && day != 17 && day != 18
                    && day != 24 && day != 25) {
                if(period >= 7)
                    period = 1;
                if(day < 20 || day > 24) {
                    if(day == 1 || day == 15)
                        hm.put("Feb " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Feb " + Integer.toString(day), regularDays.get(period));
                }
                period++;
            }
        }

        for (int day = 1; day < 31; day++)
        {
            if(day != 3 && day != 4 && day != 10 && day != 11 && day != 17 && day != 18
                    && day != 24 && day != 25) {
                if(period >= 7)
                    period = 1;
                    if(day == 7 || day == 21)
                        hm.put("Mar " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Mar " + Integer.toString(day), regularDays.get(period));
                period++;
            }
        }

        for (int day = 2; day < 31; day++)
        {
            if(day != 7 && day != 8 && day != 14 && day != 15 && day != 21 && day != 22
                    && day != 28 && day != 29) {
                if(period >= 7)
                    period = 1;
                if(day < 9 || day > 13) {
                    if(day == 4 || day == 25)
                        hm.put("Apr " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("Apr " + Integer.toString(day), regularDays.get(period));
                }
                period++;
            }
        }

        for (int day = 1; day < 29; day++)
        {
            if(day != 5 && day != 6 && day != 12 && day != 13 && day != 19 && day != 20
                    && day != 26 && day != 27) {
                if(period >= 7)
                    period = 1;
                    if(day == 9)
                        hm.put("May " + Integer.toString(day), collabDays.get(period));
                    else
                        hm.put("May " + Integer.toString(day), regularDays.get(period));
                period++;
            }
        }
        hm.put("May 29", R.drawable.finals_day_1_nobg);
        hm.put("May 30", R.drawable.finals_day_2_nobg);
        hm.put("May 31", R.drawable.finals_day_3_nobg);
        int iHour = 0;
        String fullDate = DateFormat.getDateInstance().format(new Date());
        String fullTime = DateFormat.getTimeInstance().format(new Date());
        String sHour = fullTime.substring(1, Math.min(fullDate.length(), 2));
        if(sHour.equals(":"))
            iHour = Integer.parseInt(fullTime.substring(0, Math.min(fullTime.length(), 1)));
        else
            iHour = Integer.parseInt(fullTime.substring(0, Math.min(fullTime.length(), 2)));
        String curMonth = fullDate.substring(0, Math.min(fullDate.length(), 4));
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

        if (iHour >= 3 && iHour != 12 && AMPM.equals("PM")) {
            if(curDate.length() == 5) { //curDate = "Feb 1"
                day = Integer.parseInt(curDate.substring(4, Math.min(curDate.length(), 5)));
                day++;
            }
            else if (curDate.equals("Aug 31")){
                day = 1;
                curMonth = "Sep ";
            }
            else if(curDate.equals("Sep 29")) {
                day = 1;
                curMonth = "Oct ";
            }
            else if(curDate.equals("Oct 31")) {
                day = 1;
                curMonth = "Nov ";
            }
            else if(curDate.equals("Nov 30")) {
                day = 1;
                curMonth = "Dec ";
            }
            else if(curDate.equals("Dec 29")) {
                day = 1;
                curMonth = "Jan ";
            }
            else if(curDate.equals("Jan 31")) {
                day = 1;
                curMonth = "Feb ";
            }
            else if(curDate.equals("Feb 28")) {
                day = 1;
                curMonth = "Mar ";
            }
            else if(curDate.equals("Mar 30")) {
                day = 1;
                curMonth = "Apr ";
            }
            else if(curDate.equals("Apr 30")) {
                day = 1;
                curMonth = "May ";
            }
            else {
                day = Integer.parseInt(curDate.substring(4, Math.min(curDate.length(), 6)));
                day++;
            }
            errorMessage.setText("Tomorrow's Schedule");
            curDate = (curMonth + Integer.toString(day));
        }
        //curDate = "May 2";
        //errorMessage.setText(curDate);
        //int curPeriod = 0;
        if(hm.get(curDate) != null) {
            if(curDate.equals("Dec 19") || curDate.equals("Dec 20") || curDate.equals("Dec 21")
                    || curDate.equals("May 29") || curDate.equals("May 30") || curDate.equals("May 31"))
                finalSchedule.setImageResource(hm.get(curDate));
            else
                schedule.setImageResource(hm.get(curDate));
        }
        else {
            errorMessage.setText("No school today.\n Enjoy your day off!");

            //errorMessage.setText(fullDate);
            //errorMessage.setText(Integer.toString(iHour));
            //errorMessage.setText(sHour);
            schedule.setImageResource(R.drawable.freedom);
        }
    } //end onCreate()
}