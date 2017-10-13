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

}
