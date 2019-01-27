package com.nicolas.personna.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
@TypeConverters(DateConverter.class)
public interface PersonnaModelDao {

    @Query("select * from PersonnaModel")
    LiveData<List<PersonnaModel>> getAllPersonnaItems();

    @Query("select * from PersonnaModel where id = :id")
    LiveData<PersonnaModel> getItembyId(String id);

@Insert(onConflict = REPLACE)
    void addPersonna(PersonnaModel personnaModel);

@Delete
    void deletePersonna(PersonnaModel personnaModel);

@Update
    void editPersonna(PersonnaModel param);
            }
