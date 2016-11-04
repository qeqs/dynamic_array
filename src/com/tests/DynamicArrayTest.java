package com.tests;

import com.array.AscDynamicArrayComparator;
import com.array.DynamicArray;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.util.Arrays;
import java.util.Random;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DynamicArrayTest {

    static DynamicArray<Integer> array;
    static Integer[] data;
    static int index = 1;
    static String successStr = "Ok.\n";
    static String resultStr = "Result is ";

    @BeforeClass
    public static void setUp(){
        array = new DynamicArray<Integer>();
        getData(500000);
    }
    static void getData(int length){
        Random random = new Random();
        data = new Integer[length];
        int[] randData = random.ints(length,-10000,10000).toArray();
        for(int i = 0;i<randData.length;i++)
            data[i] = randData[i];
    }

    @Test
    public void test1Add() {

        System.out.println("Starting DynamicArrayTest...");
        System.out.println("Add method test"+index+".\n"+"Parameters:\n"+"data["+data.length+"]");
        System.out.print(resultStr);
        try {

            for (int i = 0; i < data.length; i++)
                array.add(data[i]);

            Assert.assertArrayEquals(data, array.toArray());

        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        catch (Exception e){
            System.out.println("AddMethodError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }

    @Test
    public void test3Insert() {
        Integer expected = new Integer(0);
        System.out.println("Insert method test"+index+".\n"+"Parameters:\n"+"Integer expected = "+ expected);
        System.out.print(resultStr);
        try {
            array.insert(expected, data[0]);
            Assert.assertEquals(data[0], array.get(0));
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        catch (Exception e) {
            System.out.println("InsertMethodError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }


    @Test
    public void test2Delete() {
        Integer expected = array.get(0);
        System.out.println("Add method test" + index + ".\n" + "Parameters:\n" + "Integer expected = " + expected);
        System.out.print(resultStr);
        try {
            array.delete(0);
            Assert.assertNotEquals(expected, array.get(0));
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        catch (Exception e) {
            System.out.println("DeleteMethodError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }


    @Test
    public void test4Sort() {
        Object[] data = array.toArray();
        Arrays.sort(data);

        System.out.println("Add method test" + index + ".\n" + "Parameters:\n" + "Sorted data[" + data.length + "]");
        System.out.print(resultStr);
        try {
            array.sort(0, array.getLength() - 1, new AscDynamicArrayComparator());//231ms
            Assert.assertArrayEquals("Sort", data, array.toArray());
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        catch (Exception e) {
            System.out.println("SortMethodError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }
    @Test
    public void test5ForEach() {
        System.out.println("Iterator test " + index + ".\n" + "Parameters:");

        DynamicArray<String> testingArr = new DynamicArray<String>();
        String expected = "", actual = "";

        for (int i = 0; i < 5; i++) {
            String str = "str" + i + " ";
            expected += str;
            testingArr.add(str);
        }
        for (String str : testingArr) {
            actual += str;
        }
        System.out.println("Expected = "+expected);
        System.out.println("Actual = "+actual);
        System.out.print(resultStr);
        try {

            Assert.assertEquals(expected, actual);
        }
        catch (AssertionError e) {
            System.out.println("AssertionError: " + e.getLocalizedMessage() + ".");
            throw e;
        }
        System.out.println(successStr);
    }

    @AfterClass
    public static void endTest(){
        array.clear();
    }
}
