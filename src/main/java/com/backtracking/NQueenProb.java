package com.backtracking;

public class NQueenProb {

    private static final int TOTAL_QUEENS = 4;
    private static final int BOARD_SIZE = 4;

    public static void main(String[] args){

        int[][] board  = new int[BOARD_SIZE][BOARD_SIZE];
        NQueenProb prob = new NQueenProb();
        prob.solution(board, 0, 1);
        for (int i = 0; i <  board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + ", ");
            }
            System.out.println();
        }

    }

    public boolean solution(int[][] board, int row, int queenPlaced){

        if(queenPlaced > TOTAL_QUEENS){
            return true;
        }

        for (int column = 0; column < board.length; column++) {
            board[row][column] = 1;
            if(isSafe(board, row, column)){
                if(solution(board, row + 1, queenPlaced + 1)){
                    return true;
                }
            }
            board[row][column] = 0;
        }
        return false;
    }

    private boolean isSafe(int[][] board, int row, int column){

        if(isXSafe(board, row, column)
            && isYSafe(board, row, column)
            && isLeftDiagonalSafe(board, row, column)
            && isRightDiagonalSafe(board,row, column)){
            return true;
        }
        return false;
    }

    private boolean isXSafe(int[][] board, int row, int column){

        for (int j = 0; j < board.length; j++) {
            if(j != column && board[row][j] == 1){
                return false;
            }
        }
        return true;
    }

    private boolean isYSafe(int[][] board, int row, int column){
        for (int i = 0; i < board.length; i++) {
            if(i != row && board[i][column] == 1){
                return false;
            }
        }
        return true;
    }

    private boolean isRightDiagonalSafe(int[][] board, int row, int column){

        int tempI = row + 1, tempJ = column - 1;
        while(tempI < board.length && tempJ >= 0){
            if(board[tempI][tempJ] == 1){
                return false;
            }
            tempI += 1;
            tempJ -= 1;
        }
        tempI = row - 1;
        tempJ = column + 1;
        while(tempI >= 0 && tempJ < board.length){
            if(board[tempI][tempJ] == 1){
                return false;
            }
            tempI -= 1;
            tempJ += 1;
        }
        return true;
    }

    private boolean isLeftDiagonalSafe(int[][] board, int row, int column){

        int tempI = row + 1, tempJ = column + 1;
        while(tempI < board.length && tempJ < board.length){
            if(board[tempI][tempJ] == 1){
                return false;
            }
            tempI += 1;
            tempJ += 1;
        }

        tempI = row - 1;
        tempJ = column - 1;

        while(tempI >= 0 && tempJ >= 0){
            if(board[tempI][tempJ] == 1){
                return false;
            }
            tempI -= 1;
            tempJ -= 1;
        }

        return true;
    }

}
