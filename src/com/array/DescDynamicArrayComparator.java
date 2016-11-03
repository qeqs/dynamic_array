package com.array;

public class DescDynamicArrayComparator implements DynamicArrayComparator{
    @Override
    public int compare(int a, int b) {
        int result = 0;
        if(a>b){
            result=-1;
        }
        if(a<b){
            result=1;
        }
        return result;
    }
}
