package jp.tentus.commons.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * StringBuilder に対するコンビニエンスメソッドを提供します。
 */
public final class StringBuilderUtils {

    private StringBuilderUtils() {

    }

    /**
     * StringBuilder を指定した文字で分割したリストを新しく生成します。
     *
     * @param s         対象の StringBuilder 。
     * @param separator セパレーター文字。
     * @return セパレーター文字で分割された文字列を保持するリスト。
     */
    public static List<String> splitNewArrayList(StringBuilder s, char separator) {
        List<String> list = new ArrayList<>();

        int fromIndex = 0;
        int len = s.length();
        int currentIndex;

        for (currentIndex = 0; currentIndex < len; currentIndex++) {
            char c = s.charAt(currentIndex);

            if (c == separator) {
                list.add(s.substring(fromIndex, currentIndex));
                fromIndex = currentIndex + 1;
            }
        }

        if (fromIndex <= currentIndex) {
            list.add(s.substring(fromIndex, currentIndex));
        }

        return list;
    }

    /**
     * StringBuilder を指定した文字で分割したリストを新しく生成します。
     *
     * @param s         対象の StringBuilder 。
     * @param separator セパレーター文字。
     * @return セパレーター文字で分割された文字列を保持するリスト。
     */
    public static List<String> splitNewArrayList(StringBuilder s, String separator) {
        List<String> list = new ArrayList<>();

        int comp = separator.length();
        int len = s.length();
        int limit = len - comp;
        int index = 0;
        int from = 0;

        while (index <= limit) {
            int i;

            for (i = 0; i < comp; i++) {
                if (s.charAt(index + i) != separator.charAt(i)) {
                    break;
                }
            }

            if (i == comp) {
                list.add(s.substring(from, index));
                from = index + comp;
                index += comp;
            } else {
                index++;
            }
        }

        if (from <= index) {
            list.add(s.substring(from, len));
        }

        return list;
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
