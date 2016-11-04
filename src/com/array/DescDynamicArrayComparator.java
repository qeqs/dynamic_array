package com.array;

public class DescDynamicArrayComparator implements DynamicArrayComparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        int result = 0;
        if (a > b) {
            result = -1;
        }
        if (a < b) {
            result = 1;
        }
        return result;
    }
}
