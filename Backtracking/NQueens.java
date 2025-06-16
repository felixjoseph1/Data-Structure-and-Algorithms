package Backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board =new boolean[n][n];
        System.out.println(nqueens(board,0));;
    }
    public static int nqueens(boolean [][] board, int row){
        if(row==board.length){
            Display(board);
            return 1;
        }
        int count=0;
        for(int col=0;col<board[0].length;col++){
            if(isSafe(board,row,col)){
                board[row][col]=true;
                count+=nqueens(board,row+1);
                board[row][col]=false;
            }
        }
        return count;
    }
    public static boolean isSafe(boolean [][] board,int row,int col){
        //check vertically up
        for(int i=0;i<=row;i++){
            if(board[i][col]) return false;
        }
        //check diagonally left
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]) return false;
        }

        //check diagonally right
        int maxRight=Math.min(row,board.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]) return false;
        }
        return true;
    }

    //print the board
    public static void Display(boolean[][] board){
        for(boolean[] arr:board){
            for(boolean cell:arr){
                if(cell) {
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
