package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class IntegerUtilsTests {

    /**
     * compare の動作を確認します。
     */
    @Test
    public void testCompare() {
        Assert.assertTrue(0 > IntegerUtils.compare(null, 1));
        Assert.assertTrue(0 > IntegerUtils.compare(0, 1));
        Assert.assertTrue(0 < IntegerUtils.compare(1, null));
        Assert.assertTrue(0 < IntegerUtils.compare(1, 0));
        Assert.assertTrue(0 == IntegerUtils.compare(null, null));
        Assert.assertTrue(0 == IntegerUtils.compare(1, 1));
    }

    /**
     * equals の動作を確認します。
     */
    @Test
    public void testEquals() {
        Assert.assertFalse(IntegerUtils.equals(null, 1));
        Assert.assertFalse(IntegerUtils.equals(1, null));
        Assert.assertTrue(IntegerUtils.equals(null, null));
        Assert.assertTrue(IntegerUtils.equals(1, 1));
    }

    /**
     * from の動作を確認します。
     */
    @Test
    public void testFrom() {
        Assert.assertEquals(IntegerUtils.parseInt("2", 1), 2);
        Assert.assertEquals(IntegerUtils.parseInt("A", 1), 1);
        Assert.assertEquals(IntegerUtils.parseInt("1"), 1);
        Assert.assertEquals(IntegerUtils.nullOrDefault(null, 1), Integer.valueOf(1));
        Assert.assertEquals(IntegerUtils.nullOrDefault(new BigInteger("1")), Integer.valueOf(1));
        Assert.assertEquals(IntegerUtils.nullOrDefault(new BigInteger("1"), 2), Integer.valueOf(1));
    }

}
