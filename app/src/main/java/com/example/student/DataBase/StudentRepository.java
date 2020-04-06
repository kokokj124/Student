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
    public static DataBase database;
    @Inject
    public StudentRepository(@Named("context") Context context) {
        database = new DataBase(context,"data.sqlite",null,1);
        database.queryData("CREATE TABLE IF NOT EXISTS Student(SBD text , HT text, DT float, DL float, DH float , UNIQUE(SBD));");
//        StudentRepository.database.queryData("DROP TABLE Student");
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
        Log.d("AAA",list.get(0).HT);
        mutableLiveData.setValue(list);
        return mutableLiveData;
    }
}
