package Backtracking;

import java.util.ArrayList;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean maze[][]={
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        findAllpath("",maze,0,0);
    }

    public static void findAllpath(String p,boolean[][] maze,int row,int col){
        if(row== maze.length-1 && col==maze[0].length-1){
            System.out.println(p);
            return;
        }
        if(!maze[row][col]) return;
        if(row< maze.length-1) {
            findAllpath(p+"D",maze,row+1,col);
        }
        if(col<maze[0].length-1) {
            findAllpath(p+"R",maze,row,col+1);
        }
    }

    //return answers in List
    public static ArrayList<String> printPathsList(String p, int row, int col){
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

//    //diagonal also
//    public static ArrayList<String> printPathsWithDiagonalList(String p,int row,int col){
//        if(row==1 && col==1){
//            ArrayList<String> list=new ArrayList<>();
//            list.add(p);
//            return list;
//        }
//        ArrayList<String> ans=new ArrayList<>();
//        if(row>1) {
//            ans.addAll(printPathsWithDiagonalList(p + "V", row - 1, col));
//        }
//        if(row>1 && col>1) {
//            ans.addAll(printPathsWithDiagonalList(p + "D", row-1, col-1));
//        }
//        if(col>1) {
//            ans.addAll(printPathsWithDiagonalList(p + "H", row, col - 1));
//        }
//        return ans;
//    }
}
