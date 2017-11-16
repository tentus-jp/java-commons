package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTests {

    /**
     * from メソッドの動作を確認します。
     */
    @Test
    public void testFrom() {
        StringBuilder sb1 = new StringBuilder("Hello !!");
        StringBuilder sb2 = new StringBuilder("こんにちは");

        Assert.assertEquals(StringUtils.from(sb1), "Hello !!");
        Assert.assertEquals(StringUtils.from(sb2), "こんにちは");
    }

    /**
     * isBlank, isNotBlank メソッドの動作を確認します。
     */
    @Test
    public void testIsBlank() {
        Assert.assertTrue(StringUtils.isBlank(" "));
        Assert.assertTrue(StringUtils.isBlank("　"));
        Assert.assertFalse(StringUtils.isBlank(" A "));
        Assert.assertFalse(StringUtils.isBlank("　A"));

        Assert.assertFalse(StringUtils.isNotBlank(" "));
        Assert.assertFalse(StringUtils.isNotBlank("　"));
        Assert.assertTrue(StringUtils.isNotBlank(" A "));
        Assert.assertTrue(StringUtils.isNotBlank("　A"));
    }

    /**
     * isEmpty, isNotEmpty メソッドの動作を確認します。
     */
    @Test
    public void testIsEmpty() {
        Assert.assertTrue(StringUtils.isEmpty(null));
        Assert.assertTrue(StringUtils.isEmpty(""));
        Assert.assertFalse(StringUtils.isEmpty("A"));
        Assert.assertFalse(StringUtils.isEmpty(" "));

        Assert.assertFalse(StringUtils.isNotEmpty(null));
        Assert.assertFalse(StringUtils.isNotEmpty(""));
        Assert.assertTrue(StringUtils.isNotEmpty("A"));
        Assert.assertTrue(StringUtils.isNotEmpty(" "));
    }

    /**
     * toLowerCase, toUpperCase メソッドの動作を確認します。
     */
    @Test
    public void testToLowerCaseAndToUpperCase() {
        Assert.assertEquals(StringUtils.toLowerCase("A"), "a");
        Assert.assertEquals(StringUtils.toLowerCase(null, "a"), "a");

        Assert.assertEquals(StringUtils.toUpperCase("a"), "A");
        Assert.assertEquals(StringUtils.toUpperCase(null, "A"), "A");
    }

}
