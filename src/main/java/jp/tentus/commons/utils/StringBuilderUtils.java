package jp.tentus.commons.utils;

/**
 * StringBuilder に対するコンビニエンスメソッドを提供します。
 */
public final class StringBuilderUtils {

    private StringBuilderUtils() {

    }

    /**
     * 文字列を StringBuilder にします。
     *
     * @param s StringBuilder にする文字列。
     * @return 文字列から生成した StringBuilder, 文字列が null の場合は null 。
     */
    public static StringBuilder from(String s) {
        return from(s, null);
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
     * 文字列を結合します。
     *
     * @param values 結合する文字列。
     * @return 結合された文字列。
     */
    public static StringBuilder join(String... values) {
        StringBuilder builder = new StringBuilder();

        for (String value : values) {
            builder.append(value);
        }

        return builder;
    }

}
