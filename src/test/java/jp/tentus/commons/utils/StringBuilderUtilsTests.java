package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

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

    /**
     * splitNewArrayList メソッドの動作を確認します。
     */
    @Test
    public void testSplitNewArrayList() {
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA|BBBBB|CCCCC|DDDDD"), '|').toArray(new String[0]),
                new String[]{"AAAAA", "BBBBB", "CCCCC", "DDDDD"}
        );
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA|BBBBB|CCCCC|DDDDD|"), '|').toArray(new String[0]),
                new String[]{"AAAAA", "BBBBB", "CCCCC", "DDDDD", ""}
        );
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA|BBBBB|CCCCC|DDDDD|EEE"), '|').toArray(new String[0]),
                new String[]{"AAAAA", "BBBBB", "CCCCC", "DDDDD", "EEE"}
        );
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA"), '|').toArray(new String[0]),
                new String[]{"AAAAA"}
        );

        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA|BBBBB|CCCCC|DDDDD"), "|").toArray(new String[0]),
                new String[]{"AAAAA", "BBBBB", "CCCCC", "DDDDD"}
        );
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA||BBBBB||CCCCC||DDDDD"), "||").toArray(new String[0]),
                new String[]{"AAAAA", "BBBBB", "CCCCC", "DDDDD"}
        );
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA||BBBBB||CCCCC||DDDDD||"), "||").toArray(new String[0]),
                new String[]{"AAAAA", "BBBBB", "CCCCC", "DDDDD", ""}
        );
        Assert.assertArrayEquals(
                StringBuilderUtils.splitNewArrayList(new StringBuilder("AAAAA"), "||").toArray(new String[0]),
                new String[]{"AAAAA"}
        );
    }

}
