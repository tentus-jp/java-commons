package jp.tentus.commons.utils;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

/**
 * LocalDateTime に関するコンビニエンスメソッドを提供します。
 */
public class LocalDateTimeUtils {

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

}
