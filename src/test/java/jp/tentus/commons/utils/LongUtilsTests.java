package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;

public class LongUtilsTests {

    /**
     * compare の動作を確認します。
     */
    @Test
    public void testCompare() {
        Assert.assertTrue(0 > LongUtils.compare(null, 1L));
        Assert.assertTrue(0 > LongUtils.compare(0L, 1L));
        Assert.assertTrue(0 < LongUtils.compare(1L, null));
        Assert.assertTrue(0 < LongUtils.compare(1L, 0L));
        Assert.assertTrue(0 == LongUtils.compare(null, null));
        Assert.assertTrue(0 == LongUtils.compare(1L, 1L));
    }

    /**
     * equals の動作を確認します。
     */
    @Test
    public void testEquals() {
        Assert.assertFalse(LongUtils.equals(null, 1L));
        Assert.assertFalse(LongUtils.equals(1L, null));
        Assert.assertTrue(LongUtils.equals(null, null));
        Assert.assertTrue(LongUtils.equals(1L, 1L));
    }

    /**
     * from の動作を確認します。
     */
    @Test
    public void testFrom() {
        Assert.assertEquals(LongUtils.parseLong("2", 1L), 2L);
        Assert.assertEquals(LongUtils.parseLong("A", 1L), 1L);
        Assert.assertEquals(LongUtils.parseLong("1"), 1L);
        Assert.assertEquals(LongUtils.nullOrDefault(null, 1L), Long.valueOf(1));
        Assert.assertEquals(LongUtils.nullOrDefault(new BigInteger("1")), Long.valueOf(1));
        Assert.assertEquals(LongUtils.nullOrDefault(new BigInteger("1"), 2L), Long.valueOf(1));
    }

}
