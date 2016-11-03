package com.tests;

import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;

public class TestsSuite {
    public static Test suite()
    {
        TestSuite suite = new TestSuite();

        suite.addTest(new JUnit4TestAdapter(DynamicArrayTest.class));
        suite.addTest(new JUnit4TestAdapter(AscComparatorTest.class));
        suite.addTest(new JUnit4TestAdapter(DescComparatorTest.class));

        return suite;
    }

}
