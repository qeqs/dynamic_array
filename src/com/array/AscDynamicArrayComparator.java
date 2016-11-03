package com.array;

public class AscDynamicArrayComparator implements DynamicArrayComparator {
    @Override
    public int compare(int a, int b) {
            return a - b;
    }
}
