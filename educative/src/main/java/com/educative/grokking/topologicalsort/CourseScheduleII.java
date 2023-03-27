package com.educative.grokking.topologicalsort;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {2, 1}, {1, 2}};
        //System.out.println(findOrder(3, prerequisites));

        System.out.println(findOrder(10, new int[][] {{5, 8}, {3, 5}, {1, 9}, {4, 5}, {0, 2}, {7, 8}, {4, 9}}));

    }

    public static List<Integer> findOrder(int n, int[][] prerequisites) {
        //Declare adjacency list
        Map<Integer, List<Integer>> graph = new HashMap<>();
        //Declare map for maintaining inDegree count
        Map<Integer, Integer> inDegree = new HashMap<>();
        //Create a graph structure and inDegree map, add all numbers(courses) from 1 to (n-1)
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
            inDegree.put(i, 0);
        }
        //Populate values in graph and inDegree map as per given prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            int parent = prerequisites[i][1];
            int child = prerequisites[i][0];
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
        //Declare a queue to store vertex with current inDegree count as zero
        Queue<Integer> sources = new LinkedList<>();
        for (int key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                sources.add(key);
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!sources.isEmpty()) {
            int vertex = sources.poll();
            result.add(vertex);
            for (int child : graph.get(vertex)) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        //Check if result size is equal to the number of courses, if not, there must be a cycle detected,
        // return empty arraylist since no order is possible in this case
        if(result.size()!=n){
            return new ArrayList<>();
        }
        return result;
    }
}
