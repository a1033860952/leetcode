package leetcode_1_1000;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author tianling
 * @description:
 * @since 2024/3/24
 */
public class Leetcode_51 {


    public static void main(String[] args) {
        Leetcode_51 leetcode51=new Leetcode_51();
        leetcode51.solveNQueens(1);
    }



    private  String[][] resultArray;

    private List<List<String>> resultList;

    private int useCount;
    public List<List<String>> solveNQueens(int n) {
        resultArray = new String[n][n];
        resultList = new LinkedList<>();
        useCount = 0;
        for (String[] strings : resultArray) {
            Arrays.fill(strings, ".");
        }

        backTracking(n,0);

        return resultList;

    }

    private void backTracking(int n,int row){
        for (String[] strings : resultArray) {
            System.out.println(Arrays.toString(strings));
        }




        if (n==useCount){
            List<String> result=new LinkedList<>();
            for (String[] strings : resultArray) {
                result.add(String.join("", strings));
            }
            resultList.add(result);
        }

        for (int col = 0; col < n; col++) {
            if (isValidate(n,row,col)){
                useCount++;
                resultArray[row][col]="Q";
                backTracking(n,row+1);
                resultArray[row][col]=".";
                useCount--;
            }
        }
    }




    private boolean isValidate(int n,int row,int col){

        //判断当前行是否已经有皇后了，但是行无需判断，毕竟每一行只能有一个皇后，走过了之后，这个行一定有皇后了，无需多此一举


        //判断当前列是否已经有皇后了
        for (int i = 0; i < n; i++) {
            if ("Q".equals(resultArray[i][col])) {
                return false;
            }
        }


        //判断当前45度斜线上是否已经有皇后了，下斜线无需判断，只需要判断上斜线即可，因为下斜线是由以后的皇后来判断的
        // i-1 j+1;
        for (int i=row,j=col;i>=0 && j<n ;i--,j++){
            if ("Q".equals(resultArray[i][j])) {
                return false;
            }
        }



        //判断当前135度斜线上是否已经有皇后了，下斜线无需判断，只需要判断上斜线即可，因为下斜线是由以后的皇后来判断的
        // i-1 j-1;
        for (int i=row,j=col;i>=0 && j>=0 ;i--,j--){
            if ("Q".equals(resultArray[i][j])) {
                return false;
            }
        }

        return true;

    }




}

