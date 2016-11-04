package com.array;

public class AscDynamicArrayComparator implements DynamicArrayComparator<Integer> {
    @Override
    public int compare(java.lang.Integer a, java.lang.Integer b) {
        return a - b;
    }
}
