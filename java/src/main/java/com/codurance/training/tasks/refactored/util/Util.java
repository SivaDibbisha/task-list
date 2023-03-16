package com.codurance.training.tasks.refactored.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

    private static long lastId = 0;

    public static long nextId() {
        return ++lastId;
    }


    public static String dateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = dateFormat.format(date.getTime());
        return strDate;
    }

    public static boolean isValidTaskId(String w) {
        return w.matches("[A-Za-z0-9]*");
    }
}
