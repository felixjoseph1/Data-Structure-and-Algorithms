package Trees.BST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BinarySearchTree tree=new BinarySearchTree();
        System.out.println("How many elements?");
        int n=sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.println("Enter value "+i);
            tree.insert(sc.nextInt());
        }

        prettyDisplay(tree.root,0);
    }
    public static void prettyDisplay(BinarySearchTree.Node node, int level){
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
