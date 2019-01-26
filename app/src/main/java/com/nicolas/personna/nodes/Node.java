package com.nicolas.personna.nodes;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


public class Node {
    private Graph graph;

    public Node(){
        Graph graph = new SingleGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");

        this.graph = graph;
    }

    public Graph getPraph() {
        return graph;
    }
}
