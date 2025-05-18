package Backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        if(solve(board)){
            Display(board);
        }
        else{
            System.out.println("This sudoku can't be solved!!");
        }
    }

    //Solve
    public static boolean solve(int[][] board){
        //check for empty cell
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]==0){
                    for(int num=1;num<=9;num++){
                        if(isSafe(i,j,board,num)){
                            board[i][j]=num;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]=0; //backtrack
                            }
                        }
                    }
                    return false; //no num found;
                }
            }
        }
        return true; //solved
    }

    //isSafe
    public static boolean isSafe(int row,int col,int [][]board,int num){
        //check row
        for(int i=0;i<9;i++){
            if(board[row][i]==num) return false;
        }

        //check col
        for(int[] row_arr :board ){
            if(row_arr[col]==num) return false;
        }

        //check every 3*3 box
        int start_row=row-(row%3);
        int start_col=col-(col%3);
        for(int i=start_row;i<start_row+3;i++){
            for(int j=start_col;j<start_col+3;j++){
                if(board[i][j]==num) return false;
            }
        }

        return true;
    }

    //display the board
    public static void Display(int[][] board){
        for(int[] arr:board){
            for(int number:arr){
                System.out.print(number+" ");
            }
            System.out.println();
        }
    }
}
