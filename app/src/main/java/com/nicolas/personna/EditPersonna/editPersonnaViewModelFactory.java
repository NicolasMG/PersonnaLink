package com.nicolas.personna.EditPersonna;

import android.app.Application;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

class editPersonnaViewModelFactory implements ViewModelProvider.Factory {
    private Application mApplication;
    private String mIdPersonna;
    public editPersonnaViewModelFactory(Application application, String idPersonna) {
        mApplication = application;
        mIdPersonna = idPersonna;
    }


    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new EditPersonnaViewModel(mApplication, mIdPersonna);
    }
}
