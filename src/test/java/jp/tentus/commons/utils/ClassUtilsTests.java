package jp.tentus.commons.utils;

import org.junit.Assert;
import org.junit.Test;

public class ClassUtilsTests {

    @Test
    public void testNewTypeArguments() throws InstantiationException, IllegalAccessException {
        Object t1 = ClassUtils.newInstanceOfTypeArguments(BaseString.class, 0);
        Object t2 = ClassUtils.newInstanceOfTypeArguments(BaseString.class, 1);

        Assert.assertEquals(t1.getClass(), String.class);
        Assert.assertEquals(t2.getClass(), Object.class);
    }

    static class Base<T, O> {

    }

    static class BaseString extends Base<String, Object> {

    }

}
