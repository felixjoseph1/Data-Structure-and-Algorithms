package Backtracking;

public class NKnights {
    public static void main(String[] args) {
        int knights=4;
        boolean[][] board =new boolean[knights][knights];
        System.out.println(nknights(board,0,0,knights));
    }
    public static int nknights(boolean [][] board,int row,int col,int knights){
        if(knights==0){
            Display(board);
            System.out.println();
            return 1;
        }

        if(row== board.length){
            return 0;
        }

        if(col==board[0].length) {
            return nknights(board, row + 1, 0, knights);
        }
        int count=0;
        if(isSafe(board,row,col)){
            board[row][col]=true;
            count+=nknights(board,row,col+1,knights-1);
            board[row][col]=false;
        }

        //skip that cell
        count+=nknights(board,row,col+1,knights);
        return count;
    }

    public static boolean isSafe(boolean [][] board,int row,int col){
        if(isValid(board,row-2,col-1) && board[row-2][col-1]) return false;
        if(isValid(board,row-2,col+1) && board[row-2][col+1]) return false;
        if(isValid(board,row-1,col-2) && board[row-1][col-2]) return false;
        if(isValid(board,row-1,col+2) && board[row-1][col+2]) return false;
        return true;

    }

    public static boolean isValid(boolean board[][],int row,int col){
        if(row>=0 && row<board.length && col>=0 && col<board[0].length){
            return true;
        }
        return false;
    }

    public static void Display(boolean[][] board){
        for(boolean[] arr:board){
            for(boolean cell:arr){
                if(cell) {
                    System.out.print("K ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
