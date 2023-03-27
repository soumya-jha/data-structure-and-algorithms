package com.educative.grokking.topologicalsort;

import java.util.*;

public class CompilationOrder {
    //dependencies: [[B, A], [C, A], [D, C], [E, D], [E, B]]
    //Compilation Order: [A, B, C, D, E]
    public static void main(String[] args) {
        List<List<List<Character>>> inputs = Arrays.asList(
                Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'C'), Arrays.asList('E', 'D'), Arrays.asList('E', 'B')),
                Arrays.asList(Arrays.asList('B', 'A'), Arrays.asList('C', 'A'), Arrays.asList('D', 'B'), Arrays.asList('E', 'B'), Arrays.asList('E', 'D'), Arrays.asList('E', 'C'), Arrays.asList('F', 'D'), Arrays.asList('F', 'E'), Arrays.asList('F', 'C')),
                Arrays.asList(Arrays.asList('A', 'B'), Arrays.asList('B', 'A')),
                Arrays.asList(Arrays.asList('B', 'C'), Arrays.asList('C', 'A'), Arrays.asList('A', 'F')),
                Arrays.asList(Arrays.asList('C', 'C'))
        );
        ArrayList<ArrayList<ArrayList<Character>>> dependencies = new ArrayList<>();
        for (int j = 0; j < inputs.size(); j++) {
            dependencies.add(new ArrayList<>());
            for (int k = 0; k < inputs.get(j).size(); k++) {
                dependencies.get(j).add(new ArrayList<>());
                for (int g = 0; g < inputs.get(j).get(k).size(); g++) {
                    dependencies.get(j).get(k).add(inputs.get(j).get(k).get(g));
                }
            }
        }
        for (int i = 0; i < dependencies.size(); i++) {
            System.out.println(i + 1 + ".\tdependencies: " + dependencies.get(i));
            System.out.println("\tCompilation Order: " + findCompilationOrder(dependencies.get(i)));
            System.out.println(repeat("-", 100));
        }

    }

    public static List<Character> findCompilationOrder(ArrayList<ArrayList<Character>> dependencies) {
        List<Character> result = new ArrayList<>();
        //Declare a graph adjacency list
        Map<Character, List<Character>> graph = new HashMap<>();
        //Declare a map for maintaining count for inDegree for each vertex(class)
        Map<Character, Integer> inDegree = new HashMap<>();
        //Form a basic graph structure
        for (ArrayList<Character> dependency : dependencies) {
            char parent = dependency.get(1);
            char child = dependency.get(0);
            graph.put(parent, new ArrayList<>());
            graph.put(child, new ArrayList<>());
            inDegree.put(parent, 0);
            inDegree.put(child, 0);
        }
        //Add dependencies to graph and inDegree count for each vertex to inDegree map
        for (ArrayList<Character> dependency : dependencies) {
            char parent = dependency.get(1);
            char child = dependency.get(0);
            graph.get(parent).add(child);
            inDegree.put(child, inDegree.get(child) + 1);
        }
        //Declare a queue for source of graph (A graph source can be a any vertex with zero inDegree count)
        Queue<Character> sources = new LinkedList<>();
        //Add to sources queue
        for (char key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) {
                sources.add(key);
            }
        }
        //Iterate while sources is not empty and add to result
        while (!sources.isEmpty()) {
            char vertex = sources.poll();
            result.add(vertex);
            for (char child : graph.get(vertex)) {
                //Decrement inDegree count when parent is added to result. If inDegree=0, add child to sources queue
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 0) {
                    sources.add(child);
                }
            }
        }
        //This check is important to check if there are any cycles in the graph.
        //If yes, the size won't be the same and no possible compilation order exist.
        if (result.size() != graph.size()) {
            return new ArrayList<>();
        }
        return result;
    }

    public static String repeat(String str, int pValue) {
        String out = "";
        for (int i = 0; i < pValue; i++) {
            out += str;
        }
        return out;
    }
}

