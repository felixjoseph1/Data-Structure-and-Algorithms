package Backtracking;
//find all paths for down D, right R, up U, left L to reach (2,2)
//3
public class AllPathsBacktrack {
    public static void main(String[] args) {
        boolean maze[][]={
                {true,true,true},
                {true,true,true},
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
        maze[row][col] = false; //mark as visited while entering into a function call

        //Down
        if (row < maze.length - 1) {
            findAllpath(p + "D", maze, row + 1, col);
        }
        //Right
        if (col < maze[0].length - 1) {
            findAllpath(p + "R", maze, row, col + 1);
        }
        //Up
        if (row > 0) {
            findAllpath(p + "U", maze, row - 1, col);
        }
        //Left
        if (col > 0) {
            findAllpath(p + "L", maze, row, col - 1);
        }

        maze[row][col] = true; //mark as Unvisited while leaving from a function call//
    }
}
