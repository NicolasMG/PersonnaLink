package com.nicolas.personna.addItem;

import android.app.DatePickerDialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
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
import com.nicolas.personna.db.PersonnaModel;

import java.util.Calendar;
import java.util.Date;

public class AddPersonna extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    private Date date;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar;

    private EditText itemEditText;
    private EditText nameEditText;
    private RadioGroup rg1;
    private RadioButton rb1;

    private AddPersonnaViewModel addPersonnaViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        itemEditText = findViewById(R.id.itemName);
        nameEditText = findViewById(R.id.personName);
        rg1 = (RadioGroup) findViewById(R.id.radioGroup);

        calendar = Calendar.getInstance();
        addPersonnaViewModel = ViewModelProviders.of(this).get(AddPersonnaViewModel.class);

        datePickerDialog = new DatePickerDialog(this, AddPersonna.this, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = rg1.getCheckedRadioButtonId();
                rb1 = (RadioButton)findViewById(selected);
                if (itemEditText.getText() == null || nameEditText.getText() == null || date == null)
                    Toast.makeText(AddPersonna.this, "Missing fields", Toast.LENGTH_SHORT).show();
                else {
                    addPersonnaViewModel.addPersonna(new PersonnaModel(
                            itemEditText.getText().toString(),
                            nameEditText.getText().toString(),
                            date,
                           (String) rb1.getText()
                    ));
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
