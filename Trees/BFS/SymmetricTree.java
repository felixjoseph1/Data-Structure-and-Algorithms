package Trees.BFS;

import java.util.*;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricHelp(root.left,root.right);
    }
    public boolean isSymmetricHelp(TreeNode left,TreeNode right){
        if(left == null || right==null){
            return left==right;
        }
        if(left.val!=right.val){
            return false;
        }
        return (isSymmetricHelp(left.left,right.right) && isSymmetricHelp(left.right,right.left));
    }
}
