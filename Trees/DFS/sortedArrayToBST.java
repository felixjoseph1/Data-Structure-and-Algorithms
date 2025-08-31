package Trees.DFS;

import Trees.BFS.TreeNode;

public class sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        nums= new int[]{-10, -3, 0, 5, 9};
        TreeNode root = null;
        Divide(nums,0,nums.length-1,root);
        return root;
    }
    public TreeNode Divide(int[] nums,int left,int right,TreeNode node){
        int mid=left+(right-left)/2;
        if(left>=right){
            return null;
        }
        node=insert(node,nums[mid]);
        node.left=Divide(nums,left,mid,node.left);
        node.right=Divide(nums,mid+1,right,node.right);
        return node;
    }
    //insert function for BST
    public TreeNode insert(TreeNode node,int value){
        if(node ==null){
            return new TreeNode(value);
        }
        if(value<node.val){
            node.left=insert(node.left,value);
        }
        else if(value>node.val){
            node.right=insert(node.right,value);
        }
        return node;
    }
}
