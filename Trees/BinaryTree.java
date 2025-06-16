package Trees;

import java.util.Scanner;

public class BinaryTree {
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int val){
            this.value=val;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Node root;

//        temp
//        root=new Node(15);
//        root.left=new Node(6);
//        root.right=new Node(9);
//        root.left.left=new Node(8);
//        root.left.right=new Node(14);
//        root.left.left.right=new Node(10);
        System.out.print("Enter the value of root node : ");
        int value=sc.nextInt();
        root=new Node(value);
        constructTree(root,sc);
        //Display(root," ");
        PrettyDisplay(root,0);
    }
    public static void constructTree(Node node,Scanner sc){
        System.out.print("Do you want to enter left of "+node.value + ": Enter true/false ");
        boolean isLeft=sc.nextBoolean();
        if(isLeft){
            System.out.print("Enter the value of left of "+node.value+": ");
            int value= sc.nextInt();
            node.left=new Node(value);
            constructTree(node.left,sc);
        }
        System.out.print("Do you want to enter right of "+node.value + ": Enter true/false ");
        boolean isRight=sc.nextBoolean();
        if(isRight){
            System.out.print("Enter the value of right of "+node.value+": ");
            int value= sc.nextInt();
            node.right=new Node(value);
            constructTree(node.right,sc);
        }
    }
    public static void Display(Node node,String indent){
        if(node==null) return;
        System.out.println(node.value);
        Display(node.left,indent+" ");
        Display(node.right,indent+" ");
    }
    public static void PrettyDisplay(Node node,int level){
        if(node==null){
            return;
        }
        PrettyDisplay(node.right,level+1);
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
        PrettyDisplay(node.left,level+1);
    }
}
