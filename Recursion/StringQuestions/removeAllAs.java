package Recursion.StringQuestions;
//remove all a's from the string
public class removeAllAs {
    public static void main(String[] args) {
        String str="baccad";
        System.out.println( helper(str));
        System.out.println(skipApple("felappleixapplejoseappleph"));
        System.out.println(skipAppNotApple("felappleiappxappapplejoseappleph"));
    }
    //    public static String helper(String str,String ans){
//        if(str.isEmpty()) return ans;
//        if(str.charAt(0)!='a') ans+=str.charAt(0);
//        return helper(str.substring(1),ans);
//    }
    public static String helper(String str){
        if(str.isEmpty()) return "";
        char ch=str.charAt(0);
        if(ch=='a') return helper(str.substring(1));
        else return ch+helper(str.substring(1));
    }

    //skip the words apple
    public static String skipApple(String str){
        if(str.isEmpty()) return "";
        if(str.startsWith("apple")) return skipApple(str.substring("apple".length()));
        else return str.charAt(0)+skipApple(str.substring(1));
    }

    //skip app and not apple
    public static String skipAppNotApple(String str){
        if(str.isEmpty()) return "";
        if(str.startsWith("app") && !str.startsWith("apple")) return skipAppNotApple(str.substring("app".length()));
        else return str.charAt(0)+skipAppNotApple(str.substring(1));
    }
}
