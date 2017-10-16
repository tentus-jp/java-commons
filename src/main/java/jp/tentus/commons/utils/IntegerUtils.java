package jp.tentus.commons.utils;

import java.math.BigInteger;

/**
 * Integer 値に関するコンビニエンスメソッドを提供します。
 */
public class IntegerUtils {

    /**
     * 二つの値を比較します。
     * null はもっとも小さい値として処理します。
     *
     * @param a 比較対象。
     * @param b 比較対象。
     * @return 等しい場合 0、最初の引数が大きい場合正の数、最初の引数が小さい場合負の数。
     */
    public static int compare(Integer a, Integer b) {
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
    public static boolean equals(Integer a, Integer b) {
        return compare(a, b) == 0;
    }

    /**
     * BigInteger を Integer にします。
     *
     * @param value BigInteger の値。
     * @return Integer の値。
     */
    public static Integer nullOrDefault(BigInteger value) {
        return nullOrDefault(value, null);
    }

    /**
     * BigInteger を Integer にします。
     *
     * @param value        BigInteger の値。
     * @param defaultValue value が null の場合のデフォルト値。
     * @return Integer の値。
     */
    public static Integer nullOrDefault(BigInteger value, Integer defaultValue) {
        if (value != null) {
            return value.intValue();
        } else {
            return defaultValue;
        }
    }

    /**
     * 文字列から int の値を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue 変換できない場合のデフォルト値。
     * @return 変換された値。
     */
    public static int parseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }

    /**
     * 文字列から integer の値を得ます。
     *
     * @param value 対象の文字列。
     * @return 変換された値。
     */
    public static int parseInt(String value) {
        return parseInt(value, 0);
    }

}
