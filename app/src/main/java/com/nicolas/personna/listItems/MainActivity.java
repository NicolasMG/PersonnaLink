package com.nicolas.personna.listItems;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.nicolas.personna.ModifPersonna.ModifPersonna;
import com.nicolas.personna.R;
import com.nicolas.personna.addItem.AddPersonna;
import com.nicolas.personna.db.PersonnaModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener {

    private PersonnaListViewModel viewModel;
    private RecyclerViewAdapter recyclerViewAdapter;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getBaseContext().deleteDatabase("personna_db");

        setContentView(R.layout.activity_main);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AddPersonna.class));
            }
        });


        recyclerView = findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(new ArrayList<PersonnaModel>(), this, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(recyclerViewAdapter);

        viewModel = ViewModelProviders.of(this).get(PersonnaListViewModel.class);

        viewModel.getItemAndPersonList().observe(MainActivity.this, new Observer<List<PersonnaModel>>() {
            @Override
            public void onChanged(@Nullable List<PersonnaModel> itemAndPeople) {
                recyclerViewAdapter.addItems(itemAndPeople);
            }
        });

    }

    @Override
    public boolean onLongClick(View v) {
        PersonnaModel personnaModel = (PersonnaModel) v.getTag();
        viewModel.deleteItem(personnaModel);
        return true;
    }

    @Override
    public void onClick(View v) {
        PersonnaModel personnaModel = (PersonnaModel) v.getTag();
        startActivity(new Intent(MainActivity.this, ModifPersonna.class)
                .putExtra("PersonnaID",personnaModel.id)
        );
    }
}
