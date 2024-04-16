package leetcode_1_1000;

import java.util.Arrays;

/**
 * @author tianling
 * @description:
 * @since 2024/3/29
 */
public class Leetcode_37 {
    public static void main(String[] args) {
        Leetcode_37 leetcode37=new Leetcode_37();
        char[][] board = new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        leetcode37.solveSudoku(board);
        System.out.println(Arrays.deepToString(board));

    }


    public void solveSudoku(char[][] board) {
        backTacking(board);
    }

    private boolean backTacking(char[][] board){


        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col]!='.'){
                    continue;
                }
                for (char value = '1'; value <= '9'; value++) {
                    if (isValidate(board,row,col,value)){
                        board[row][col]=value;
                        if (backTacking(board)) {
                            return true;
                        }
                        board[row][col]='.';
                    };
                }
                // 这相当于是剪枝，当某一列都都走完的时候还没弄出足够的值，说明当前这个可能的棋盘是肯定不满足要求的，直接返回false即可
                return false;
            }

        }

        return true;

    }


    private boolean isValidate(char[][] board,int row ,int col,char value){
        // 判断行是否存在重复值
        for (int i = 0; i < 9; i++) {
            if (board[row][i]==value) {
                return false;
            }
        }


        // 判断列是否存在重复值
        for (int i = 0; i < 9; i++) {
            if (board[i][col]==value) {
                return false;
            }
        }

        //判断九宫格内是否存在重复值
        // 1/3=0,会省略掉小数点
        int startRow=(row/3)*3;
        int startCol=(col/3)*3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j]==value) {
                    return false;
                }
            }
        }

        return true;
    }
}
