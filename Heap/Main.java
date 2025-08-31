package Heap;

public class Main {
    public static void main(String[] args) throws Exception {
        MinHeap<Integer> heap = new MinHeap<>();
        heap.insert(66);
        heap.insert(75);
        heap.insert(10);
        heap.insert(26);
        heap.insert(54);
        System.out.println(heap.display());
        System.out.println(heap.getMin()); // 3
        heap.remove();
        System.out.println(heap.getMin()); // 10
        System.out.println(heap.display());

        //string
        MinHeap<String> StringHeap = new MinHeap<>();
        StringHeap.insert("kansa");
        StringHeap.insert("Felix");
        StringHeap.insert("stanly");
        StringHeap.insert("Jenix");
        StringHeap.insert("new");
        System.out.println(StringHeap.display());
        System.out.println(StringHeap.getMin()); // felix
        StringHeap.remove();
        System.out.println(StringHeap.getMin()); // jenix
        StringHeap.remove();
        System.out.println(StringHeap.display());
        System.out.println(StringHeap.getMin());//kansa
        System.out.println(StringHeap.display());


    }
}
