package com.nicolas.personna.nodes;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import com.nicolas.personna.db.AppDatabase;

import org.graphstream.graph.Graph;

public class NodesView  extends AndroidViewModel {
    private AppDatabase appDatabase;
    private Graph graph;
    public NodesView(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        Node node = new Node();
        graph = node.getPraph();
    }
}
