package com.nicolas.personna.ModifPersonna;


import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.nicolas.personna.addItem.AddPersonnaViewModel;
import com.nicolas.personna.db.AppDatabase;
import com.nicolas.personna.db.PersonnaModel;
import com.nicolas.personna.listItems.PersonnaListViewModel;

import java.util.List;

public class ModifPersonnaViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public ModifPersonnaViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addPersonna(final PersonnaModel personnaModel) {
        new ModifPersonnaViewModel.addAsyncTask(appDatabase).execute(personnaModel);
    }

    private static class addAsyncTask extends AsyncTask<PersonnaModel, Void, Void> {

        private AppDatabase db;

        addAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final PersonnaModel... params) {
            db.itemAndPersonModel().addPersonna(params[0]);
            return null;
        }

    }
}
