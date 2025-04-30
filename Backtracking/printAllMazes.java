package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Kunals solution
public class printAllMazes{
    public static void main(String[] args) {
        boolean maze[][]={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int path[][]={
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        findAllpath("",maze,0,0,path,1);
    }

    public static void findAllpath(String p,boolean[][] maze,int row,int col,int[][] path,int step){
        if(row== maze.length-1 && col==maze[0].length-1){
            path[row][col]=step;
            System.out.println(p);
            for(int arr[]:path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }
        if(!maze[row][col]) return;
        maze[row][col]=false; //mark as visited while entering into a function call
        path[row][col]=step;
        //Down
        if(row< maze.length-1) {
            findAllpath(p+"D",maze,row+1,col,path,step+1);
        }
        //Right
        if(col<maze[0].length-1) {
            findAllpath(p+"R",maze,row,col+1,path,step+1);
        }
        //Up
        if(row>0) {
            findAllpath(p+"U",maze,row-1,col,path,step+1);
        }
        //Left
        if(col>0) {
            findAllpath(p+"L",maze,row,col-1,path,step+1);
        }

        maze[row][col]=true; //mark as Unvisited while leaving from a function call
        path[row][col]=0;
    }
}


//My solution - manipulating only the maze array
//public class printAllMazes {
//    public static void main(String[] args) {
//        List<List<Integer>> maze = new ArrayList<>();
//        maze.add(new ArrayList<>(Arrays.asList(0,0,0)));
//        maze.add(new ArrayList<>(Arrays.asList(0,0,0)));
//        maze.add(new ArrayList<>(Arrays.asList(0,0,0)));
//
//        findAllpath("", maze, 0, 0,1);
//    }
//
//    public static void findAllpath(String p, List<List<Integer>> maze, int row, int col,int inc) {
//        int numRows = maze.size();
//        int numCols = maze.get(0).size();
//
//        if (row == numRows - 1 && col == numCols - 1) {
//            maze.get(row).set(col, inc);
//            System.out.println(p);
//            for(List<Integer> list:maze){
//                System.out.println(list);
//            }
//            System.out.println();
//            return;
//        }
//
//        if (maze.get(row).get(col)!=0) return;
//
//        maze.get(row).set(col, inc); // mark as visited
//
//        // Down
//        if (row < numRows - 1) {
//            findAllpath(p + "D", maze, row + 1, col,inc+1);
//        }
//
//        // Right
//        if (col < numCols - 1) {
//            findAllpath(p + "R", maze, row, col + 1,inc+1);
//        }
//
//        // Up
//        if (row > 0) {
//            findAllpath(p + "U", maze, row - 1, col,inc+1);
//        }
//
//        // Left
//        if (col > 0) {
//            findAllpath(p + "L", maze, row, col - 1,inc+1);
//        }
//
//        maze.get(row).set(col, 0); // mark as unvisited
//    }
//}



