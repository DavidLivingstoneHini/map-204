package app;

import java.util.Scanner;

import app.algorithms.AStar;
import app.algorithms.Dijkstra;
import app.graph.Digraph;
import app.graph.Edge;
import app.graph.Graph;
import app.graph.Node;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Digraph graph = new Digraph();
        // Graph graph = new Graph();
        Node a = new Node("Great Hall");
        Node b = new Node("Commonwealth Hall");
        Node c = new Node("Balme Library");
        Node d = new Node("JQB");
        Node e = new Node("Main Gate");
        Node f = new Node("Banking Square");
        Node g = new Node("CC");
        Node h = new Node("Sarbah Field");
        Node i = new Node("Night Market");
        Node j = new Node("Diaspora");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);
        graph.addNode(h);
        graph.addNode(i);
        graph.addNode(j);

        graph.addEdge(new Edge(a, b, 1));
        graph.addEdge(new Edge(b, c, 1));
        graph.addEdge(new Edge(c, d, 2));

        graph.addEdge(new Edge(e, d, 1));
        graph.addEdge(new Edge(d, e, 1));
        graph.addEdge(new Edge(e, f, 3));
        graph.addEdge(new Edge(f, e, 3));

        graph.addEdge(new Edge(b, h, 2));
        graph.addEdge(new Edge(h, b, 2));
        graph.addEdge(new Edge(b, g, 1));
        graph.addEdge(new Edge(g, b, 1));
        graph.addEdge(new Edge(c, g, 2));
        graph.addEdge(new Edge(g, c, 2));

        graph.addEdge(new Edge(g, f, 3));
        graph.addEdge(new Edge(f, g, 3));
        graph.addEdge(new Edge(g, h, 2));
        graph.addEdge(new Edge(h, g, 2));

        graph.addEdge(new Edge(h, i, 3));
        graph.addEdge(new Edge(i, h, 3));
        graph.addEdge(new Edge(f, i, 1));
        graph.addEdge(new Edge(i, f, 1));

        graph.addEdge(new Edge(i, j, 2));
        graph.addEdge(new Edge(j, i, 2));

        System.out.println("Please choose your current location:");
        graph.listPlaces(null);

        String place = scanner.nextLine();
        Node source = graph.getNodeByName(place);

        System.out.println("\nPlease choose your destination:");
        String place2 = scanner.nextLine();
        Node destination = graph.getNodeByName(place2);
        Dijkstra.findShortestPath(graph, source, destination);

        // AStar.findShortestPath(graph, a,f);
    }
}