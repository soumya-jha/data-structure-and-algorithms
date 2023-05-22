package org.techinterviewhandbook.grind75;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0 || intervals[0].length < 2) {
            return new int[][]{newInterval};
        }
        if (newInterval == null || newInterval.length < 2) {
            return intervals;
        }
        List<List<Integer>> result = new ArrayList<>();
        int idx = 0;
        int start = newInterval[0];
        int end = newInterval[1];
        int n = intervals.length;
        while (idx < n && intervals[idx][0] < start) {
            List<Integer> interval = new ArrayList<>();
            interval.add(intervals[idx][0]);
            interval.add(intervals[idx][1]);
            result.add(interval);
            idx++;
        }
        if (result.size() == 0 || result.get(result.size() - 1).get(1) < start) {
            List<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            result.add(interval);
        } else {
            result.get(result.size() - 1).set(1, Math.max(result.get(result.size() - 1).get(1), end));
        }
        while (idx < n) {
            if (result.get(result.size() - 1).get(1) < intervals[idx][0]) {
                List<Integer> interval = new ArrayList<>();
                interval.add(intervals[idx][0]);
                interval.add(intervals[idx][1]);
                result.add(interval);
            } else {
                result.get(result.size() - 1).set(1, Math.max(result.get(result.size() - 1).get(1), intervals[idx][1]));
            }
            idx++;
        }
        return result.stream()
                .map(l -> l.stream().mapToInt(Integer::intValue).toArray())
                .toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] result = new InsertInterval().insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});
        for (int[] row : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println();
        }
    }
}
