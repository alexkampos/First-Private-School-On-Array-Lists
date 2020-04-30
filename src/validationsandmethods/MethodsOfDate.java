/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validationsandmethods;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author AlexKampos
 */
public class MethodsOfDate {

    public static Calendar calendar = Calendar.getInstance();

    /*
    Validation for date
     */
    public static boolean isValidDate(String s) {
        String regex = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher((CharSequence) s);
        return matcher.matches();
    }

    /*
    Method to change the European style date user inserts, to the American one
     */
    public static String reformDate(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(3));
        sb.append(s.charAt(4));
        sb.append(s.charAt(2));
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 5; i < 10; i++) {
            sb.append(s.charAt(i));
        }
        s = sb.toString();
        return s;
    }

    /*
    Method so it won't let user add an assignment on  weekend
     */
    public static boolean subValidDate(String s) {
        s = reformDate(s);
        Date date = new Date(s);
        calendar.setTime(date);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        if (dayOfWeek == 1 || dayOfWeek == 7) {
            return false;
        } else {
            return true;
        }
    }

    public static String dateToString(Date date) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String dateGiven = sdf.format(date);
        return dateGiven;
    }
}
