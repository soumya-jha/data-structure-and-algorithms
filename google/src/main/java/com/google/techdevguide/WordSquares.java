package com.google.techdevguide;

/**
 * A “word square” is an ordered sequence of K different words of length K that, when written one word per line, reads the same
 * horizontally and vertically. For example:
 * BALL
 * AREA
 * LEAD
 * LADY
 *
 * In this exercise you're going to create a way to find word squares.
 *
 * First, design a way to return true if a given sequence of words is a word square.
 *
 * Second, given an arbitrary list of words, return all the possible word squares it contains. Reordering is allowed.
 *
 * For example, the input list
 *
 * [AREA, BALL, DEAR, LADY, LEAD, YARD]
 *
 * should output
 *
 * [(BALL, AREA, LEAD, LADY), (LADY, AREA, DEAR, YARD)]
 *
 * Finishing the first task should help you accomplish the second task.
 *
 */

//SOLVED ONLY PART 1 of PROBLEM
public class WordSquares {
    public static void main(String[] args) {
        String[] words = new String[] {"BALL", "AREA", "LEAD", "LADY"};
        System.out.println(isWordSquare(words));

    }

    /**
     *
     * @param words
     * @return boolean
     * This method checks if matrix[i][j] == matrix[j][i];
     * if yes, returns true
     *
     * 00 01 02 03
     * 10 11 12 13
     * 20 21 22 23
     * 30 31 32 33
     */
    public static boolean isWordSquare(String[] words){
        int len = words.length;
        char [][] wordMatrix = new char[len][len];
        int row = 0;
        for(String word : words){
            //Check if length of word == length of words[], since it has to be a square matrix.
            if(word.length()!=len){
                return false;
            }
            //for each word, insert characters into the matrix
            for(int col=0;col<len;col++){
                wordMatrix[row][col] = word.charAt(col);
            }
            row = row+1;
        }

        //Read the matrix, and perform check for wordSquare
        for(int r=0; r<len;r++){
            for(int col = r+1; col<len;col++){
                if(wordMatrix[r][col] != wordMatrix[col][r]){
                    return false;
                }
            }
        }
        return true;
    }

}
