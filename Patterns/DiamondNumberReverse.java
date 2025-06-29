package Patterns;

public class DiamondNumberReverse {
    public static void main(String[] args) {
        int n=5;
        int num=1;
        //first half
        for(int i=1;i<=n;i++){
            int temp=num;
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(temp--+" ");
            }
            num+=(i+1);
            System.out.println();

        }
        //second half
        num-=(n+1);//num=10
        for(int i=n;i>=1;i--){
            int temp=num;
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print(temp--+" ");
            }
            num-=(i);
            System.out.println();

        }
    }
}
