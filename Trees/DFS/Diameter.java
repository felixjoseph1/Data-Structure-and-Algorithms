package Trees.DFS;

import Trees.BFS.TreeNode;

public class Diameter {
    int Diameter=0;
    public int diameter(TreeNode root){
        height(root);
        return Diameter;
    }
    public int height(TreeNode node){
        if(node==null) return 0;
        int left=height(node.left);
        int right =height(node.right);
        int dia=left+right;
        Diameter=Math.max(Diameter,dia);
        return Math.max(left,right)+1;
    }
}
