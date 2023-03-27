package com.educative.datastructures.stacksandqueues;

public class TwoStacks<V> {
    private int maxSize=-1;
    private V[] array;
    private int front;
    private int back;

    @SuppressWarnings("unchecked")
    public TwoStacks(int max_size) {
        this.maxSize = max_size;
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
        front = 0;//stack 1 top
        back = max_size-1; //stack 2 top
    }

    //insert at top of first stack
    public void push1(V value) {
        if(back-front > 1){
            array[++front] = value;
        }

    }

    //insert at top of second stack
    public void push2(V value) {
        if(back-front > 1){
            array[--back] = value;
        }
    }
    //remove and return value from top of first stack
    public V pop1() {
        if(front>=0){
            return array[front--];
        }
        return null;
    }

    //remove and return value from top of second stack
    public V pop2() {
        if(back<maxSize){
            return array[back++];
        }
        return null;
    }
}
