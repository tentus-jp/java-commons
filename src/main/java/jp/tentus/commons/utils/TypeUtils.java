package jp.tentus.commons.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * ジェネリクスの型情報に対するコンビニエンスメソッドを提供します。
 */
public class TypeUtils {

    /**
     * 指定されたクラスのスーパークラスが持つ型パラメーターのオブジェクトを初期化するビルダを返します。
     * <p>
     * <pre>{@code
     *      StringBuilder s = TypeUtils.of(Sample.class).make();
     *
     *      class Base<T> {}
     *      class Sample extends Base<StringBuilder> {}
     * }</pre>
     *
     * @param clazz スーパークラスにジェネリクスクラスを持つクラス。
     * @param <T>   インスタンスの型。
     * @return 初期化されたインスタンス。
     */
    public static <T> Builder<T> of(Class<?> clazz) {
        return new Builder<>(clazz);
    }

    /**
     * パラメータ化された型のオブジェクトを初期化するビルダ。
     * <p>
     * 使用する際は、 Builder を継承した無名クラスを初期化して、そこからオブジェクトを得るか、
     * コンストラクタでパラメータ化された型を持つクラスの Class オブジェクトを指定します。
     * <p>
     * <pre>{@code
     *      StringBuilder s = new TypeUtils.Builder<StringBuilder>() {}.make();
     * }</pre>
     *
     * @param <T> オブジェクトを得る型。
     */
    public static class Builder<T> {

        /**
         * 型パラメーターが設定されたクラス。
         */
        private Class<?> clazz;

        /**
         * 型パラメーターの位置。
         */
        private int index = 0;

        protected Builder() {
            this.clazz = this.getClass();
        }

        public Builder(Class<?> clazz) {
            this.clazz = clazz;
        }

        /**
         * 型パラメーターの位置を設定します。
         *
         * @param index 型パラメーターの位置。
         * @return このオブジェクト。
         */
        public Builder<T> index(int index) {
            this.index = index;

            return this;
        }

        /**
         * 型パラメーターのオブジェクトを初期化します。
         *
         * @return 初期化された型のオブジェクト。
         */
        @SuppressWarnings("unchecked")
        public T make() {
            try {
                Type type = clazz.getGenericSuperclass();

                if (!(type instanceof ParameterizedType)) {
                    throw new RuntimeException("Superclass is not a generics class.");
                }

                ParameterizedType pt = (ParameterizedType) type;
                Type[] typeArguments = pt.getActualTypeArguments();

                if ((this.index < 0) || (typeArguments.length <= this.index)) {
                    throw new IllegalArgumentException("index exceeds range of type parameter.");
                }

                Class<?> argumentClass = (Class<?>) typeArguments[this.index];

                return (T) argumentClass.newInstance();
            } catch (InstantiationException | IllegalAccessException ex) {
                throw new RuntimeException("Could not instantiate.", ex);
            }
        }

    }

}
