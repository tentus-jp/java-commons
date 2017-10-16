package jp.tentus.commons.utils;

/**
 * 文字列に関するコンビニエンスメソッドを提供します。
 */
public class StringUtils {

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
