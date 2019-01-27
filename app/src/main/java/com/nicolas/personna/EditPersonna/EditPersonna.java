package com.nicolas.personna.EditPersonna;


import android.app.DatePickerDialog;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.nicolas.personna.R;
import com.nicolas.personna.addItem.AddPersonnaViewModel;
import com.nicolas.personna.db.AppDatabase;
import com.nicolas.personna.db.PersonnaModel;

import java.util.Calendar;
import java.util.Date;

public class EditPersonna extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Date date;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    private EditText itemEditText;
    private EditText nameEditText;
    private RadioGroup rg1;
    private RadioButton rb1;


    private PersonnaModel personnaModel;

    private EditPersonnaViewModel editPersonnaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String idPersonna = getIntent().getStringExtra("PersonnaID");
        personnaModel = (PersonnaModel) getIntent().getSerializableExtra("PersonnaModel");
        setContentView(R.layout.activity_edit);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        itemEditText = findViewById(R.id.itemName);
        nameEditText = findViewById(R.id.personName);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);

        itemEditText.setText(personnaModel.getItemName());
        nameEditText.setText(personnaModel.getPersonName());
        calendar = Calendar.getInstance();

        editPersonnaViewModel = ViewModelProviders.of(this,new editPersonnaViewModelFactory(this.getApplication(), Integer.toString(personnaModel.id))).get(EditPersonnaViewModel.class);

        calendar.setTime(personnaModel.getPersonnaDate());
        datePickerDialog = new DatePickerDialog(this, EditPersonna.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        if(personnaModel.getSexe().equals("Femme")){
            ((RadioButton)rg1.getChildAt(1)).setChecked(true);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rg1.getCheckedRadioButtonId();
                rb1 = (RadioButton)findViewById(selected);
                if (itemEditText.getText() == null || nameEditText.getText() == null)
                    Toast.makeText(EditPersonna.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    personnaModel.setItemName(itemEditText.getText().toString());
                    personnaModel.setPersonName(nameEditText.getText().toString());
                    if(!(date == null)) {
                        personnaModel.setPersonnaDate(date);
                    }
                    personnaModel.setSexe((String) rb1.getText());

                    editPersonnaViewModel.editPersonna(personnaModel);
                    finish();
                }
            }
        });


        findViewById(R.id.dateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog.show();
            }
        });
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        date = calendar.getTime();

    }


}
