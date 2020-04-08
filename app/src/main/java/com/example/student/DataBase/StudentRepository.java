package com.example.student.DataBase;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import com.example.student.model.BaseStudent;
import java.util.ArrayList;
import javax.inject.Inject;
import javax.inject.Named;

public class StudentRepository {
    public DataBase database;
    @Inject
    public StudentRepository(@Named("context") Context context) {
        database = new DataBase(context,"data.sqlite",null,1);
        database.queryData("CREATE TABLE IF NOT EXISTS Student(SBD nvarchar(50) , HT nvarchar(50), DT float, DL float, DH float , UNIQUE(SBD));");
//        database.queryData("INSERT INTO Student VALUES ('AAA','Vu Van Nam',7.9,8.5,6.2) ");
//        database.queryData("INSERT INTO Student VALUES ('AAA1','Vu Van Nam',7.9,8.5,6.2) ");
//        database.queryData("INSERT INTO Student VALUES ('AAA2','Vu Van Nam',7.9,8.5,6.2) ");
//        database.queryData("INSERT INTO Student VALUES ('AAA3','Vu Van Nam',7.9,8.5,6.2) ");
        //        database.queryData("DROP TABLE Student");
    }
    public void editStudent(BaseStudent baseStudent){
        database.edit_DoVat(baseStudent);
    }
    public MutableLiveData<ArrayList<BaseStudent>> getListStudent(){
        MutableLiveData<ArrayList<BaseStudent>> mutableLiveData = new MutableLiveData<>();
        ArrayList<BaseStudent> list = new ArrayList<>();
        Cursor cursor = database.getData("SELECT * FROM Student");
        while(cursor.moveToNext()){
            list.add(new BaseStudent(cursor.getString(0),
                    cursor.getString(1),
                    cursor.getDouble(2),
                    cursor.getDouble(3),
                    cursor.getDouble(4)));
        }
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }
}
