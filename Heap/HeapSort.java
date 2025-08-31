package Heap;

import java.util.ArrayList;

public class HeapSort {
    public static <T extends Comparable<T>> ArrayList<T> heapSort(ArrayList<T> data) throws Exception {
        MinHeap<T> heap = new MinHeap<>();
        // Insert all elements in the heap
        for (T item : data) {
            heap.insert(item);
        }
        ArrayList<T> sorted = new ArrayList<>();
        // Extract minimum repeatedly until heap is empty
        while (!heap.display().isEmpty()) {
            sorted.add(heap.getMin());
            heap.remove();
        }
        return sorted;
    }

}
