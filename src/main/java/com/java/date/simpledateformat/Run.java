package com.java.date.simpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Gary
 * @since 2019/12/10 14:11
 */
public class Run {
    public static void main(String[] args) throws ParseException {
        String pattern = "yyyy-MM-dd'T'HH:mm:ss.sss'Z'";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        String date = "2020-07-07T16:00:00.000Z";
        Date parse = sdf.parse(date);
        System.out.println(parse);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf2.format(parse));
    }
}
