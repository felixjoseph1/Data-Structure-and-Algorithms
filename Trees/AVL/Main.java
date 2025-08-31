package Trees.AVL;

import Trees.BST.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        AVL tree=new AVL();
        for(int i=0;i<1000;i++){
            tree.insert(i);
        }

        System.out.println(tree.isBalanced());
        prettyDisplay(tree.getRoot(),0);
        System.out.println("height of tree : "+tree.height());
    }
    public static void prettyDisplay(AVL.Node node, int level){
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.print("|------>");
            System.out.println(node.getValue());
        }
        else{
            System.out.println(node.getValue());
        }
        prettyDisplay(node.left,level+1);
    }

}
