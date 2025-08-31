package Heap;

import java.util.ArrayList;

public class MinHeap<T extends Comparable<T>> {
    private ArrayList<T> list;

    public MinHeap() {
        list=new ArrayList<>();
    }

    public int parent(int index) {
        return (index-1)/2;
    }

    public int left(int index){
        return index*2+1;
    }

    public int right(int index){
        return index*2+2;
    }

    public T getMin() throws Exception{
        if(list.isEmpty()){
            throw new Exception("Heap is empty.");
        }
        return list.getFirst();
    }

    public void insert(T value){
        list.add(value);
        heapifyUp(list.size()-1);
    }

    public void remove(){
        T lastElement=list.removeLast();
        list.set(0,lastElement);
        heapifyDown(0);
    }

    public void heapifyUp(int index){
        if(index==0) return;
        int parentIndex=parent(index);
        if((list.get(index)).compareTo(list.get(parentIndex))<0){
            swap(index,parentIndex);
            heapifyUp(parentIndex);
        }
    }

    public void heapifyDown(int index){
        int smallestIndex=index;
        int leftIndex=left(index);
        int rightIndex=right(index);
        if(leftIndex<list.size() && (list.get(smallestIndex).compareTo(list.get(leftIndex)))>0){
            smallestIndex=leftIndex;
        }
        if(rightIndex<list.size() && (list.get(smallestIndex).compareTo(list.get(rightIndex)))>0){
            smallestIndex=rightIndex;
        }
        if(smallestIndex!=index){
            swap(smallestIndex,index);
            heapifyDown(smallestIndex);
        }
    }

    public void swap(int ind1,int ind2){
        T temp=list.get(ind1);
        list.set(ind1, list.get(ind2));
        list.set(ind2, temp);

    }

    public ArrayList<T> display(){
        return list;
    }



}
