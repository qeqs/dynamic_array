package com.array;

import java.util.Comparator;

public interface DynamicArrayComparator<T> extends Comparator<T> {
    int compare(T a,T b);
}