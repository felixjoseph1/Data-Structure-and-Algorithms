package Trees.AVL;

public class AVL {
    public static class Node{
        private int value;
        private int height;
        Node left;
        Node right;

        public Node(int value){
            this.value=value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;
    public Node getRoot(){
        return root;
    }
    //Height
    public int height(){
        return height(root);
    }
    private int height(Node node){
        if(node==null){
            return -1;
        }
        return node.height;
    }

    //insert
    public void insert(int value){
        root=insert(root,value);
    }
    private Node insert(Node node,int value){
        if(node ==null){
            Node newNode = new Node(value);
            return newNode;
        }
        if(value<node.value){
            node.left=insert(node.left,value);
        }
        else if(value>node.value){
            node.right=insert(node.right,value);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }

    private Node rotate(Node node){
        //left heavy
        if(height(node.left)-height(node.right)>1){
            //left-left case 1
            if(height(node.left.left)-height(node.left.right)>0){
                return rightRotate(node);
            }
            //left-right case 2
            else if(height(node.left.left)-height(node.left.right)<0){
                node.left= leftRotate(node.left);
                return rightRotate(node);
            }
        }
        //right heavy
        else if(height(node.left)-height(node.right)<-1){
            //right-right case 3
            if(height(node.right.left)-height(node.right.right)<0){
                return leftRotate(node);
            }
            //right-left case 4
            else if(height(node.right.left)-height(node.right.right)>0){
                node.right= rightRotate(node.right);
                return leftRotate(node);
            }
        }
        return node;
    }

    public Node leftRotate(Node p){
        Node c=p.right;
        Node t=c.left;

        p.right=t;
        c.left=p;

        p.height=Math.max(height(p.left),height(p.right))+1;
        c.height=Math.max(height(c.left),height(c.right))+1;
        return c;
    }
    public Node rightRotate(Node p){
        Node c=p.left;
        Node t=c.right;

        p.left=t;
        c.right=p;

        p.height=Math.max(height(p.left),height(p.right))+1;
        c.height=Math.max(height(c.left),height(c.right))+1;
        return c;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        return checkBalance(node) != -1;
    }

    // returns height if balanced, -1 if not balanced
    private int checkBalance(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = checkBalance(node.left);
        if (leftHeight == -1) return -1; // left subtree not balanced

        int rightHeight = checkBalance(node.right);
        if (rightHeight == -1) return -1; // right subtree not balanced

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1; // current node not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }

}