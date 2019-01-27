package com.nicolas.personna.db;

import java.io.Serializable;
import java.util.List;

public class PersonnaModelArray implements Serializable {

    private List<PersonnaModel> personnaModelList;

    public PersonnaModelArray(List<PersonnaModel> personnaModelList){
        this.personnaModelList = personnaModelList;
    }

    public void setPersonnaModelArray(List<PersonnaModel> personnaModelList) {
        this.personnaModelList = personnaModelList;
    }

    public List<PersonnaModel> getPersonnaModelArray() {
        return personnaModelList;
    }
}
