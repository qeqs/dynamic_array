package com.tests;

import com.array.DescDynamicArrayComparator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class DescComparatorTest {
    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{{1,2},{2,1},{Integer.MAX_VALUE,Integer.MIN_VALUE}};
        return Arrays.asList(data);
    }
    @Test
    public void testAscComparator(){
        DescDynamicArrayComparator comparator = new DescDynamicArrayComparator();
        Assert.assertEquals("DescComparatorTest Result",Integer.compare(b,a)>0,comparator.compare(a,b)>0);
    }
}
