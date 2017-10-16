package jp.tentus.commons.utils;

/**
 * 列挙型に対するコンビニエンスメソッドを提供します。
 */
public class EnumUtils {

    /**
     * 列挙型の値を文字列へ変換します。
     *
     * @param enumValue    列挙型の値。
     * @param defaultValue デフォルト値。
     * @return 値が null の場合は defaultValue それ以外は文字列。
     */
    public static String toString(Enum enumValue, String defaultValue) {
        if (enumValue != null) {
            return StringUtils.toLowerCase(enumValue.name());
        } else {
            return defaultValue;
        }
    }

    /**
     * 列挙型の値を文字列へ変換します。
     *
     * @param enumValue 列挙型の値。
     * @return 値が null の場合は null それ以外は文字列。
     */
    public static String toString(Enum enumValue) {
        return toString(enumValue, null);
    }

}
