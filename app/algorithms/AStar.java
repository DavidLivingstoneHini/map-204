package app.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.AbstractMap.SimpleEntry;

import app.graph.Digraph;
import app.graph.Edge;
import app.graph.Node;

public class AStar {
    // A map of a node and the previous node to reach it. Used later to reconstruct
    // the min path.
    private static final PriorityQueue<SimpleEntry<Node, Integer>> OPEN_SET = new PriorityQueue<>(
            (first, second) -> first.getValue().compareTo(second.getValue()));
    // Just to keep track of the content of OPEN_SET.
    private static final ArrayList<Node> OPEN_SET_HASH = new ArrayList<>();
    // A map of a node and the previous node to reach it. Used later to reconstruct
    // the min path.
    private static final HashMap<Node, Node> CAME_FROM = new HashMap<>();
    private static final HashMap<Node, Integer> G_SCORE = new HashMap<>();
    private static final HashMap<Node, Integer> F_SCORE = new HashMap<>();

    public static void findShortestPath(Digraph graph, Node source, Node destination) {
        for (Node node : graph.getNodes()) {
            G_SCORE.put(node, Integer.MAX_VALUE);
            F_SCORE.put(node, Integer.MAX_VALUE);
        }
        G_SCORE.put(source, 0);
        F_SCORE.put(source, heuristic(source, destination));

        // Have explored the source node: Add to the sets.
        OPEN_SET.add(new SimpleEntry<>(source, 0));
        OPEN_SET_HASH.add(source);

        while (OPEN_SET.size() > 0) {
            SimpleEntry<Node, Integer> minSet = OPEN_SET.poll();

            Node current = minSet.getKey();
            if (current == destination) {
                // We've found the destination.
                reconstructPath(CAME_FROM, current);
                return;
            }
            OPEN_SET.remove(minSet);
            OPEN_SET_HASH.remove(current);

            // Explore all the neighbours of this node.
            for (Edge edge : graph.getDestinationEdges(current)) {
                int tentative_gScore = G_SCORE.get(current) + edge.getDistance();
                Node neighbour = edge.getDestination();

                if (tentative_gScore < G_SCORE.get(neighbour)) {
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
    }

    private static void reconstructPath(HashMap<Node, Node> cameFrom, Node current) {
        System.out.println(current.getName());
        while (cameFrom.containsKey(current)) {
            current = cameFrom.get(current);
            System.out.println(current.getName());
        }
    }

    private static int heuristic(Node source, Node destination) {
        return 1;
    }

}
