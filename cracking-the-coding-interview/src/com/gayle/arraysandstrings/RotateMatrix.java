package com.gayle.arraysandstrings;

public class RotateMatrix {
    /* nxn matrix[i][j]
    00 01 02 03     0 1 2 3
    10 11 12 13     0 1 2 3
    20 21 22 23     0 1 2 3
    30 31 32 33     0 1 2 3
    Output => matrix[n-1-j][i]
    30 20 10 00     0 0 0 0
    31 21 11 01     1 1 1 1
    32 22 12 02     2 2 2 2
    33 23 13 03     3 3 3 3
     */
    //This method does not use inplace rotation. It uses an additional nxn matrix to store the rotated matrix
    private int[][] rotateMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return new int[0][0];
        }
        int n = matrix.length;
        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = matrix[n - 1 - j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        //check output in debug mode
        rm.rotateMatrix(new int[][]{{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}});
    }
}
