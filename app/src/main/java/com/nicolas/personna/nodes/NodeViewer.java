package com.nicolas.personna.nodes;

import android.annotation.SuppressLint;
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
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.Viewer.ThreadingModel;

import static org.graphstream.ui.android_viewer.util.DefaultFragment.autoLayout;

public class NodeViewer extends AppCompatActivity {

    private View view;
    private DefaultView defaultView;
    private DefaultFragment fragment;
    @SuppressLint("WrongViewCast")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes_visualisation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Node node = new Node();
        GraphicGraph graph = node.getGraph();
        AndroidViewer androidViewer = new AndroidViewer(graph);


        if (savedInstanceState == null) {
            FragmentManager fm = getFragmentManager();

            // find fragment or create him
            fragment = (DefaultFragment) fm.findFragmentByTag("fragment_tag");
            if (null == fragment) {
                fragment = new DefaultFragment();
                fragment.init(graph, autoLayout);
            }

            // Add the fragment in the layout and commit
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(CONTENT_VIEW_ID, fragment).commit();
        }

    }


/*
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
*/

}
