package SystemDesign.LRUCache;

import java.util.HashMap;

public class LRUCache {
    private final int capacity;
    private final HashMap<Integer,Node> map;
    private final Node head;
    private final Node tail;
    public LRUCache(int capacity){
        this.capacity=capacity;
        this.map=new HashMap<>(capacity);
        this.head=new Node(0,0);
        this.tail=new Node(0,0);
        head.next=tail;
        tail.prev=head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node=map.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            remove(node);
            addToHead(node);
            return;
        }
        if(map.size()==capacity){
            Node lruNode=tail.prev;
            map.remove(lruNode.key);
            remove(lruNode);
        }
        Node newNode=new Node(key,value);
        map.put(key,newNode);
        addToHead(newNode);
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void addToHead(Node node){

        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
    }
}




