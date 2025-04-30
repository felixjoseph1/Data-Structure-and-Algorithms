package Recursion.Permutation;

import java.util.ArrayList;

public class permutation {
    public static void main(String[] args) {
        //findPermu("","abcdef");
        //System.out.println(findPermuReturnList("","abc"));;
        System.out.println(countPermutations("","abcd"));
    }
    public static void findPermu(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String permuted = p.substring(0, i) + ch + p.substring(i);
            findPermu(permuted, up.substring(1));
        }
    }

    //return answer in ArrayList
    public static ArrayList<String> findPermuReturnList(String p,String up){
        if(up.isEmpty()){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String permuted = p.substring(0, i) + ch + p.substring(i);
            ans.addAll(findPermuReturnList(permuted, up.substring(1)));
        }
        return ans;
    }

    //count the total no.of permutations
    public static int countPermutations(String p,String up){
        if(up.isEmpty()){
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++) {
            String permuted = p.substring(0, i) + ch + p.substring(i);
            count+=countPermutations(permuted, up.substring(1));
        }
        return count;
    }
}