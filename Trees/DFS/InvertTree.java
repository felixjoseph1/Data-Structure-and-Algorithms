package Trees.DFS;

import Trees.BFS.TreeNode;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }
    public void invert(TreeNode node){
        if(node==null) return;
        swapSides(node);
        invert(node.left);
        invert(node.right);
    }
    public void swapSides(TreeNode node){
        TreeNode temp=node.left;
        node.left=node.right;
        node.right=temp;
    }
}
