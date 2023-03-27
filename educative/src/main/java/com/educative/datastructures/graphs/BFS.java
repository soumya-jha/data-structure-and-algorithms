package com.educative.datastructures.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        //System.out.println("Graph1:");
        //g.printGraph();
        //System.out.println("BFS traversal of Graph1 : " + bfs(g));
        //System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
    }
    public static String bfs(Graph g) {
        if(g.vertices==0){
            return "";
        }
        String result = "";
        //|V|=5, E:[(0,1)(1,2)(2,3)(2,4)(4,2)]
        boolean[] visited = new boolean[g.vertices];
        for(int i = 0; i<g.vertices; i++){
           if(!visited[i]){
               result+=traverse(g,i,visited);
           }
        }
        return result;
    }

    private static String traverse(Graph g, int source, boolean[] visited){
        String result = "";
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        visited[source] = true;
        //|V|=5, E:[(0,1)(1,2)(2,3)(2,4)(4,2)]
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            result+=String.valueOf(currNode);
            DoublyLinkedList<Integer>.Node temp = null;
            DoublyLinkedList<Integer> dl = g.adjacencyList[currNode];
            if(dl!=null){
                temp = dl.headNode;
                while(temp!=null){
                    if(!visited[temp.data]){
                        queue.add(temp.data);
                        visited[temp.data] = true;
                    }
                    temp = temp.nextNode;
                }
            }
        }
        return result;
    }
}
