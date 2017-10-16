package jp.tentus.commons.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ジェネリクスの型情報に対するコンビニエンスメソッドを提供します。
 */
public class TypeUtils {

    /**
     * ジェネリクスの型パラメーターのオブジェクトを生成します。
     * 呼び出し時には、Builder を継承した無名クラスを初期化して、そこからオブジェクトを得ます。
     * <p>
     * <pre>{@code
     *      StringBuilder s = new TypeUtils.Builder<StringBuilder>() {}.make();
     * }</pre>
     *
     * @param <T> オブジェクトを得る型。
     */
    public abstract static class Builder<T> {

        @SuppressWarnings("unchecked")
        T make() {
            try {
                Type type = this.getClass().getGenericSuperclass();
                ParameterizedType pt = (ParameterizedType) type;
                Type[] typeArguments = pt.getActualTypeArguments();
                Class<?> argumentClass = (Class<?>) typeArguments[0];

                return (T) argumentClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new RuntimeException("Could not instantiate.", ex);
            }
        }

    }

}
