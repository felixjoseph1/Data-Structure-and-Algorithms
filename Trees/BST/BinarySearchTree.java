package Trees.BST;



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
    }
    Node root;

    //height
    public int height(){
        return height(root);
    }
    public int height(Node root){
        if(root==null){
            return -1;
        }
        return root.height;
    }
    //insert
    public void insert(int value){
        root= insert(root,value);
    }
    private Node insert(Node node,int value){
        if(node==null){
            Node newNode= new Node(value);
            return newNode;
        }
        if(value<node.value) node.left= insert(node.left,value);
        else if(value> node.value) node.right= insert(node.right,value);
        node.height=Math.max(height(node.left),height(node.right))+1;
        return node;
    }
}
