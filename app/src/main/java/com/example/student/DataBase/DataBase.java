package com.example.student.DataBase;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import androidx.annotation.Nullable;
import com.example.student.model.BaseStudent;

public class DataBase extends SQLiteOpenHelper{

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(sql,null);
    }

    public void insert_DoVat(String SBD, String HT, double DT, double DL, double DH){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "insert into Student values(?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,SBD);
        statement.bindString(2,HT);
        statement.bindDouble(3,DT);
        statement.bindDouble(4,DT);
        statement.bindDouble(5,DT);
        statement.executeInsert();
    }
    public void delete_DoVat(String SBD){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "delete from Student where SBD = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,SBD);
        statement.executeInsert();
    }
    public void edit_DoVat(BaseStudent student){
        SQLiteDatabase database = getWritableDatabase();
        String sql = "update Student set HT = ?, DT = ?, DL = ?, DH = ? where SBD = ?";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1,student.HT);
        statement.bindDouble(2,student.DT);
        statement.bindDouble(3,student.DL);
        statement.bindDouble(4,student.DH);
        statement.bindString(5,student.SBD);
        statement.executeInsert();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
