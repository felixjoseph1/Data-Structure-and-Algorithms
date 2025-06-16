package Backtracking;
//1
import java.util.ArrayList;

//only right and down
public class MazePathCount {
    public static void main(String[] args) {
        int mazeSize=3;
        //System.out.println(countPaths(mazeSize,mazeSize));
        //printPaths("",mazeSize,mazeSize);
        //System.out.println(printPathsList("",mazeSize,mazeSize));
        System.out.println(printPathsWithDiagonalList("",mazeSize,mazeSize));
    }
    public static int countPaths(int row,int col){
        if(row==1||col==1) return 1;
        return countPaths(row-1,col)+countPaths(row,col-1);
    }

    public static void printPaths(String p,int row,int col){
        if(row==1 && col==1){
            System.out.println(p);
            return;
        }
        if(row>1) {
            printPaths(p + "D", row - 1, col);
        }
        if(col>1) {
            printPaths(p + "R", row, col - 1);
        }
    }

    //return answers in List
    public static ArrayList<String> printPathsList(String p,int row,int col){
        if(row==1 && col==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        if(row>1) {
            ans.addAll(printPathsList(p + "D", row - 1, col));
        }
        if(col>1) {
            ans.addAll(printPathsList(p + "R", row, col - 1));
        }
        return ans;
    }

    //diagonal also
    public static ArrayList<String> printPathsWithDiagonalList(String p,int row,int col){
        if(row==1 && col==1){
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        if(row>1) {
            ans.addAll(printPathsWithDiagonalList(p + "V", row - 1, col));
        }
        if(row>1 && col>1) {
            ans.addAll(printPathsWithDiagonalList(p + "D", row-1, col-1));
        }
        if(col>1) {
            ans.addAll(printPathsWithDiagonalList(p + "H", row, col - 1));
        }
        return ans;
    }
}

//cool!!  Simple Stuff!!