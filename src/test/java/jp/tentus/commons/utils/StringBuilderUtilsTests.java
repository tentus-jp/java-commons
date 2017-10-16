package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringBuilderUtilsTests {

    /**
     * from メソッドの動作を確認します。
     */
    @Test
    public void testFrom() {
        Assert.assertEquals(StringBuilderUtils.from("Hello !!").toString(), "Hello !!");
        Assert.assertEquals(StringBuilderUtils.from(null, new StringBuilder("こんにちは")).toString(), "こんにちは");
    }

    /**
     * join メソッドの動作を確認します。
     */
    @Test
    public void testJoin() {
        StringBuilder sb1 = StringBuilderUtils.join("Hello !!", " ", "World !!");

        Assert.assertEquals(sb1.toString(), "Hello !! World !!");
    }

}
