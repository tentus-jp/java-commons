package jp.tentus.commons.utils;

import java.util.Locale;

/**
 * 文字列に関するコンビニエンスメソッドを提供します。
 */
public class StringUtils {

    /**
     * StringBuilder を文字列にします。
     *
     * @param s 文字列にする StringBuilder 。
     * @return 文字列から生成した文字列, StringBuilder が null の場合は null 。
     */
    public static String from(StringBuilder s) {
        return from(s, null);
    }

    /**
     * StringBuilder を文字列にします。
     *
     * @param s            文字列にする StringBuilder 。
     * @param defaultValue デフォルトの文字列。
     * @return 文字列から生成した文字列, StringBuilder が null の場合は null 。
     */
    public static String from(StringBuilder s, String defaultValue) {
        if (s != null) {
            return s.toString();
        } else {
            return defaultValue;
        }
    }

    /**
     * 文字列がブランクであるかどうか確認します。
     *
     * @param value 対象の文字列。
     * @return ブランクである場合 true, それ以外は false 。
     */
    public static boolean isBlank(CharSequence value) {
        int length;

        if (value == null || 0 == (length = value.length())) {
            return true;
        }

        int startIndex = 0;

        while ((startIndex < length) && Character.isWhitespace(value.charAt(startIndex))) {
            startIndex++;
        }

        while ((startIndex < length) && Character.isWhitespace(value.charAt(length - 1))) {
            length--;
        }

        return startIndex == length;
    }

    /**
     * 文字列が空 (null または長さ 0 の文字列) かどうかを確認します。
     *
     * @param value 対象の文字列。
     * @return 文字列が空である場合 true, それ以外は false 。
     */
    public static boolean isEmpty(CharSequence value) {
        return value == null || value.length() == 0;
    }

    /**
     * 文字列がブランクであるかどうか確認します。
     *
     * @param value 対象の文字列。
     * @return ブランクではない場合 true, それ以外は false 。
     */
    public static boolean isNotBlank(CharSequence value) {
        return !isBlank(value);
    }

    /**
     * 文字列が空 (null または長さ 0 の文字列) かどうかを確認します。
     *
     * @param value 対象の文字列。
     * @return 文字列が空ではない場合 true, それ以外は false 。
     */
    public static boolean isNotEmpty(CharSequence value) {
        return !isEmpty(value);
    }

    /**
     * 小文字にした文字列を得ます。
     *
     * @param value 対象の文字列。
     * @return 小文字にした文字列。
     */
    public static String toLowerCase(String value) {
        return toLowerCase(value, null, Locale.US);
    }

    /**
     * 小文字にした文字列を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue value が null などの場合に返される文字列。
     * @return 小文字にした文字列。
     */
    public static String toLowerCase(String value, String defaultValue) {
        return toLowerCase(value, defaultValue, Locale.US);
    }

    /**
     * 小文字にした文字列を得ます。
     *
     * @param value  対象の文字列。
     * @param locale 対象のロケール。
     * @return 小文字にした文字列。
     */
    public static String toLowerCase(String value, Locale locale) {
        return toLowerCase(value, null, locale);
    }

    /**
     * 小文字にした文字列を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue value が null などの場合に返される文字列。
     * @param locale       対象のロケール。
     * @return 小文字にした文字列。
     */
    public static String toLowerCase(String value, String defaultValue, Locale locale) {
        if (value != null) {
            return value.toLowerCase(locale);
        } else {
            return defaultValue;
        }
    }

    /**
     * 大文字にした文字列を得ます。
     *
     * @param value 対象の文字列。
     * @return 大文字にした文字列。
     */
    public static String toUpperCase(String value) {
        return toUpperCase(value, null, Locale.US);
    }

    /**
     * 大文字にした文字列を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue value が null などの場合に返される文字列。
     * @return 大文字にした文字列。
     */
    public static String toUpperCase(String value, String defaultValue) {
        return toUpperCase(value, defaultValue, Locale.US);
    }

    /**
     * 大文字にした文字列を得ます。
     *
     * @param value  対象の文字列。
     * @param locale 対象のロケール。
     * @return 大文字にした文字列。
     */
    public static String toUpperCase(String value, Locale locale) {
        return toUpperCase(value, null, locale);
    }

    /**
     * 大文字にした文字列を得ます。
     *
     * @param value        対象の文字列。
     * @param defaultValue value が null などの場合に返される文字列。
     * @param locale       対象のロケール。
     * @return 大文字にした文字列。
     */
    public static String toUpperCase(String value, String defaultValue, Locale locale) {
        if (value != null) {
            return value.toUpperCase(locale);
        } else {
            return defaultValue;
        }
    }

}
