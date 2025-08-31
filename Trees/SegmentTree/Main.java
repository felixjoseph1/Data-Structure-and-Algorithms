package Trees.SegmentTree;

import Trees.BST.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
        SegmentTree tree=new SegmentTree();
        int arr[]=new int[]{3,8,7,6,-2,-8,4,9};
        tree.createSegmentTree(arr,0,arr.length-1);
        //display segment tree
        prettyDisplay(tree.root,0);

        //query
        int query[]=new int[]{2,6};
        System.out.println("Sum for the query : "+"["+query[0]+","+ query[1]+"] is "+ tree.findSum(query[0],query[1]));
        //update
        tree.update(3,14);
        prettyDisplay(tree.root,0);
        System.out.println("Sum for the query : "+"["+query[0]+","+ query[1]+"] is "+ tree.findSum(query[0],query[1]));
    }
    public static void prettyDisplay(SegmentTree.Node node, int level){
        if(node==null){
            return;
        }
        prettyDisplay(node.right,level+1);
        if(level!=0){
            for(int i=0;i<level-1;i++){
                System.out.print("|\t\t");
            }
            System.out.print("|------>");
            System.out.println(node.getValue()+"["+node.startInterval+","+ node.endInterval+"]");
        }
        else{
            System.out.println(node.getValue()+"["+node.startInterval+","+ node.endInterval+"]");
        }
        prettyDisplay(node.left,level+1);
    }
}
