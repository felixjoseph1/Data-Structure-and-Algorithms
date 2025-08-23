package Trees;

import java.util.Scanner;


public class BinarySearchTree {
    public static class Node{
        int value;
        Node left;
        Node right;
        int height;
        public Node(int val){
            this.value=val;
        }
        public int getValue(){
            return value;
        }
        public int getHeight(){
            return height;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the root node of the tree");
        int value=sc.nextInt();
        Node root= new Node(value);
        System.out.println("Do you want to add more elements. Enter true/false");
        if(sc.nextBoolean()){
            System.out.println("How many elements?");
            int n=sc.nextInt();
            for(int i=1;i<=n;i++){
                System.out.println("Enter value "+i);
                root=insert(root,sc.nextInt());
            }
        }
        prettyDisplay(root,0);
    }
    public static Node insert(Node root,int value){
        if(root==null){
            Node node= new Node(value);
            return node;
        }
        if(value<root.value) root.left= insert(root.left,value);
        else if(value> root.value) root.right= insert(root.right,value);
        root.height=Math.max(root.left.height,root.right.height)+1;
        return root;
    }
    public static void prettyDisplay(Node node, int level){
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.print("|------>");
            System.out.println(node.value);
        }
        else{
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }
}
