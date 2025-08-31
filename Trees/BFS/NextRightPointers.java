package Trees.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NextRightPointers {
    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
        public Node(int val){
            this.val=val;
        }
    }
    public Node connect(Node root) {
        Queue<Node> queue=new LinkedList<>();
        if(root !=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n= queue.size();
            for(int i=0;i<n;i++){
                Node curr=queue.poll();
                if(i==n-1){
                    curr.next=null;
                }
                else{
                    curr.next=queue.peek();
                }
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
        }
        return root;
    }

    //without queue
//    public Node connect(Node root) {
//        if(root==null) return null;
//        Node leftMost=root;
//        while(leftMost.left!=null){
//            Node current=leftMost;
//            while(current!=null){
//                current.left.next=current.right;
//                if(current.next!=null){
//                    current.right.next=current.next.left;
//                }
//                current=current.next;
//            }
//            leftMost=leftMost.left;
//        }
//        return root;
//    }
}
