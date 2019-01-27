package com.nicolas.personna.addItem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;

import com.nicolas.personna.db.AppDatabase;
import com.nicolas.personna.db.PersonnaModel;


public class AddPersonnaViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;

    public AddPersonnaViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

    }

    public void addPersonna(final PersonnaModel personnaModel) {
        new addAsyncTask(appDatabase).execute(personnaModel);
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
