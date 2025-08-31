package Heap;

public class PriorityQueue {
    public static void main(String[] args) throws Exception{
        MinHeap<Integer> pq = new MinHeap<>();
        pq.insert(5);     // insert with priority 5
        pq.insert(1);     // insert with priority 1
        pq.insert(100);   // insert with priority 100

        System.out.println(pq.getMin()); // "1" (highest priority)
        pq.remove();                     // removes "1"
        System.out.println(pq.getMin()); // "5"

    }
}
