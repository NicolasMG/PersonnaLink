package com.nicolas.personna.nodes;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.nicolas.personna.R;

import org.graphstream.graph.Graph;
import org.graphstream.ui.android_viewer.AndroidViewer;
import org.graphstream.ui.android_viewer.DefaultView;
import org.graphstream.ui.android_viewer.util.DefaultFragment;
import org.graphstream.ui.graphicGraph.GraphicGraph;
public class NodeViewer extends AppCompatActivity {

    private DefaultView nodesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes_visualisation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Node node = new Node();
        GraphicGraph graph = node.getGraph();
        AndroidViewer androidViewer = new AndroidViewer(graph);

        nodesView = findViewById(R.id.viewgraph);
        nodesView.display(graph,true);
        androidViewer.getDefaultView();

    }



        protected void NodeViewer(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes_visualisation);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Node node = new Node();
        GraphicGraph graph = node.getGraph();
        AndroidViewer androidViewer = new AndroidViewer(graph);

        nodesView = findViewById(R.id.viewgraph);
        nodesView.display(graph,true);
        androidViewer.getDefaultView();
    }


}
