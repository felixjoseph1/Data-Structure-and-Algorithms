package Trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class isCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        int level=0, x_level=0, y_level=0;
        TreeNode parent=null,x_parent=null,y_parent=null;
        while(!queue.isEmpty()){
            int n= queue.size();
            TreeNode curr;
            for(int i=0;i<n;i++){
                curr=queue.poll();
                if(curr.val== x) {
                    x_level=level;
                    x_parent=parent;
                }
                if(curr.val==y) {
                    y_level=level;
                    y_parent=parent;
                }
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            level++;
        }
        return (x_level==y_level && x_parent!=y_parent);
    }
}
