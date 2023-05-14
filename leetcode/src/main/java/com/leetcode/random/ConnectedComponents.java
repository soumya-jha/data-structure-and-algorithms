package com.leetcode.random;

import java.util.*;

public class ConnectedComponents {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = this.createGraph(edges);
        boolean[] visited = new boolean[n];
        int completeCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i] && this.traverseGraphBFS(graph, visited, i)) {
                completeCount++;
            }
        }
        return completeCount;
    }

    private Map<Integer, Set<Integer>> createGraph(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            graph.putIfAbsent(x, new HashSet<>());
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        return graph;
    }

    private boolean traverseGraphBFS(Map<Integer, Set<Integer>> graph, boolean[] visited, int vertex) {
        Queue<Integer> vertexQ = new LinkedList<>();
        vertexQ.offer(vertex);
        visited[vertex] = true;
        int connectedVertex = 0;
        Set<Integer> currComponent = new HashSet<>();
        while (!vertexQ.isEmpty()) {
            int currVertex = vertexQ.poll();
            currComponent.add(currVertex);
            for (int adjVertex : graph.getOrDefault(currVertex, new HashSet<>())) {
                if (!visited[adjVertex]) {
                    vertexQ.offer(adjVertex);
                    visited[adjVertex] = true;
                    connectedVertex++;
                }
            }
        }
        return isCompleteGraph(connectedVertex, currComponent, graph);
    }

    private boolean isCompleteGraph(int connectedVertex, Set<Integer> currComponent, Map<Integer, Set<Integer>> graph) {
        for (int vertex : currComponent) {
            if (graph.getOrDefault(vertex, new HashSet<>()).size() != connectedVertex) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ConnectedComponents cc = new ConnectedComponents();
        System.out.println(cc.countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}}));
        System.out.println(cc.countCompleteComponents(6, new int[][]{{0, 1}, {0, 2}, {1, 2}, {3, 4}, {3, 5}}));
    }
}
