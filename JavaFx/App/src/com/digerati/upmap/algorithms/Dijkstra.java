package com.digerati.upmap.algorithms;

import com.digerati.upmap.graph.Edge;
import com.digerati.upmap.graph.Graph;
import com.digerati.upmap.graph.Node;

import java.util.ArrayList;
import java.util.HashMap;

public class Dijkstra {
    //Track all unvisited nodes in the graph.
    private static ArrayList<Node> UNVISITED = new ArrayList<>();

    // A map of each node and the min cost/distance to each.
    private static HashMap<Node, Double> DISTANCE_MAP = new HashMap<>();

    // A map of a node and the previous node to reach it. Used later to construct the min path.
    private static HashMap<Node, Node> PREVIOUS_NODE = new HashMap<>();

    public static ArrayList<Node> findShortestPath(Graph graph, Node source, Node destination){

        if (source == destination){
            ArrayList<Node> path = new ArrayList<>();
            path.add(source);
            return path;
        }

        // Set the cost to reach each node to infinity
        for (Node node :
                graph.getNodes()) {
            DISTANCE_MAP.put(node, Double.MAX_VALUE);
            PREVIOUS_NODE.put(node, null);
            UNVISITED.add(node);
        }

        // Set the cost to reach the source node to zero
        DISTANCE_MAP.put(source, 0d);

        // Find the node with the least distance to reach
        Node minNode = findVertexWithMinDist();
        while (UNVISITED.size() > 0 && minNode != null){
            // Find the node with the least distance to reach.
            minNode = findVertexWithMinDist();

            // Mark this node as visited
            UNVISITED.remove(minNode);

            // Explore all the neighbours of this node.
            ArrayList<Edge> edges = graph.getDestinationEdges(minNode);
            for (Edge edge :
                    edges) {
                // Checking for cycles: i.e. , if we have not already visited this node.
                if (UNVISITED.contains(edge.getDestination())) {

                    // Calculate alternative cost
                    double alt = DISTANCE_MAP.get(minNode) + edge.getDistance();

                    if (alt < DISTANCE_MAP.get(edge.getDestination())){// If the alternative cost is smaller than the current cost
                        // Update the min cost to reach this node
                        DISTANCE_MAP.put(edge.getDestination(), alt);

                        // Update the previous node to reach this current node
                        PREVIOUS_NODE.put(edge.getDestination(), minNode);
                    }
                }
            }
        }
        return getShortestPath(source, destination);
    }

    public static String getDistance(Node destination) {
        if (DISTANCE_MAP.get(destination) >= Double.MAX_VALUE) return "0 km";
        return String.format("%.f", DISTANCE_MAP.get(destination)/1000f) + "km \n";
    }

    private static ArrayList<Node> getShortestPath(Node source, Node destination){
        ArrayList<Node> path = new ArrayList<>();
        while (PREVIOUS_NODE.get(destination) != null){
            path.add(0, destination);
            destination = PREVIOUS_NODE.get(destination);
        }
        path.add(0, source);
        return path;
    }

    private static Node findVertexWithMinDist(){
        // Linear search for the min cost node based on the distance.
        Node minNode = null;
        double minDistance = Double.MAX_VALUE;
        for (HashMap.Entry<Node, Double> entry :
                DISTANCE_MAP.entrySet()) {
            Node node = entry.getKey();
            double distance = entry.getValue();
            if (UNVISITED.contains(node) && distance < minDistance) {
                minDistance = distance;
                minNode = node;
            }
        }
        return minNode;
    }
}
