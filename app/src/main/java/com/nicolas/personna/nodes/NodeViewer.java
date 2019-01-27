package com.nicolas.personna.nodes;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.nicolas.personna.R;

import org.graphstream.ui.android_viewer.AndroidViewer;
import org.graphstream.ui.graphicGraph.GraphicGraph;

public class NodeViewer extends AppCompatActivity {

    protected void NodeViewer(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nodes_visualisation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
