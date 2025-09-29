package com.code.challenges.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Valid Sudoku
 * Medium
 * Topics
 * conpanies icon
 * Companies
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 *
 * Example 1:
 *
 * Input: board =
        [["5","3",".",||".","7",".", || ".",".","."]
        ,["6",".",".",||"1","9","5", || ".",".","."]
        ,[".","9","8",||".",".",".", || ".","6","."]
        ============================================
        ,["8",".",".",||".","6",".", || ".",".","3"]
        ,["4",".",".",||"8",".","3", || ".",".","1"]
        ,["7",".",".",||".","2",".", || ".",".","6"]
         ============================================
        ,[".","6",".",||".",".",".", || "2","8","."]
        ,[".",".",".",||"4","1","9", || ".",".","5"]
        ,[".",".",".",||".","8",".", || ".","7","9"]]
 * Output: true
 */
public class ValidSudoku {

    static void main() {

        char[][] case1 = {
            {'5', '3', '.', /**/  '.', '7', '.', /**/  '.', '.', '.'},
            {'6', '.', '.', /**/  '1', '9', '5', /**/  '.', '.', '.'},
            {'.', '9', '8', /**/  '.', '.', '.', /**/  '.', '6', '.'},
            // ============ /**/ =============== /**/  ==============
            {'8', '.', '.', /**/  '.', '6', '.', /**/  '.', '.', '3'},
            {'4', '.', '.', /**/  '8', '.', '3', /**/  '.', '.', '1'},
            {'7', '.', '.', /**/  '.', '2', '.', /**/  '.', '.', '6'},
            // ============ /**/ =============== /**/  ==============
            {'.', '6', '.', /**/  '.', '.', '.', /**/  '2', '8', '.'},
            {'.', '.', '.', /**/  '4', '1', '9', /**/  '.', '.', '5'},
            {'.', '.', '.', /**/  '.', '8', '.', /**/  '.', '7', '9'}
        };

        char[][] case2 = {
            {'8','3','.', /**/ '.','7','.', /**/ '.','.','.'},
            {'6','.','.', /**/ '1','9','5', /**/ '.','.','.'},
            {'.','9','8', /**/ '.','.','.', /**/ '.','6','.'},
            // ========== /**/ ============ /**/  =========
            {'8','.','.', /**/ '.','6','.', /**/ '.','.','3'},
            {'4','.','.', /**/ '8','.','3', /**/ '.','.','1'},
            {'7','.','.', /**/ '.','2','.', /**/ '.','.','6'},
            // ========== /**/ ============ /**/  =========
            {'.','6','.', /**/ '.','.','.', /**/ '2','8','.'},
            {'.','.','.', /**/ '4','1','9', /**/ '.','.','5'},
            {'.','.','.', /**/ '.','8','.', /**/ '.','7','9'}
        };

        System.out.println("Sudoku Case 1 " + isValidSudoku(case1));
        System.out.println("Sudoku Case 2 " + isValidSudoku(case2));
    }

    public static boolean isValidSudoku(char[][] board) {

        List<Character> rowNumbers = new ArrayList();
        List<Character> columnlNumbers = new ArrayList();

        Map<String, List<Character>> squaresMaps = new HashMap<>();
        //List<Character>

        // Validate each Column
        boolean validColumnsSudoku = true;
        boolean validRowsSudoku = true;
        boolean validSquaresSudoku = true;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {

                if(board[j][i] != '.') {

                    // 0,1,2
                    String horizontalSquare = i/3 + "";
                    String verticalSquare = j/3 + "";
                    if(squaresMaps.containsKey(i/3 + "-" + j/3)) {
                        List<Character> squareChars = squaresMaps.get(i/3 + "-" + j/3);
                        if(squareChars.contains(board[j][i]) )  {
                            validSquaresSudoku = false;
                        }
                        squareChars.add(board[j][i]);
                    } else {
                        List<Character> list = new ArrayList<>();
                        list.add(board[j][i]);
                        squaresMaps.put(i/3 + "-" + j/3, list);
                    }

                    if(!rowNumbers.contains(board[j][i])) {
                        rowNumbers.add(board[j][i]);
                    } else {
                        validColumnsSudoku = false;
                        break;
                    }
                }
                if(board[i][j] != '.') {
                    if(!columnlNumbers.contains(board[i][j])) {
                        columnlNumbers.add(board[i][j]);
                    } else {
                        validColumnsSudoku = false;
                        break;
                    }
                }
            }
            rowNumbers.clear();
            columnlNumbers.clear();
        }
        if(!validColumnsSudoku || !validRowsSudoku) {
            return false;
        }
        if(!validSquaresSudoku) {
            return false;
        }
        return true;
    }
}
