package com.digerati.upmap.algorithms;

import com.digerati.upmap.graph.Edge;
import com.digerati.upmap.graph.Graph;
import com.digerati.upmap.graph.Node;

import java.util.*;
import java.util.AbstractMap.SimpleEntry;

public class AStar {

    public static List<Node> findFastestPath(Graph graph, Node source, Node destination) {
        // A map ofa node and the previous node to reach it. Used later to reconstruct the min path.
        PriorityQueue<SimpleEntry<Node, Double>> OPEN_SET = new PriorityQueue<>(Comparator.comparing(SimpleEntry::getValue));
        // Just to keep track of the content of OPEN_SET.
        ArrayList<Node> OPEN_SET_HASH = new ArrayList<>();
        // A map of a node and the previous node to reach it. Used later to reconstruct the min path.
        HashMap<Node, Node> CAME_FROM = new HashMap<>();
        HashMap<Node, Double> G_SCORE = new HashMap<>();
        HashMap<Node, Double> F_SCORE = new HashMap<>();

        for (Node node :
                graph.getNodes()) {
            G_SCORE.put(node, Double.MAX_VALUE);
            F_SCORE.put(node, Double.MAX_VALUE);
        }
        G_SCORE.put(source, 0d);
        F_SCORE.put(source, heuristic(source, destination));

        // Have explored the source node: Add to the sets.
        OPEN_SET.add(new SimpleEntry<>(source, 0d));
        OPEN_SET_HASH.add(source);

        while (OPEN_SET.size() > 0) {
            SimpleEntry<Node, Double> minSet = OPEN_SET.poll();

            Node current = minSet.getKey();
            if (current == destination) {
                // We've found the destination
                return reconstructPath(CAME_FROM, current);
            }
            OPEN_SET.remove(minSet);
            OPEN_SET_HASH.remove(current);

            // Explore all the neighbours of this node.
            for (Edge edge :
                    graph.getDestinationEdges(current)) {
                double tentative_gScore = G_SCORE.get(current) + edge.getTime();
                Node neighbour = edge.getDestination();

                if (tentative_gScore < G_SCORE.get(neighbour)){
                    // We've got a better score. Let's record it.
                    CAME_FROM.put(neighbour, current);
                    G_SCORE.put(neighbour, tentative_gScore);
                    F_SCORE.put(neighbour, G_SCORE.get(neighbour) + heuristic(neighbour, destination));

                    if (!OPEN_SET_HASH.contains(neighbour)) {
                        OPEN_SET.add(new SimpleEntry<>(neighbour, F_SCORE.get(neighbour)));
                        OPEN_SET_HASH.add(neighbour);
                    }
                }
            }
        }
        return null;
    }

    private static List<Node> reconstructPath(HashMap<Node, Node> cameFrom, Node current) {
        List<Node> path = new ArrayList<>();
        path.add(current);
        while (cameFrom.containsKey(current)){
            current = cameFrom.get(current);
            path.add(current);
        }

        // Reverse the path order
        List<Node> result = new ArrayList<>();
        for (int i = path.size() - 1; i >= 0 ; i--) {
            result.add(path.get(i));
        }
        return result;
    }

    private static double heuristic(Node source, Node destination) {
        return 1;
    }
}
