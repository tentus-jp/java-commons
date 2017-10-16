package jp.tentus.commons.utils;

import java.math.BigInteger;

/**
 * Long 値に関するコンビニエンスメソッドを提供します。
 */
public class LongUtils {

    /**
     * 二つの値を比較します。
     * null はもっとも小さい値として処理します。
     *
     * @param a 比較対象。
     * @param b 比較対象。
     * @return 等しい場合 0、最初の引数が大きい場合正の数、最初の引数が小さい場合負の数。
     */
    public static int compare(Long a, Long b) {
        if (a == b) {
            return 0;
        } else if (a == null) {
            return -1;
        } else if (b == null) {
            return 1;
        }

        return a.compareTo(b);
    }

    /**
     * 二つの値を比較します。
     *
     * @param a 比較対象。
     * @param b 比較対象。
     * @return 等しい場合 true, それ以外は false 。
     */
    public static boolean equals(Long a, Long b) {
        return compare(a, b) == 0;
    }

    /**
     * BigInteger を Long にします。
     *
     * @param value BigInteger の値。
     * @return Long の値。
     */
    public static Long nullOrDefault(BigInteger value) {
        return nullOrDefault(value, null);
    }

    /**
     * BigInteger を Long にします。
     *
     * @param value BigInteger の値。
     * @return Long の値。
     */
    public static Long nullOrDefault(BigInteger value, Long defaultValue) {
        if (value != null) {
            return value.longValue();
        } else {
            return defaultValue;
        }
    }

    /**
     * 文字列から long の値を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue 変換できない場合のデフォルト値。
     * @return 変換された値。
     */
    public static long parseLong(String value, long defaultValue) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 文字列から long の値を得ます。
     *
     * @param value 対象の文字列。
     * @return 変換された値。
     */
    public static long parseLong(String value) {
        return parseLong(value, 0L);
    }

}
