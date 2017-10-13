package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilsTests {

    @Test
    public void testIsBlank() {
        Assert.assertTrue(StringUtils.isBlank(" "));
        Assert.assertTrue(StringUtils.isBlank("　"));
        Assert.assertFalse(StringUtils.isBlank(" A "));
        Assert.assertFalse(StringUtils.isBlank("　A"));
    }

}
