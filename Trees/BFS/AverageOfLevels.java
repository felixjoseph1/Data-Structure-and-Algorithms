package Trees.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {

    public List<Double> solve(TreeNode root) {
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if(root!=null){
            queue.add(root);
        }
        while(!queue.isEmpty()){
            int n= queue.size();
            double sum=0;
            int i;
            for(i=0;i<n;i++){
                TreeNode curr=queue.poll();
                sum+=curr.val;
                if(curr.left!=null) queue.add(curr.left);
                if(curr.right!=null) queue.add(curr.right);
            }
            result.add(sum/i);
        }
        return result;
    }
}
