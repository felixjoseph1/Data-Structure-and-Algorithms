package Recursion.Permutation;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class NumberPad {
    static String[] keypad =new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static void main(String[] args) {
        //padPermutation("", "21");
        //leetcode17("","23");
        System.out.println(leetcode17List("","23"));
    }

    public static void padPermutation(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0) - '0'; // converts '2' to 2
        for (int i = (digit - 2) * 3; i < (digit - 1) * 3; i++) {
            char ch = (char) (i + 'a');
            padPermutation(p + ch, up.substring(1));
        }
    }

    public static void leetcode17(String p, String up){
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        for(char ch:keypad[digit].toCharArray()){
            leetcode17(p+ch,up.substring(1));
        }
    }

    public static ArrayList<String> leetcode17List(String p, String up){
        if (up.isEmpty()) {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        int digit=up.charAt(0)-'0';
        for(char ch:keypad[digit].toCharArray()){
            ans.addAll(leetcode17List(p+ch,up.substring(1)));
        }
        return ans;
    }
}
