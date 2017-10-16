package jp.tentus.commons.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日時に関するコンビニエンスメソッドを提供します。
 */
public class DateUtils {

    /**
     * うるう年かどうか判別します。
     *
     * @param year うるう年か判別する年。
     * @return うるう年なら true, それ以外なら false 。
     */
    public static boolean isLeapYear(int year) {
        if ((year % 4) == 0) {
            if (0 < (year % 100) || 0 == (year % 400)) {
                return true;
            }
        }

        return false;
    }

    /**
     * ロケールを指定して現在の日時を保持した Date のインスタンスを取得します。
     *
     * @param locale 取得する日付のロケール。
     * @return 現在の日時を保持した Date 。
     */
    public static Date now(Locale locale) {
        return Calendar.getInstance(locale).getTime();
    }

    /**
     * 現在の日時を保持した Date のインスタンスを取得します。
     *
     * @return 現在の日時を保持した Date 。
     */
    public static Date now() {
        return now(Locale.getDefault());
    }

    /**
     * 日付が有効か確認します。
     *
     * @param year  年。
     * @param month 月。
     * @param day   日。
     * @return 有効な日付なら true, それ以外なら false 。
     */
    public static boolean validateDate(int year, int month, int day) {
        // GregorianCalendar のインスタンスを取得します。
        Calendar c = new GregorianCalendar(year, (month - 1), day);

        // 日付に変更が生じているか確認します。
        if (c.get(Calendar.YEAR) == year && (c.get(Calendar.MONTH) + 1) == month && day == c.get(Calendar.DATE)) {
            return true;
        }

        return false;
    }

}
