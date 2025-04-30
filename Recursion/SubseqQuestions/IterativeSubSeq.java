package Recursion.SubseqQuestions;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class IterativeSubSeq {
    public static void main(String[] args) {
        //System.out.println(ItrSubSeq(new int[]{1,2,3}));
        System.out.println(ItrDupliSubSeq(new int[]{1,2,2})); //print without duplicate subsets

    }
    public static ArrayList<ArrayList<Integer>> ItrSubSeq(int [] arr){
        ArrayList<ArrayList<Integer>> outer_list=new ArrayList<>();
        outer_list.add(new ArrayList<>());
        for(int num:arr){
            int n=outer_list.size();
            for(int i=0;i<n;i++){
                ArrayList<Integer> inner_list=new ArrayList<>(outer_list.get(i));
                inner_list.add(num);
                outer_list.add(inner_list);
            }
        }
        return outer_list;
    }

    //duplicates
    public static ArrayList<ArrayList<Integer>> ItrDupliSubSeq(int [] arr){
        int start=0,end=0;
        ArrayList<ArrayList<Integer>> outer_list=new ArrayList<>();
        outer_list.add(new ArrayList<>());
        for(int i=0;i<arr.length;i++){
            start=0;
            if(i>0 && arr[i]==arr[i-1]){
                start=end+1;
            }
            end=outer_list.size()-1;
            int n=outer_list.size();
            for(int j=start;j<n;j++){
                ArrayList<Integer> inner_list=new ArrayList<>(outer_list.get(j));
                inner_list.add(arr[i]);
                outer_list.add(inner_list);
            }
        }
        return outer_list;
    }
}
