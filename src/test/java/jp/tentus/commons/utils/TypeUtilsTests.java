package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class TypeUtilsTests {

    /**
     * Builder を無形クラスから使用した際の動作を確認します。
     */
    @Test
    public void testBuilderExtend() {
        Object obj = new TypeUtils.Builder<StringBuilder>() {

        }.make();

        Assert.assertEquals(obj.getClass(), StringBuilder.class);
    }

    /**
     * Builder を of メソッドから使用した際の動作を確認します。
     */
    @Test
    public void testBuilderOf() {
        Object t1 = TypeUtils.of(Sample1.class).make();
        Object t2 = TypeUtils.of(Sample1.class).index(1).make();

        Assert.assertEquals(t1.getClass(), String.class);
        Assert.assertEquals(t2.getClass(), StringBuilder.class);

        Sample2 sample2 = new Sample2();

        Assert.assertEquals(sample2.value.getClass(), StringBuilder.class);
    }

    static class Base1<T1, T2> {

    }

    static class Base2<T> {

        public T value = TypeUtils.<T>of(this.getClass()).make();

    }

    static class Sample1 extends Base1<String, StringBuilder> {

    }

    static class Sample2 extends Base2<StringBuilder> {

    }

}
