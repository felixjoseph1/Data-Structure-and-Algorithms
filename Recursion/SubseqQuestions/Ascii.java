package Recursion.SubseqQuestions;

import java.util.ArrayList;

//find all subseq of str as well as ascii
public class Ascii {
    public static void main(String[] args) {
        //findSubSeqAscii("","abc");
        System.out.println( findSubSeqAsciiReturnList("","abc"));
    }
    //p-> processed str, up-> un processed str
    public static void findSubSeqAscii(String p,String up){
        if(up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        findSubSeqAscii(p+ch,up.substring(1));
        findSubSeqAscii(p,up.substring(1));
        findSubSeqAscii(p+(ch+0),up.substring(1));
    }

    //return everything in a arraylist
//    public static ArrayList<String> findSubSeqAsciiReturnList(String p,String up){
//        if(up.isEmpty()) {
//            ArrayList<String> list=new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        char ch=up.charAt(0);
//        ArrayList<String> first=findSubSeqAsciiReturnList(p+ch,up.substring(1));
//        ArrayList<String> second=findSubSeqAsciiReturnList(p,up.substring(1));
//        ArrayList<String> third=findSubSeqAsciiReturnList(p+(ch+0),up.substring(1));
//        first.addAll(second);
//        first.addAll(third);
//        return first;
//    }
    public static ArrayList<String> findSubSeqAsciiReturnList(String p,String up){
        if(up.isEmpty()) {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> ans=new ArrayList<>();
        ans.addAll(findSubSeqAsciiReturnList(p+ch,up.substring(1)));
        ans.addAll(findSubSeqAsciiReturnList(p,up.substring(1)));
        ans.addAll(findSubSeqAsciiReturnList(p+(ch+0),up.substring(1)));
        return ans;
    }
}
