package com.digerati.upmap.algorithms;

import com.digerati.upmap.graph.Graph;
import com.digerati.upmap.graph.Node;

import java.util.ArrayList;

public class DFS {
    public static ArrayList<ArrayList<Node>> ALL_PATHS = new ArrayList<>();

    public static void dfs(Graph graph, Node source, Node destination, ArrayList<Node> visited, ArrayList<Node> path){
        if (source == destination) {
            ALL_PATHS.add(new ArrayList<>(path));
            return;
        }

        visited.add(source);

        for (Node node :
                graph.getNeighbourNodes(source)) {
            if (!visited.contains(node)){
                // store current node
                path.add(node);

                dfs(graph, source, destination, visited, path);
                path.remove(node);
            }
        }
        // Mark the current node
        visited.remove(source);
    }

    public static ArrayList<ArrayList<Node>> findAllPaths(Graph graph, Node source, Node destination){
        ArrayList<Node> visited = new ArrayList<>();
        ArrayList<Node> path = new ArrayList<>();
        ALL_PATHS = new ArrayList<>();
        path.add(source);
        dfs(graph, source, destination, visited, path);
        return ALL_PATHS;
    }
}
