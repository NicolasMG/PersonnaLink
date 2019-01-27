package com.nicolas.personna.EditPersonna;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.nicolas.personna.db.AppDatabase;
import com.nicolas.personna.db.PersonnaModel;

import java.util.List;


public class EditPersonnaViewModel extends AndroidViewModel {

    private final LiveData<PersonnaModel> personnaModel ;
    private AppDatabase appDatabase;

    public EditPersonnaViewModel(Application application, String id) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
        personnaModel = appDatabase.itemAndPersonModel().getItembyId(id);

    }

    public LiveData<PersonnaModel> getPersonnaModel() {
        return personnaModel;
    }

    public void editPersonna(final PersonnaModel personnaModel) {
        new editAsyncTask(appDatabase).execute(personnaModel);
    }

    private static class editAsyncTask extends AsyncTask<PersonnaModel, Void, Void> {

        private AppDatabase db;

        editAsyncTask(AppDatabase appDatabase) {
            db = appDatabase;
        }

        @Override
        protected Void doInBackground(final PersonnaModel... params) {
            db.itemAndPersonModel().editPersonna(params[0]);
            return null;
        }
    }
}
