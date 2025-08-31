package Trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n= queue.size();
            TreeNode curr=null;
            for(int i=0;i<n;i++){
                curr=queue.poll();
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            result.add(curr.val);
        }
        return result;
    }
}
