package com.nicolas.personna.nodes;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.graphicGraph.GraphicGraph;


public class Node {
    private GraphicGraph graph;

    //creer le graph
    public Node(){
        GraphicGraph graph = new GraphicGraph("Tutorial 1");

        graph.addNode("A");
        graph.addNode("B");
        graph.addNode("C");
        graph.addEdge("AB", "A", "B");
        graph.addEdge("BC", "B", "C");
        graph.addEdge("CA", "C", "A");
        this.graph = graph;
        /*
            graph.setStrict(false);
            graph.setAutoCreate( true );
            graph.addEdge( "AB", "A", "B" );
            graph.addEdge( "BC", "B", "C" );
            graph.addEdge( "CA", "C", "A" );
         */

    }

public GraphicGraph getGraph() {
        return graph;
        }
        }
