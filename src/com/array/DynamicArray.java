package com.array;

import java.util.Arrays;

public class DynamicArray {

    private int[] data;
    private int length, last;
    private final int minLength = 10;

    public DynamicArray() {
        last = -1;
        length = minLength;
        data = new int[length];
    }

    public int getLength() {
        return last+1;
    }
    public int get(int index){
        if(index<0||index>=getLength())
            throw new IndexOutOfBoundsException("wrong index");

        return data[index];
    }
    public void set(int index, int value){
        if(index<0||index>=getLength())
            throw new IndexOutOfBoundsException("wrong index");

        data[index] = value;
    }
    private void resize() {
        int[] temp = Arrays.copyOfRange(data, 0, last);
        length = (length * 3) / 2 + 1;
        data = new int[length];
        for (int i = 0; i < temp.length; i++)
            data[i] = temp[i];
    }
    private void trim() {
        if (last > -1)
            data = Arrays.copyOfRange(data, 0, last);
    }
    public void add(int value){
        if(last==length-1){
            resize();
        }
        last++;
        data[last] = value;
    }
    public void insert(int index, int value){
        if(index<0||index>=getLength())
            throw new IndexOutOfBoundsException("wrong index");

        if(last == length-1){
            resize();
        }

        for(int i = last;i>=index;i--){
            data[i+1] = data[i];
        }
        last++;
        data[index] = value;
    }
    public void delete(int index){
        if(index<0||index>=getLength())
            throw new IndexOutOfBoundsException("wrong index");

        for(int i = index;i<last;i++){
            data[i] = data[i+1];
        }
        last--;

        if(Math.round(length/last) == 2){
            trim();
        }
    }
    public void sort(int start,int end,DynamicArrayComparator comparator) {
        if (start >= end) {
            return;
        }

        int center = partition(start, end, comparator);
        sort(start, center - 1, comparator);
        sort(center + 1, end, comparator);
    }
    private int partition( int start, int end,DynamicArrayComparator comparator)
    {
        int marker = start;
        for (int i = start; i <= end; i++)
        {
            if (comparator.compare(data[i],data[end])<=0)
            {
                int temp = data[marker]; // swap
                data[marker] = data[i];
                data[i] = temp;
                marker ++;
            }
        }
        return marker - 1;
    }

    public int[] toArray(){
        return Arrays.copyOfRange(data,0,getLength());
    }
    public void clear(){
        data = new int[minLength];
    }
}
