package app.graph;

public class Graph extends Digraph {
    
    @Override
    public void addEdge(Edge edge){
        if(EDGES.contains(edge)) return;

        this.EDGES.add(edge);
        this.EDGES.add(new Edge(edge.getDestination(), edge.getSource(), edge.getDistance()));
        for(Node node : GRAPH.keySet()){
            if (node == edge.getSource()){
                GRAPH.get(node).add(edge.getDestination());
            }
        } 

        for(Node node : GRAPH.keySet()){
            if (node == edge.getDestination()){
                GRAPH.get(node).add(edge.getSource());
            }
        } 
    }
}
