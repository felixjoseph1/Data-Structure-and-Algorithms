package Trees.SegmentTree;

public class SegmentTree {
    static class Node{
        private int value;
        int startInterval;
        int endInterval;
        Node left;
        Node right;
        public Node(int value,int startInterval,int endInterval){
            this.startInterval=startInterval;
            this.endInterval=endInterval;
            this.value=value;
        }

        public int getValue() {
            return value;
        }
    }
    public Node root;
    public void createSegmentTree(int []arr,int start,int end){
        root=createSegmentTree(root,arr,start,end);
    }
    private Node createSegmentTree(Node node,int []arr,int start,int end){
        int mid=start+(end-start)/2;
        if(start==end){
            Node newNode=new Node(arr[mid],start,mid);
            return newNode;
        }
        node = new Node(0, start, end);
        node.left=createSegmentTree(node.left,arr,start,mid);
        node.right=createSegmentTree(node.right,arr,mid+1,end);
        node.value=node.left.getValue()+node.right.getValue();
        return node;
    }

    public int findSum(int start,int end){
        return findSum(root,start,end);
    }
    private int findSum(Node node,int queryStart,int queryEnd){
        if(node ==null) {
            return 0;
        }
        //case 1
        if(node.startInterval>=queryStart && node.endInterval<=queryEnd){
            return node.value;
        }
        //case 2
        if(queryEnd<node.startInterval || node.endInterval<queryStart){
            return 0;
        }

        //case 3
        int left=findSum(node.left,queryStart,queryEnd);
        System.out.println("returned Left of "+node.value +": "+left);
        int right=findSum(node.right,queryStart,queryEnd);
        System.out.println("returned Right of "+node.value+": "+right);
        return left+right;
    }
    //update element
    public void update(int index,int value){
        update(index,value,root);
    }
    private void update(int index,int value,Node node){
        if(node ==null) return;
        if(node.startInterval==index && node.endInterval==index){
            node.value=value;
            return;
        }
        if(!(node.startInterval<=index && index<=node.endInterval)) return;
        update(index,value,node.left);
        update(index,value,node.right);
        node.value=node.left.getValue()+node.right.getValue();
    }
}
