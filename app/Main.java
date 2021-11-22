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
        Node a = new Node("Main Gate");
        Node b = new Node("Balme Library");
        Node c = new Node("Commonwealth Hall");
        Node d = new Node("Great Hall");
        Node e = new Node("Night Market");
        Node f = new Node("CC");
        Node g = new Node("Diaspora");

        graph.addNode(a);
        graph.addNode(b);
        graph.addNode(c);
        graph.addNode(d);
        graph.addNode(e);
        graph.addNode(f);
        graph.addNode(g);

        graph.addEdge(new Edge(a, b, 3));
        graph.addEdge(new Edge(a, c, 8));
        graph.addEdge(new Edge(a, g, 11));

        graph.addEdge(new Edge(b, d, 22));
        graph.addEdge(new Edge(b, c, 3));

        graph.addEdge(new Edge(c, d, 1));
        graph.addEdge(new Edge(c, e, 7));

        graph.addEdge(new Edge(d, f, 7));
        graph.addEdge(new Edge(d, e, 9));

        graph.addEdge(new Edge(e, f, 5));
        graph.addEdge(new Edge(e, g, 1));
        graph.addEdge(new Edge(g, e, 1));

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