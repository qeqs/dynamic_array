package com.array;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements Iterable<T>{

    private T[] data;
    private int length, last;
    private final int minLength = 10;

    public DynamicArray() {
        last = -1;
        length = minLength;
        data = (T[])new Object[length];
    }

    public int getLength() {
        return last+1;
    }
    public T get(int index){
        if(index<0||index>=getLength())
            throw new IndexOutOfBoundsException("wrong index");

        return data[index];
    }
    public void set(int index, T value){
        if(index<0||index>=getLength())
            throw new IndexOutOfBoundsException("wrong index");

        data[index] = value;
    }
    private void resize() {
        T[] temp = Arrays.copyOfRange(data, 0, getLength());
        length = (length * 3) / 2 + 1;
        data = (T[])new Object[length];
        for (int i = 0; i < temp.length; i++)
            data[i] = temp[i];
    }
    private void trim() {
        if (last > -1)
            data = Arrays.copyOfRange(data, 0, getLength());
    }
    public void add(T value){
        if(last==length-1){
            resize();
        }
        last++;
        data[last] = value;
    }
    public void insert(int index, T value){
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

        if(Math.round(length/last) >= 2){
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
                T temp = data[marker]; // swap
                data[marker] = data[i];
                data[i] = temp;
                marker ++;
            }
        }
        return marker - 1;
    }

    public T[] toArray(){
        return (T[])Arrays.copyOfRange(data,0,getLength());
    }
    public void clear(){
        data = (T[])new Object[minLength];
    }



    //region Iterator realization
    @Override
    public Iterator<T> iterator() {
        return new DynamicArrayIterator(this);
    }

    private class DynamicArrayIterator implements Iterator<T>{

        private DynamicArray<T> data;
        private int index;

        public DynamicArrayIterator(DynamicArray<T> data){
            index = 0;
            this.data = data;
        }
        @Override
        public boolean hasNext() {
            return data.getLength()!=index;
        }

        @Override
        public T next() {
            if(hasNext()) {
                return data.get(index++);
            } else {
                throw new NoSuchElementException("There are no elements size = " + data.getLength());
            }
        }
    }
    //endregion
}
