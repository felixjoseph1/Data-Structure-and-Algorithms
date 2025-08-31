package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {
    public static void main(String[] args) {
        Solution sol=new Solution();
        System.out.println(sol.generateParenthesis(3));
    }

}
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        backtrack(n,n,new StringBuilder(),result);
        return result;
    }
    public void backtrack(int open,int close,StringBuilder p, List<String> result){
        if(open==0 && close==0){
            result.add(p.toString());
            return;
        }
        if (open > 0) {
            p.append('(');
            backtrack(open - 1, close, p, result);
            p.deleteCharAt(p.length() - 1);
        }
        if (close > open) {
            p.append(')');
            backtrack(open, close - 1, p, result);
            p.deleteCharAt(p.length() - 1);
        }
    }
}