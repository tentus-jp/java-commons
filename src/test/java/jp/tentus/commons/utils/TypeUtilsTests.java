package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class TypeUtilsTests {

    /**
     * Builder の動作を確認します。
     */
    @Test
    public void testBuilder() {
        Object obj = new TypeUtils.Builder<StringBuilder>() {

        }.make();

        Assert.assertEquals(obj.getClass(), StringBuilder.class);
    }

}
