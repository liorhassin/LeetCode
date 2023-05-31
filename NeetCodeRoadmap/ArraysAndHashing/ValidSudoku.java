package NeetCodeRoadmap.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /**
     * Using 3 for loops, one will check rows, the second will check columns and the third will check blocks.
     * Decent solution! | Time-Complexity: O(n^2) | Space-Complexity: O(1)
     * @param board
     * @return
     */
    public static boolean validSudokuSolution(char[][] board){
        Set<Character> foundNumberWithinRow;
        Set<Character> foundNumberWithinColumn;

        for (int i = 0; i < 9; i++) {
            foundNumberWithinRow = new HashSet<>();
            foundNumberWithinColumn = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                char currentRowNum = board[i][j];
                char currentColNum = board[j][i];
                if(currentRowNum != '.'){
                    if(foundNumberWithinRow.contains(currentRowNum)){
                        return false;
                    }
                    foundNumberWithinRow.add(currentRowNum);
                }

                if(currentColNum != '.'){
                    if(foundNumberWithinColumn.contains(currentColNum)){
                        return false;
                    }
                    foundNumberWithinColumn.add(currentColNum);
                }
            }
        }

        //Finish block check before returning true.


        return true;
    }

    public static void main(String[] args) {

    }
}
