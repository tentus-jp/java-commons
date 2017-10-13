package jp.tentus.commons.utils;

/**
 * 文字列に関するコンビニエンスメソッドを提供します。
 */
public class StringUtils {

    /**
     * 文字列を結合します。
     *
     * @param values 結合する文字列。
     * @return 結合された文字列。
     */
    public static String concat(String... values) {
        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            builder.append(value);
        }

        return builder.toString();
    }

    /**
     * StringBuilder を文字列にします。
     *
     * @param s 文字列にする StringBuilder 。
     * @return 文字列から生成した文字列, StringBuilder が null の場合は null 。
     */
    public static String from(StringBuilder s) {
        return StringUtils.from(s, null);
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
     * 文字列を StringBuilder にします。
     *
     * @param s StringBuilder にする文字列。
     * @return 文字列から生成した StringBuilder, 文字列が null の場合は null 。
     */
    public static StringBuilder from(String s) {
        return StringUtils.from(s, null);
    }

    /**
     * 文字列を StringBuilder にします。
     *
     * @param s            StringBuilder にする文字列。
     * @param defaultValue 文字列が null の場合のデフォルト値。
     * @return 文字列から生成した StringBuilder, 文字列が null の場合は defaultValue 。
     */
    public static StringBuilder from(String s, StringBuilder defaultValue) {
        if (s != null) {
            return new StringBuilder(s);
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

}
