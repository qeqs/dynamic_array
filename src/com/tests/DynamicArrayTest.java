package com.tests;

import com.array.DescDynamicArrayComparator;
import com.array.DynamicArray;
import com.array.AscDynamicArrayComparator;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicArrayTest {

    static DynamicArray array;
    static int[] data;
    @BeforeClass
    public static void setUp(){
        array = new DynamicArray();
        data = getData(500000);
    }
    static int[] getData(int length){
        Random random = new Random();
        return random.ints(length,-10000,10000).toArray();
    }

    @Test
    public void test1Add() {

        for (int i = 0; i < data.length; i++)
            array.add(data[i]);
    }

    @Test
    public void test3Insert() {
        array.insert(0, data[0]);
    }

    @Test
    public void test4Delete() {
        array.delete(0);
    }

    @Test
    public void test2Sort() {
        data = array.toArray();
        Arrays.sort(data);
        array.sort(0,array.getLength()-1,new AscDynamicArrayComparator());//231ms
        Assert.assertArrayEquals("Sort", data,array.toArray());
    }

    @AfterClass
    public static void endTest(){
        array.clear();
    }
}
