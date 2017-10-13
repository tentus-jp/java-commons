package jp.tentus.commons.utils;

import java.math.BigInteger;

/**
 * 数値に関するコンビニエンスメソッドを提供します。
 */
public class NumberUtils {

    /**
     * Long 同士の値を比較します。
     *
     * @param a 比較対象。
     * @param b 比較対象。
     * @return 等しい場合 0、左辺が大きい場合 1、右辺が大きい場合 1 。
     */
    public static int compareTo(Long a, Long b) {
        if (a == b) {
            return 0;
        } else if (a == null) {
            return 1;
        } else if (b == null) {
            return -1;
        }

        return a.compareTo(b);
    }

    /**
     * Long 同士の値を比較します。
     *
     * @param a 比較対象。
     * @param b 比較対象。
     * @return 等しい場合 true, それ以外は false 。
     */
    public static boolean equals(Long a, Long b) {
        return compareTo(a, b) == 0;
    }

    /**
     * 文字列から int の値を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue 変換できない場合のデフォルト値。
     * @return 変換された値。
     */
    public static int from(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
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
    public static long from(String value, long defaultValue) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * BigInteger を Long にします。
     *
     * @param value BigInteger の値。
     * @return Long の値。
     */
    public static Long parse(BigInteger value) {
        if (value != null) {
            return value.longValue();
        } else {
            return null;
        }
    }

}
