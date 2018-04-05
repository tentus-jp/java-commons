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
     * <p>
     * エラーが発生した場合、null を返します。
     *
     * @param stream 入力ストリーム。
     * @param <T>    デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrNull(InputStream stream) {
        return fromOrElse(stream, null);
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、null を返します。
     *
     * @param stream      入力ストリーム。
     * @param classLoader 対象のクラスローダー。
     * @param <T>         デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrNull(InputStream stream, ClassLoader classLoader) {
        return fromOrElse(stream, classLoader, null);
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、null を返します。
     *
     * @param bytes 対象のバイナリ。
     * @param <T>   デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrNull(byte[] bytes) {
        return fromOrElse(bytes, null);
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、null を返します。
     *
     * @param bytes       対象のバイナリ。
     * @param classLoader 対象のクラスローダー。
     * @param <T>         デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrNull(byte[] bytes, ClassLoader classLoader) {
        return fromOrElse(bytes, classLoader, null);
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、defaultValue で指定した内容を返します。
     *
     * @param stream       入力ストリーム。
     * @param defaultValue デフォルト値。
     * @param <T>          デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrElse(InputStream stream, T defaultValue) {
        try {
            return from(stream);
        } catch (IOException ex) {
            return defaultValue;
        }
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、defaultValue で指定した内容を返します。
     *
     * @param stream       入力ストリーム。
     * @param classLoader  対象のクラスローダー。
     * @param defaultValue デフォルト値。
     * @param <T>          デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrElse(InputStream stream, ClassLoader classLoader, T defaultValue) {
        try {
            return from(stream, classLoader);
        } catch (IOException ex) {
            return defaultValue;
        }
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、defaultValue で指定した内容を返します。
     *
     * @param bytes        対象のバイナリ。
     * @param defaultValue デフォルト値。
     * @param <T>          デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrElse(byte[] bytes, T defaultValue) {
        try {
            return from(bytes);
        } catch (IOException ex) {
            return defaultValue;
        }
    }

    /**
     * クラスローダーを指定して、Serializable オブイジェクトをデシリアライズします。
     * <p>
     * エラーが発生した場合、defaultValue で指定した内容を返します。
     *
     * @param bytes        対象のバイナリ。
     * @param classLoader  対象のクラスローダー。
     * @param defaultValue デフォルト値。
     * @param <T>          デシリアライズするオブジェクトの型。
     * @return デシリアライズされたオブジェクト。
     */
    public static <T extends Serializable> T fromOrElse(byte[] bytes, ClassLoader classLoader, T defaultValue) {
        try {
            return from(bytes, classLoader);
        } catch (IOException ex) {
            return defaultValue;
        }
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
