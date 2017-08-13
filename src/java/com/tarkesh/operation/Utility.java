/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tarkesh.operation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Abhishek.Sehgal
 */
public class Utility {

    private Calendar c;

    public Calendar getCalender(String day, String month, String hour, String minute, String nextday) {
        c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        c.set(Calendar.MONTH, Integer.parseInt(month));
        // c.set(Calendar.DAY_OF_MONTH,Integer.parseInt(year));
        c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        c.set(Calendar.MINUTE, Integer.parseInt(minute));
        c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(nextday));
        return c;
    }

    public  String getModifiedTime(Date date) {
        return new SimpleDateFormat("HH:mm").format(date);

    }
}
