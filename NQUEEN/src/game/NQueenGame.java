package game;

import board.QueenBoard;

public class NQueenGame {
    QueenBoard q;

    public NQueenGame(QueenBoard q){
        this.q = q;
    }

    public void play(){
        if(q.size < 4){
            System.out.println("No configuration possible");
            return;
        }

        nqueen_helper(q.board,0);
    }

    private void nqueen_helper(char[][] board, int row){
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int col=0; col<board.length; col++){
            if(isSafeQueen(board, row, col)==true){
                board[row][col]='0';
                nqueen_helper(board, row+1);
                board[row][col]='-';
            }
        }
    }

    private boolean isSafeQueen(char[][] board, int row, int col){
        for(int i=row-1,j=col-1; i>=0 && j>=0; i--,j--){
            if(board[i][j]=='0')
            return false;
        }

        for(int i=row-1,j=col; i>=0 ; i--){
            if(board[i][j]=='0')
            return false;
        }

        for(int i=row-1,j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='0')
            return false;
        }
        return true;
    }

    private void printBoard(char[][] board){
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}