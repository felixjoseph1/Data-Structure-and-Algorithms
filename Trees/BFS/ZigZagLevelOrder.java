package Trees.BFS;

import java.util.*;

public class ZigZagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        Deque<TreeNode> deque=new ArrayDeque<>();
        if(root!=null){
            deque.addLast(root);
        }
        boolean reverse = false;
        while(!deque.isEmpty()){
            List<Integer> level=new ArrayList<>();
            int n= deque.size();
            for(int i=0;i<n;i++){
                if(reverse){
                    TreeNode curr=deque.pollLast();
                    level.add(curr.val);
                    if(curr.right!=null) deque.addFirst(curr.right); //right first , then left in reverse
                    if(curr.left!=null) deque.addFirst(curr.left);

                }
                else{
                    TreeNode curr=deque.pollFirst();
                    level.add(curr.val);
                    if(curr.left!=null) deque.addLast(curr.left);
                    if(curr.right!=null) deque.addLast(curr.right);
                }
            }
            reverse=!reverse;
            result.add(level);
        }
        return result;
    }
}
