package com.nicolas.personna.listItems;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.nicolas.personna.db.AppDatabase;
import com.nicolas.personna.db.PersonnaModel;

import java.util.List;


public class PersonnaListViewModel extends AndroidViewModel {

    private final LiveData<List<PersonnaModel>> itemAndPersonList;

    private AppDatabase appDatabase;

    public PersonnaListViewModel(Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());

        itemAndPersonList = appDatabase.itemAndPersonModel().getAllPersonnaItems();
    }


    public LiveData<List<PersonnaModel>> getItemAndPersonList() {
        return itemAndPersonList;
    }

    public void deleteItem(PersonnaModel personnaModel) {
        new deleteAsyncTask(appDatabase).execute(personnaModel);
        }

        private static class deleteAsyncTask extends AsyncTask<PersonnaModel, Void, Void> {

            private AppDatabase db;

            deleteAsyncTask(AppDatabase appDatabase) {
                db = appDatabase;
            }

            @Override
            protected Void doInBackground(final PersonnaModel... params) {
                db.itemAndPersonModel().deletePersonna(params[0]);
                return null;
        }

    }

}
