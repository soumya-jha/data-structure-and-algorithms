package com.educative.datastructures.graphs;

import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("DFS traversal of Graph1 : " + dfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(4,3);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("DFS traversal of Graph2 : " + dfs(g2));
    }

    public static String dfs(Graph g) {
        if(g.vertices==0){
            return "";
        }
        String result = "";
        boolean[] visited = new boolean[g.vertices];
        for(int i=0; i<g.vertices;i++){
            if(!visited[i]){
                result+=traverse(g, i , visited);
            }
        }
        return result;
    }

    private static String traverse(Graph g, int source, boolean[] visited){
        String result = "";
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        //|V|=5, E:[(0,1)(0,2)(1,3)(1,4)],
        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            visited[currentNode] = true;
            result+=String.valueOf(currentNode);

            DoublyLinkedList<Integer>.Node temp = null;
            DoublyLinkedList<Integer> dl = g.adjacencyList[currentNode];
            if(dl!=null) {
                temp = dl.headNode;
                while (temp != null) {
                    if(!visited[temp.data]){
                        stack.push(temp.data);
                    }
                    temp = temp.nextNode;
                }
            }
            //visited[currentNode] = true;
        }
        return result;
    }
}
