package Recursion.SubseqQuestions;

import java.util.ArrayList;

//find all subseq of str
public class SubSeq {
    public static void main(String[] args) {
        //findSubSeq("","abc");
        System.out.println( findSubSeqReturnList("","abc"));
    }
    //p-> processed str, up-> un processed str
    public static void findSubSeq(String p,String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        findSubSeq(p+ch,up.substring(1));
        findSubSeq(p,up.substring(1));
    }

    //return everything in a arraylist
    public static ArrayList<String> findSubSeqReturnList(String p,String up){
        if(up.isEmpty()) {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=findSubSeqReturnList(p+ch,up.substring(1));
        ArrayList<String> right=findSubSeqReturnList(p,up.substring(1));
        left.addAll(right);
        return left;
    }
}
