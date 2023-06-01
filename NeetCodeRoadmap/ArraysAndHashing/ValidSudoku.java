package NeetCodeRoadmap.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    /**
     * Using 3 for loops, one will check rows, the second will check columns and the third will check blocks.
     * Good solution! | Time-Complexity: O(n^2) | Space-Complexity: O(1)
     * @param board
     * @return
     */
    public static boolean validSudokuGoodSolution(char[][] board){
        Set<Character> foundNumbersWithinRow;
        Set<Character> foundNumbersWithinColumn;
        Set<Character> foundNumbersWithinBlock;

        for (int i = 0; i < 9; i++) {
            foundNumbersWithinRow = new HashSet<>();
            foundNumbersWithinColumn = new HashSet<>();
            for(int j = 0; j < 9; j++){
                char currentRowNum = board[i][j];
                if(currentRowNum != '.'){
                    if(foundNumbersWithinRow.contains(currentRowNum)){
                        return false;
                    }
                    foundNumbersWithinRow.add(currentRowNum);
                }

                char currentColNum = board[j][i];
                if(currentColNum != '.'){
                    if(foundNumbersWithinColumn.contains(currentColNum)){
                        return false;
                    }
                    foundNumbersWithinColumn.add(currentColNum);
                }
            }
        }

        //Loop 9 times, i,j represents the current block being checked.
        for(int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){

                //0,0 | 0,1 | 0,2
                //1,0 | 1,1 | 1,2
                //2,0 | 2,1 | 2,2

                //Checking each block:
                foundNumbersWithinBlock = new HashSet<>();
                int currentRowLocation = i*3;
                int currentColLocation = j*3;
                for(int a = currentRowLocation; a < currentRowLocation+3; a++){
                    for(int b = currentColLocation; b < currentColLocation+3; b++){
                        if(board[a][b] != '.'){
                            if (foundNumbersWithinBlock.contains(board[a][b])) return false;
                            foundNumbersWithinBlock.add(board[a][b]);
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println("Checking good solution:");

        //Checking valid board:
        char[][] firstBoard = new char[9][9];
        firstBoard[0] = new char[]{'1', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[1] = new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[2] = new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[3] = new char[]{'4', '.', '.', '.', '1', '2', '3', '5', '9'};
        firstBoard[4] = new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[5] = new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[6] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[7] = new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        firstBoard[8] = new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println("Valid block check expected result \"true\", Result is: " + validSudokuGoodSolution(firstBoard));

        //Checking row fail:
        char[][] secondBoard = new char[9][9];
        secondBoard[0] = new char[]{'1', '1', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[1] = new char[]{'2', '.', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[2] = new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[3] = new char[]{'4', '.', '.', '.', '1', '2', '3', '5', '9'};
        secondBoard[4] = new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[5] = new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[6] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[7] = new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        secondBoard[8] = new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println("Row is not valid check expected result \"false\", Result is: " + validSudokuGoodSolution(secondBoard));

        //Checking block fail:
        char[][] thirdBoard = new char[9][9];
        thirdBoard[0] = new char[]{'1', '.', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[1] = new char[]{'2', '1', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[2] = new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[3] = new char[]{'4', '.', '.', '.', '1', '2', '3', '5', '9'};
        thirdBoard[4] = new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[5] = new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[6] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[7] = new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        thirdBoard[8] = new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println("Block is not valid check expected result \"false\", Result is: " + validSudokuGoodSolution(thirdBoard));

        //Checking block fail:
        char[][] fourthBoard = new char[9][9];
        fourthBoard[0] = new char[]{'1', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[1] = new char[]{'1', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[2] = new char[]{'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[3] = new char[]{'4', '.', '.', '.', '1', '2', '3', '5', '9'};
        fourthBoard[4] = new char[]{'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[5] = new char[]{'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[6] = new char[]{'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[7] = new char[]{'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        fourthBoard[8] = new char[]{'9', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println("Column is not valid check expected result \"false\", Result is: " + validSudokuGoodSolution(fourthBoard));

        //Checking empty board:
        char[][] fifthBoard = new char[9][9];
        fifthBoard[0] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[1] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[2] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[3] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[4] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[5] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[6] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[7] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        fifthBoard[8] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        System.out.println("Empty board check expected result \"true\", Result is: " + validSudokuGoodSolution(fifthBoard));
    }
}
