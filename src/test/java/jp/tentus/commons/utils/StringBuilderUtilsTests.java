package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringBuilderUtilsTests {

    /**
     * from メソッドの動作を確認します。
     */
    @Test
    public void testFrom() {
        StringBuilder sb1 = new StringBuilder("Hello !!");
        StringBuilder sb2 = null;

        Assert.assertEquals(StringBuilderUtils.from(sb1), "Hello !!");
        Assert.assertEquals(StringBuilderUtils.from(sb2, "こんにちは"), "こんにちは");

        StringBuilder sb3 = new StringBuilder("Hello !!");
        StringBuilder sb4 = new StringBuilder("こんにちは");

        Assert.assertEquals(StringBuilderUtils.from(sb3), "Hello !!");
        Assert.assertEquals(StringBuilderUtils.from(sb4), "こんにちは");
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
