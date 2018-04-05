package jp.tentus.commons.utils;

import java.io.*;

/**
 * Serializable に関するコンビニエンスメソッドを提供します。
 */
public final class SerializableUtils {

    private SerializableUtils() {

    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     *
     * @param stream      入力ストリーム。
     * @param classLoader 対象のクラスローダー。
     * @param <T>         デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     * @throws IOException 読み込み時に問題が生じた場合。
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T from(InputStream stream, ClassLoader classLoader) throws IOException {
        try {
            try (ObjectInputStream in = new ObjectFromClassLoaderInputStream(stream, classLoader)) {
                return (T) in.readObject();
            }
        } catch (ClassNotFoundException | IOException ex) {
            throw new IOException("Class can not be found using class loader.");
        }
    }

    /**
     * デフォルトのクラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     *
     * @param stream 入力ストリーム。
     * @param <T>    デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     * @throws IOException 読み込み時に問題が生じた場合。
     */
    public static <T extends Serializable> T from(InputStream stream) throws IOException {
        return from(stream, Thread.currentThread().getContextClassLoader());
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     *
     * @param bytes       対象のバイナリ。
     * @param classLoader 対象のクラスローダー。
     * @param <T>         デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     * @throws IOException 読み込み時に問題が生じた場合。
     */
    public static <T extends Serializable> T from(byte[] bytes, ClassLoader classLoader) throws IOException {
        return from(new ByteArrayInputStream(bytes), classLoader);
    }

    /**
     * デフォルトのクラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     *
     * @param bytes 対象のバイナリ。
     * @param <T>   デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     * @throws IOException 読み込み時に問題が生じた場合。
     */
    public static <T extends Serializable> T from(byte[] bytes) throws IOException {
        return from(bytes, Thread.currentThread().getContextClassLoader());
    }

    private static class ObjectFromClassLoaderInputStream extends ObjectInputStream {

        private ClassLoader classLoader;

        ObjectFromClassLoaderInputStream(InputStream in, ClassLoader classLoader) throws IOException {
            super(in);

            this.classLoader = classLoader;
        }

        @Override
        protected Class resolveClass(ObjectStreamClass v) throws IOException, ClassNotFoundException {
            try {
                return Class.forName(v.getName(), false, this.classLoader);
            } catch (ClassNotFoundException ex) {
                return super.resolveClass(v);
            }
        }

    }

}
