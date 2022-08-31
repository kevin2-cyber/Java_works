package com.digerati.upmap.graph;

import java.util.Collection;

public class Edge implements Comparable<Edge>, Cloneable{
    private Node source;
    private Node destination;
    private int time;
    private double distance;
    private String landMarks;

    public Edge(Node source, Node destination, double distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = -1;
        this.landMarks = "";
    }

    public Edge(Node source, Node destination, int time, double distance) {
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.distance = distance;
        this.landMarks = "";
    }

    public Edge(Node source, Node destination, int time, double distance, String landMarks) {
        this.source = source;
        this.destination = destination;
        this.time = time;
        this.distance = distance;
        this.landMarks = landMarks;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }

    public int getTime() {
        return time;
    }

    public String getLandmarks() {
        return this.landMarks;
    }

    public double getDistance() {
        return distance;
    }

    @Override
    public String toString() {
        return source.getName() + " -> " + destination.getName() + " " + getDistance();
    }

    @Override
    public int compareTo(Edge other) {
        if (getDistance() > other.getDistance())
            return 1;
        else if (getDistance() < other.getDistance())
            return -1;
        return 0;
    }


    protected Edge clone() {
        try {
            return (Edge) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
