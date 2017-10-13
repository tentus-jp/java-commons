package jp.tentus.commons.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日時に関するコンビニエンスメソッドを提供します。
 */
public class DateUtils {

    /**
     * LocalDate から ZonedDateTime を得ます。
     *
     * @param value ZonedDateTime に変換する LocalDate 。
     * @return 変換された ZonedDateTime 。
     */
    public static ZonedDateTime from(LocalDate value) {
        return from(value, null);
    }

    /**
     * LocalDate から ZonedDateTime を得ます。
     *
     * @param value        ZonedDateTime に変換する LocalDate 。
     * @param defaultValue value が null だった場合などに返される ZonedDateTime 。
     * @return 変換された ZonedDateTime 。
     */
    public static ZonedDateTime from(LocalDate value, ZonedDateTime defaultValue) {
        if (value != null) {
            return ZonedDateTime.from(value.atStartOfDay(ZoneId.systemDefault()));
        } else {
            return defaultValue;
        }
    }

    /**
     * LocalDateTime から ZonedDateTime を得ます。
     *
     * @param value ZonedDateTime に変換する LocalDateTime 。
     * @return 変換された ZonedDateTime 。
     */
    public static ZonedDateTime from(LocalDateTime value) {
        return from(value, null);
    }

    /**
     * LocalDateTime から ZonedDateTime を得ます。
     *
     * @param value        ZonedDateTime に変換する LocalDateTime 。
     * @param defaultValue value が null だった場合などに返される ZonedDateTime 。
     * @return 変換された ZonedDateTime 。
     */
    public static ZonedDateTime from(LocalDateTime value, ZonedDateTime defaultValue) {
        return from(value, ZoneId.systemDefault(), defaultValue);
    }

    /**
     * LocalDateTime から ZonedDateTime を得ます。
     *
     * @param value        ZonedDateTime に変換する LocalDateTime 。
     * @param zoneId       変換に用いるタイムゾーンを表す ZoneId 。
     * @param defaultValue value が null だった場合などに返される ZonedDateTime 。
     * @return 変換された ZonedDateTime 。
     */
    public static ZonedDateTime from(LocalDateTime value, ZoneId zoneId, ZonedDateTime defaultValue) {
        if (value != null) {
            return ZonedDateTime.of(value, zoneId);
        } else {
            return defaultValue;
        }
    }

    /**
     * ZonedDateTime から LocalDateTime を得ます。
     *
     * @param value LocalDateTime に変換する LocalDateTime 。
     * @return 変換された LocalDateTime 。
     */
    public static LocalDateTime from(ZonedDateTime value) {
        return from(value, null);
    }

    /**
     * ZonedDateTime から LocalDateTime を得ます。
     *
     * @param value        LocalDateTime に変換する ZonedDateTime 。
     * @param defaultValue value が null だった場合などに返される LocalDateTime 。
     * @return 変換された LocalDateTime 。
     */
    public static LocalDateTime from(ZonedDateTime value, LocalDateTime defaultValue) {
        if (value != null) {
            return value.toLocalDateTime();
        } else {
            return defaultValue;
        }
    }

    /**
     * 3000/12/31 23:59:59 を表す ZonedDateTime を取得します。
     * 厳密な最大値ではありませんが、現実的に番兵的に利用できる値を表します。
     *
     * @param zoneId 対象のタイムゾーンを表す ZoneId 。
     * @return 対象の日時を表す ZonedDateTime 。
     */
    public static ZonedDateTime getMaxDateTime(ZoneId zoneId) {
        return ZonedDateTime.of(3000, 12, 31, 23, 59, 59, 0, zoneId);
    }

    /**
     * 3000/12/31 23:59:59 を表す ZonedDateTime を取得します。
     * 厳密な最大値ではありませんが、現実的に番兵的に利用できる値を表します。
     *
     * @return 対象の日時を表す ZonedDateTime 。
     */
    public static ZonedDateTime getMaxDateTime() {
        return getMaxDateTime(ZoneId.systemDefault());
    }

    /**
     * 1900/01/01 00:00:00 を表す ZonedDateTime を取得します。
     * 厳密な最小値ではありませんが、現実的に番兵的に利用できる値を表します。
     *
     * @param zoneId 対象のタイムゾーンを表す ZoneId 。
     * @return 対象の日時を表す ZonedDateTime 。
     */
    public static ZonedDateTime getMinDateTime(ZoneId zoneId) {
        return ZonedDateTime.of(1900, 1, 1, 0, 0, 0, 0, zoneId);
    }

    /**
     * 1900/01/01 00:00:00 を表す ZonedDateTime を取得します。
     * 厳密な最小値ではありませんが、現実的に番兵的に利用できる値を表します。
     *
     * @return 対象の日時を表す ZonedDateTime 。
     */
    public static ZonedDateTime getMinDateTime() {
        return getMinDateTime(ZoneId.systemDefault());
    }

    /**
     * 現在の日時を保持した Date のインスタンスを取得します。
     *
     * @return 現在の日時を保持した Date 。
     */
    public static Date getNowDate() {
        return getNowDate(Locale.getDefault());
    }

    /**
     * ロケールを指定して現在の日時を保持した Date のインスタンスを取得します。
     *
     * @param locale 取得する日付のロケール。
     * @return 現在の日時を保持した Date 。
     */
    public static Date getNowDate(Locale locale) {
        return Calendar.getInstance(locale).getTime();
    }

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
     * 指定した値か getMaxDateTime の値を ZonedDateTime で取得します。
     *
     * @param value 対象の LocalDateTime 。
     * @return value を表す ZonedDateTime か、getMaxDateTime() を表す ZonedDateTime 。
     */
    public static ZonedDateTime orEndDateTime(LocalDateTime value) {
        return from(value, getMaxDateTime());
    }

    /**
     * 指定した値か getMaxDateTime の値を ZonedDateTime で取得します。
     *
     * @param value 対象の LocalDate 。
     * @return value を表す ZonedDateTime か、getMaxDateTime() を表す ZonedDateTime 。
     */
    public static ZonedDateTime orEndDay(LocalDate value) {
        return from(value, getMaxDateTime());
    }

    /**
     * 指定した値か getMinDateTime の値を ZonedDateTime で取得します。
     *
     * @param value 対象の LocalDateTime 。
     * @return value を表す ZonedDateTime か、getMinDateTime() を表す ZonedDateTime 。
     */
    public static ZonedDateTime orStartDateTime(LocalDateTime value) {
        return from(value, getMinDateTime());
    }

    /**
     * 指定した値か getMinDateTime の値を ZonedDateTime で取得します。
     *
     * @param value 対象の LocalDate 。
     * @return value を表す ZonedDateTime か、getMinDateTime() を表す ZonedDateTime 。
     */
    public static ZonedDateTime orStartDay(LocalDate value) {
        return from(value, getMinDateTime());
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
