package org.techinterviewhandbook.grind75;

import java.util.Arrays;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Node[] visited = new Node[101];
        Arrays.fill(visited, null);
        Node copyNode = new Node(node.val);
        dfs(node, copyNode, visited);
        return copyNode;
    }

    private void dfs(Node node, Node copyNode, Node[] visited) {
        visited[copyNode.val] = copyNode;
        for (Node neighbor : node.neighbors) {
            if (visited[neighbor.val] == null) {
                Node newNode = new Node(neighbor.val);
                copyNode.neighbors.add(newNode);
                dfs(neighbor, newNode, visited);
            } else {
                copyNode.neighbors.add(visited[neighbor.val]);
            }
        }
    }
}
