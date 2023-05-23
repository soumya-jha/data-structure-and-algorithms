package org.techinterviewhandbook.grind75;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        Comparator<int[]> distComparator = Comparator.comparing(point -> Math.pow(point[0], 2) + Math.pow(point[1], 2));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(distComparator);
        for (int[] row : points) {
            minHeap.offer(row);
        }
        int idx = 0;
        int[][] result = new int[k][2];
        while (idx < k && !minHeap.isEmpty()) {
            int[] point = minHeap.poll();
            result[idx][0] = point[0];
            result[idx][1] = point[1];
            idx++;
        }
        return result;
    }

    public static void main(String[] args) {
        new KClosestPoints().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    }
}
