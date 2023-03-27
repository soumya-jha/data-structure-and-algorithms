package com.educative.datastructures.graphs;

import java.util.Stack;

public class MotherVertex {

    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(3,0);
        g.addEdge(3,1);
        g.printGraph();
        System.out.println("Mother Vertex is: " + findMotherVertex(g));
    }
    public static int findMotherVertex(Graph g){
        if(g.vertices==0){
            return -1;
        }
        boolean[] visited = new boolean[g.vertices];
        boolean[] connected;
        int motherVertex = -1;
        for(int i=0; i<g.vertices; i++){
            if(!visited[i]){
                motherVertex = i;
                connected = new boolean[g.vertices];
                traverse(g, i, visited, connected);
                for(int j=0; j<g.vertices;j++){
                    if(!connected[j]){
                        motherVertex = -1;
                        break;
                    }
                }
            }
        }
        return motherVertex;
    }

    //findMotherVertex(0->1->2 ,3->0, 3->1)
    public static void traverse(Graph g, int source, boolean[] visited, boolean[] connected){
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        while(!stack.isEmpty()){
            int currentNode = stack.pop();
            if(!connected[currentNode]){
                DoublyLinkedList<Integer>.Node temp = null;
                DoublyLinkedList<Integer> dl =g.adjacencyList[currentNode];
                if(dl!=null){
                    temp = dl.headNode;
                    while(temp!=null){
                        if(!connected[temp.data]){
                            stack.push(temp.data);
                        }
                        temp = temp.nextNode;
                    }
                }
                visited[currentNode] = true;
                connected[currentNode] = true;
            }
        }
    }
}
