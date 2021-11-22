package app.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import static app.utils.Functions.*;


public class Digraph {
    protected final HashMap<Node, ArrayList<Node>> GRAPH = new HashMap<>();
    protected final ArrayList<Edge> EDGES = new ArrayList<>();
    private int nodeSize = 0;

    public void addNode(Node node){
        if (!GRAPH.containsKey(node)){
            GRAPH.put(node, new ArrayList<>());
            nodeSize++;
        }
    }

    public void addEdge(Edge edge){
        if(EDGES.contains(edge)) return;

        this.EDGES.add(edge);
        for(Node source : GRAPH.keySet()){
            if (source == edge.getSource()){
                GRAPH.get(source).add(edge.getDestination());
            }
        }
    }

    public ArrayList<Edge> getDestinationEdges(Node source){
        ArrayList<Edge> destinations = new ArrayList<>();
        for (Edge edge: this.EDGES){
            if (edge.getSource() == source){
                 destinations.add(edge);
            }
        }
        return destinations;
    }

    public Edge getEdge(Node source, Node destination) {
       for (Edge edge: this.EDGES){
           if (edge.getSource() == source && edge.getDestination() == destination){
               return edge;
           }
       }
       return null;
    }

    public Node getNodeByName(String name){
        for(Node node : GRAPH.keySet()){
            if (node.getName().toLowerCase().equals(name.toLowerCase())){
                return node;
            }
        }
        return null;
    }

    public Set<Node> getNodes(){
        return this.GRAPH.keySet();
    }

    public int getNodeSize() {
        return nodeSize;
    }

    public void printGraph(){
        println("\n          GRAPH: ADJACENCY LIST                ");
        println("              PLACES ON CAMPUS                 \n");
        for (HashMap.Entry<Node, ArrayList<Node>> entry : GRAPH.entrySet()) {
            Node node = entry.getKey();
            ArrayList<Node> destinations = entry.getValue();
            StringBuilder builder = new StringBuilder();
            builder.append("[");
            boolean emptyList = true;
            for (Node destinatnion : destinations){
                if(emptyList)
                builder.append(destinatnion.getName());
                else
                builder.append(", "+destinatnion.getName());
                emptyList = false;
            }
            builder.append("]");
            println(node.getName() + "-->" + builder.toString());
            println("");
        }
    }

    public void listPlaces(Node except){
        int index = 1;
        for(Node node : GRAPH.keySet()){
            if (node != except){
                println(index + ". " + node.getName());
            }
            index++;
        }
    }

}
