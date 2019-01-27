package com.nicolas.personna.nodes;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.nicolas.personna.db.AppDatabase;

import org.graphstream.graph.Graph;
import org.graphstream.ui.android_viewer.AndroidViewer;
import org.graphstream.ui.android_viewer.DefaultView;
import org.graphstream.ui.graphicGraph.GraphicGraph;

public class NodesView {

    private AppDatabase appDatabase;
    private GraphicGraph graph;

    public NodesView() {
        Node node = new Node();
        graph = node.getGraph();

        AndroidViewer androidViewer = new AndroidViewer(graph);

    }
}
