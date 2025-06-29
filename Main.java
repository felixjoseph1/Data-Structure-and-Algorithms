import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        Stack<StringBuilder> str_stack =new Stack<>();
        Stack<Integer> num_stack=new Stack<>();
        int curr_num=0;
        StringBuilder curr_str=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(Character.isDigit(ch)){
                curr_num=curr_num*10+(ch-'0');
            }
            else if (ch=='[') {
                num_stack.push(curr_num);
                str_stack.push(curr_str);
                curr_num=0;
                curr_str=new StringBuilder();
            }
            else if (ch==']') {
                int popped_num=num_stack.pop();
                StringBuilder popped_str= str_stack.pop();
                StringBuilder repeated =new StringBuilder();
                for(int i=0;i<popped_num;i++){
                    repeated.append(curr_str);
                }
                popped_str.append(repeated);
                curr_str=popped_str;
            }
            else{
                curr_str.append(ch);
            }
        }
        return curr_str.toString();
    }
}