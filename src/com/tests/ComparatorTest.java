package com.tests;

import com.array.AscDynamicArrayComparator;
import com.array.DescDynamicArrayComparator;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ComparatorTest
{
    @Parameterized.Parameter
    public int a;
    @Parameterized.Parameter(1)
    public int b;
    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] data = new Object[][]{{1,2},{2,1},
                {Integer.MAX_VALUE,Integer.MIN_VALUE}};//с этими значениями происходит переполнение в таком компараторе
        return Arrays.asList(data);
    }

    public static int  index = 1;
    static String successStr = "Ok.\n";
    static String resultStr = "Result is ";

    @BeforeClass
    public static void beforeStart(){
        System.out.println("Starting ComparatorTest...\n");
    }
    @Test
    public void test1AscComparator() {
        System.out.println("AscComparator test" + index + ".\n" + "Parameters:\n" + "a = " + a + "\nb = " + b);
        AscDynamicArrayComparator comparator = new AscDynamicArrayComparator();
        System.out.print(resultStr);
        try {
            Assert.assertEquals(Integer.compare(a, b) > 0, comparator.compare(a, b) > 0);
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }
    @Test
    public void test2DescComparator() {
        System.out.println("DescComparator test" + index++ + ".\n" + "Parameters:\n" + "a = " + a + "\nb = " + b);
        DescDynamicArrayComparator comparator = new DescDynamicArrayComparator();
        System.out.print(resultStr);
        try {
            Assert.assertEquals("DescComparatorTest Result", Integer.compare(b, a) > 0, comparator.compare(a, b) > 0);
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }
}
