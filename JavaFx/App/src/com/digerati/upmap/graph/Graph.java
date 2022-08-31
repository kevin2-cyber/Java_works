package com.digerati.upmap.graph;

import java.util.*;

public class Graph {
    protected final HashMap<Node, ArrayList<Node>> GRAPH = new HashMap<>();
    protected final ArrayList<Edge> EDGES = new ArrayList<>();
    private int nodeSize = 0;

    public void addNode(Node node) {
        if (!GRAPH.containsKey(node)) {
            GRAPH.put(node, new ArrayList<>());
            nodeSize++;
        }
    }

    public void addEdge(Edge edge) {
        addNode(edge.getDestination());
        addNode(edge.getSource());

        if (EDGES.contains(edge)) return;

        this.EDGES.add(edge);
        Edge newEdge = edge.clone();
        newEdge.setSource(edge.getDestination());
        newEdge.setDestination(edge.getSource());
        this.EDGES.add(newEdge);
        for (Node node :
                GRAPH.keySet()) {
            if (node == edge.getSource()) {
                GRAPH.get(node).add(edge.getDestination());
            }
        }


        for (Node node :
                GRAPH.keySet()) {
            if (node == edge.getDestination()) {
                GRAPH.get(node).add(edge.getSource());
            }
        }
    }

    public int calculateDistance(ArrayList<Node> nodes) {
        int distance = 0;
        for (int i = 0; i < nodes.size() -1; i++) {
            Edge edge = getEdge(nodes.get(i), nodes.get(i));
            distance += edge.getDistance();
        }
        return distance;
    }

    public List<String> getLandmarks(ArrayList<Node> nodes) {
        List<String> landmarks = new ArrayList<>();
        for (int i = 0; i < nodes.size(); i++) {
            Edge edge = getEdge(nodes.get(i), nodes.get(i + 1));
            if (!edge.getLandmarks().isEmpty()) {
                landmarks.add(edge.getLandmarks());
            }
        }
        return landmarks;
    }

    public List<Edge> findEdgesWithLandmark(String landmark){
        List<Edge> edges = new ArrayList<>();
        for (Edge edge :
                this.EDGES) {
            if (edge.getLandmarks().toLowerCase().contains(landmark.toLowerCase())) {
                edges.add(edge);
            }
        }
        return edges;
    }

    public ArrayList<Edge> getDestinationEdges(Node source) {
        ArrayList<Edge> destinations = new ArrayList<>();
        for (Edge edge :
                this.EDGES) {
            if (edge.getSource() == source) {
                destinations.add(edge);
            }
        }
        return destinations;
    }

    public ArrayList<Node> getNeighbourNodes(Node source) {
        return GRAPH.get(source);
    }

    public Edge getEdge(Node source, Node destination) {
        for (Edge edge :
                this.EDGES) {
            if (edge.getSource() == source && edge.getDestination() == destination) {
                return edge;
            }
        }
        return null;
    }

    public Node getNodeByName(String name) {
        for (Node node :
                GRAPH.keySet()) {
            if (node.getName().equals(name.toLowerCase())) {
                return node;
            }
        }
        return null;
    }

    public Set<Node> getNodes() {
        return this.GRAPH.keySet();
    }
    
    public int getNodeSize() {
        return nodeSize;
    }
    
    public void printGraph() {
        System.out.println("\n       GRAPH: ADJACENCY LIST       ");
        System.out.println("          PLACES PN CAMPUS            ");
        for (Map.Entry<Node, ArrayList<Node>> entry :
                GRAPH.entrySet()) {
            Node node = entry.getKey();
            ArrayList<Node> destinations = entry.getValue();
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            boolean emptyList = true;
            for (Node destination :
                    destinations) {
                if (emptyList) {
                    builder.append(destination.getName());
                } else {
                    builder.append(", " + destination.getName());
                }
                emptyList = false;
            }
            builder.append("]");
            System.out.println(node.getName() + "-->" + builder);
            System.out.println("");
        }
    }

    public void listPlaces(Node except) {
        int index = 1;
        for (Node node :
                GRAPH.keySet()) {
            if (node != except) {
                System.out.println(index + ". " + node.getName());
            }
            index++;
        }
    }
}