package com.nicolas.personna.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

@Entity
public class PersonnaModel {

    @PrimaryKey(autoGenerate = true)
    public int id;
    private String itemName;
    private String personName;
    private String sexe; // 1 : homme, 2 : femme
    @TypeConverters(DateConverter.class)
    private Date personnaDate;
/*
    public PersonnaModel(String itemName, String personName, Date personnaDate) {
        this.itemName = itemName;
        this.personName = personName;
        this.personnaDate = personnaDate;
    }*/

    public PersonnaModel(String itemName, String personName, Date personnaDate, String sexe) {
        this.itemName = itemName;
        this.personName = personName;
        this.personnaDate = personnaDate;
        this.sexe = sexe;
    }

    public String getItemName() {
        return itemName;
    }

    public String getPersonName() {
        return personName;
    }

    public Date getPersonnaDate() {
        return personnaDate;
    }

    public String getSexe() {
        return sexe;
    }
}
