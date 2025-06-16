package Recursion.Combination;

import java.util.ArrayList;

public class DiceSum {
    public static void main(String[] args) {
        Dice("",4);
        //System.out.println(DiceList("",4));
    }
    public static void Dice(String p,int target){
        if(target==0){
            System.out.println(p);
            return;
        }
        for(int i=1;i<=target && i<=6;i++){
            Dice(p+String.valueOf(i),target-i);
        }
    }

    //return list
    public static ArrayList<String> DiceList(String p, int target){
        if(target==0){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        for(int i=1;i<=target;i++){
            ans.addAll(DiceList(p+String.valueOf(i),target-i));
        }
        return ans;
    }
}
