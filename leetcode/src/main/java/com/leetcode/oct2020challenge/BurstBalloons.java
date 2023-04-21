package com.leetcode.oct2020challenge;

import java.util.*;


public class BurstBalloons {

	public static void main(String[] args) {
		BurstBalloons burstBalloons = new BurstBalloons();
		int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
		/**
		 * 10, 16 
		 * 2, 8 
		 * 1, 6 
		 * 7, 12
		 */
		// int[][] points = {{1,2},{3,4},{5,6},{7,8}};
		// int[][] points = {{1,2},{2,3},{3,4},{4,5}};
		// int[][] points = {{1,2}};
		// int[][] points = {{2,3},{2,3}};
		int minNumOfArrows = burstBalloons.findMinArrowShots(points);
		System.out.println("minNumOfArrows : " + minNumOfArrows);

	}

	public int findMinArrowShots(int[][] points) {
		int minNumOfArrows = 0;

		ArrayList<Integer> startList = new ArrayList<Integer>();
		ArrayList<Integer> endList = new ArrayList<Integer>();
		for (int row = 0; row < points.length; row++) {
			for (int col = 0; col < points[row].length; col++) {
				if (col == 0) {
					startList.add(points[row][col]);
				} else {
					endList.add(points[row][col]);
				}

			}
		}
		while (startList.size() > 0) {
			int minValue = Collections.min(endList);
			minNumOfArrows++;
			for (int i = 0; i < startList.size(); i++) {
				if (startList.get(i) <= minValue) {
					startList.remove(i);
					endList.remove(i);
					i--;
				}
			}
		}
		return minNumOfArrows;
	}
	
	
	/**
	 *Below method is one of the accepted solution with 20ms runtime using PriorityQueue
	 */
	
	  public int findMinArrowShots1(int[][] points) {
	        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
	            public int compare (int[] a, int[] b) {
	                if (a[1] < b[1]) return -1;
	                else return 1;
	            }
	        });
	        if (points.length == 0) return 0;
	        for (int[] point : points) {
	            pq.add(point);
	        }
	        int count = 1, arrow = pq.peek()[1];
	        pq.poll();
	        while (!pq.isEmpty()) {
	            int[] top = pq.poll();
	            if (top[0] <= arrow) continue;
	            count++; arrow = top[1];
	        }
	        return count;
	    }

		/**
		 *Below method is one of the accepted solution with 38ms runtime.
		 */
	  
	  public int findMinArrowShots2(int[][] points) {
	        if (points.length == 0)
	            return 0;
	        Arrays.sort(points, (n1,n2) -> n1[1] - n2[1]); // sort according to second axis
	        int cnt = 1;
	        int prev_arrow = points[0][1]; // pitfall not max_value or min_value
	        for (int[] point : points) {
	            if (point[0] <= prev_arrow && prev_arrow <= point[1]) 
	                continue;
	            cnt++;
	            prev_arrow = point[1];
	        }
	        return cnt;
	    }
}
