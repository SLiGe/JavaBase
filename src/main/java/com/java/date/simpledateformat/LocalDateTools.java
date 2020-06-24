package com.java.date.simpledateformat;

import java.text.SimpleDateFormat;

/**
 * @author Gary
 * @since 2019/12/10 14:19
 */
public class LocalDateTools {
    private static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();

    public static SimpleDateFormat getSimpleDateFormat(String datePattern) {
        SimpleDateFormat sdf = null;
        sdf = tl.get();
        if (sdf == null) {
            sdf = new SimpleDateFormat(datePattern);
            tl.set(sdf);
        }
        return sdf;
    }

}
