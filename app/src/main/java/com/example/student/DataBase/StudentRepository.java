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
//        database = new DataBase(context,"data.sqlite",null,1);
//        database.queryData("CREATE TABLE IF NOT EXISTS Student(SBD varchar(50) primary key, HT varchar(50), DT float, DL float, DH float)");
//        database.queryData("INSERT INTO Student VALUES ('AAA','Vu Van Nam',3.1,5.2,9.1)");
//        database.queryData("INSERT INTO Student VALUES ('AAA1','Vu Van Nam',3.2,5.3,9.2)");
//        database.queryData("INSERT INTO StudentVALUES ('AAA3','Vu Van Nam',3.4,5.2,9.2)");
//        database.queryData("DROP TABLE Student");
    }
    public MutableLiveData<ArrayList<BaseStudent>> getListStudent(){
        MutableLiveData<ArrayList<BaseStudent>> mutableLiveData = new MutableLiveData<>();
        ArrayList<BaseStudent> list = new ArrayList<>();
        list.add(new BaseStudent("Nam","Nam",3,4,5));
        list.add(new BaseStudent("Nam1","Nam",3,4,5));
        list.add(new BaseStudent("Nam2","Nam",3,4,5));
//        Cursor cursor = database.getData("SELECT * FROM Student");
//        while(cursor.moveToNext()){
//            list.add(new BaseStudent(cursor.getString(0),
//                    cursor.getString(1),
//                    cursor.getDouble(2),
//                    cursor.getDouble(3),
//                    cursor.getDouble(4)));
//        }
        Log.d("AAA",list.get(0).HT);
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }
    }
