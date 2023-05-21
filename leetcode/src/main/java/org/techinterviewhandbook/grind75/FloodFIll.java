package org.techinterviewhandbook.grind75;

public class FloodFIll {
    /*
    1 1 1       2 2 2
    1 1 0   ->  2 2 0
    1 0 1       2 0 1

    00 01 02
    10 11 12
    20 21 23

    */
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int currColor = image[sr][sc];
        if (currColor == color)
            return image;
        changeColor(image, sr, sc, currColor, color, image.length, image[0].length);
        return image;
    }

    private void changeColor(int[][] image, int row, int col, int currColor, int targetColor, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != currColor) {
            return;
        }
        image[row][col] = targetColor;
        changeColor(image, row - 1, col, currColor, targetColor, m, n);
        changeColor(image, row + 1, col, currColor, targetColor, m, n);
        changeColor(image, row, col - 1, currColor, targetColor, m, n);
        changeColor(image, row, col + 1, currColor, targetColor, m, n);
    }

    public static void main(String[] args) {
        int[][] image = new FloodFIll().floodFill(new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}}, 1, 1, 2);
        //int[][] image = new FloodFIll().floodFill(new int[][]{{0, 0 , 0}, {0, 0, 0}}, 0, 0, 0);
        for (int[] row : image) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }
}
