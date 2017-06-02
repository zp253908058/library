package com.future.library.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Class description:
 *
 * @author zp
 * @version 1.0
 * @see FormatUtils
 * @since 2017/5/12
 */

public class FormatUtils {
    private static final String TAG = CollectionsUtils.class.getSimpleName();

    private static final String FORMAT_DATE_TIME_FULL = "yyyy-MM-dd HH:mm:ss";
    private static final String FORMAT_DATE_TIME_SEMI = "yyyy-MM-dd HH:mm";
    private static final String FORMAT_DATE_FULL = "yyyy-MM-dd";
    private static final String FORMAT_TIME_FULL = "HH:mm:ss";
    private static final String FORMAT_TIME_SEMI = "HH:mm";

    private static final SimpleDateFormat sDateFormat = new SimpleDateFormat(FORMAT_DATE_TIME_FULL, Locale.getDefault());

    private FormatUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param millis 毫秒时间戳
     * @return 时间字符串
     */
    public static String millisToString(long millis) {
        return millisToString(millis, FORMAT_DATE_TIME_FULL);
    }

    /**
     * 将时间戳转为时间字符串
     * <p>格式为format</p>
     *
     * @param millis  毫秒时间戳
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String millisToString(long millis, String pattern) {
        sDateFormat.applyPattern(pattern);
        return sDateFormat.format(new Date(millis));
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return 毫秒时间戳
     */
    public static long stringToMillis(String time) {
        return stringToMillis(time, FORMAT_DATE_TIME_FULL);
    }

    /**
     * 将时间字符串转为时间戳
     * <p>time格式为format</p>
     *
     * @param time    时间字符串
     * @param pattern 时间格式
     * @return 毫秒时间戳
     */
    public static long stringToMillis(String time, String pattern) {
        try {
            sDateFormat.applyPattern(pattern);
            return sDateFormat.parse(time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param time 时间字符串
     * @return Date类型
     */
    public static Date stringToDate(String time) {
        return stringToDate(time, FORMAT_DATE_TIME_FULL);
    }

    /**
     * 将时间字符串转为Date类型
     * <p>time格式为format</p>
     *
     * @param time   时间字符串
     * @param pattern 时间格式
     * @return Date类型
     */
    public static Date stringToDate(String time, String pattern) {
        try {
            sDateFormat.applyPattern(pattern);
            return sDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Date类型转为时间字符串
     * <p>格式为yyyy-MM-dd HH:mm:ss</p>
     *
     * @param date Date类型时间
     * @return 时间字符串
     */
    public static String dateToString(Date date) {
        return dateToString(date, FORMAT_DATE_TIME_FULL);
    }

    /**
     * 将Date类型转为时间字符串
     * <p>格式为format</p>
     *
     * @param date   Date类型时间
     * @param pattern 时间格式
     * @return 时间字符串
     */
    public static String dateToString(Date date, String pattern) {
        sDateFormat.applyPattern(pattern);
        return sDateFormat.format(date);
    }
}
