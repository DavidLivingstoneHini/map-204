package app.graph;

import java.util.ArrayList;

public class Edge implements Comparable<Edge> {
    private Node source;
    private Node destination;
    private long time;
    private int distance;
    private ArrayList<String> landMarks = new ArrayList<>();

    public Edge(Node source, Node destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = -1;
    }

    public Edge(Node source, Node destination, int distance, long time) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
        this.time = time;
    }

    public Node getDestination() {
        return destination;
    }

    public ArrayList<String> getLandMarksNode() {
        return landMarks;
    }

    public Node getSource() {
        return source;
    }

    public int getDistance() {
        return distance;
    }

    public long getTime() {
        return time;
    }

    @Override
    public String toString() {
        return source.getName() + " --> " + destination.getName() + " " + getDistance();
    }

    @Override
    public int compareTo(Edge other) {
        if (getDistance() > other.getDistance())
            return 1;
        else if (getDistance() < other.getDistance())
            return -1;
        return 0;
    }

}
