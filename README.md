# dynamic_array
UML Class diagram:

@startuml
interface DynemicArrayComparator{
    int compare(int a,int b);
}

DynemicArrayComparator <|-- AscDynemicArrayComparator
DynemicArrayComparator <|-- DescDynemicArrayComparator

class DynamicArray {
    private int[] data;
    private int length, last;
    private final int minLength = 10;

    public DynamicArray()
    public int getLength();
    public int get(int index);
    public void set(int index, int value);
    private void resize();
    private void trim();
    public void add(int value);
    public void insert(int index, int value);
    public void delete(int index);
    public void sort(int start,int end,DynamicArrayComparator comparator);
    private int partition( int start, int end,DynamicArrayComparator comparator);
    public int[] toArray();    
    public void clear();
}
@enduml
