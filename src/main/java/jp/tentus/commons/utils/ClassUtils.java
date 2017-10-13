package jp.tentus.commons.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * クラスに対してのコンビニエンスメソッドを提供します。
 */
public class ClassUtils {

    /**
     * 指定されたクラスのスーパークラスが持つ型パラメーターのインスタンスを返します。
     *
     * @param clazz スーパークラスにジェネリクスクラスを持つクラス。
     * @param index 型パラメーターのうち、インスタンスを初期化する型の位置。
     * @param <T>   インスタンスの型。
     * @return 初期化されたインスタンス。
     * @throws InstantiationException デフォルトコンストラクタが無いような場合。
     * @throws IllegalAccessException コンストラクタへのアクセス権が無いような場合。
     */
    @SuppressWarnings("unchecked")
    public static <T> T newInstanceOfTypeArguments(Class<?> clazz, int index) throws InstantiationException, IllegalAccessException {
        Type type = clazz.getGenericSuperclass();

        if (!(type instanceof ParameterizedType)) {
            throw new RuntimeException("Superclass is not a generics class.");
        }

        ParameterizedType pt = (ParameterizedType) type;
        Type[] typeArguments = pt.getActualTypeArguments();

        if ((index < 0) || (typeArguments.length <= index)) {
            throw new IllegalArgumentException("index exceeds range of type parameter.");
        }

        Class<?> argumentClass = (Class<?>) typeArguments[index];

        return (T) argumentClass.newInstance();
    }

}
