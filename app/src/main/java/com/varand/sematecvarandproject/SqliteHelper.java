package com.varand.sematecvarandproject;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.varand.sematecvarandproject.Movies.Search;

import java.util.ArrayList;

import androidx.annotation.Nullable;

public class SqliteHelper extends SQLiteOpenHelper {
    String TABLE_NAME = "students";
    public SqliteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_QUERY = "CREATE TABLE " + TABLE_NAME + "("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "movietitle TEXT,"
                + "moviedes TEXT,"
                + "runtime TEXT,"
                + "relizedate TEXT"
                + ")";
        db.execSQL(CREATE_TABLE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertMovies(String movietitle, String moviedes, String runtime,String relizedate) {

        String INSERT_STUDENT_QUERY = "INSERT INTO " + TABLE_NAME + "(movietitle,moviedes,runtime,relizedate) VALUES("
                + "'" + movietitle + "'" + ","
                + "'" + moviedes + "'" + ","
                + "'" + runtime + "'" + ","
                + "'" + relizedate + "'"
                + ")";

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL(INSERT_STUDENT_QUERY);
        db.close();
    }


    public ArrayList<Search> getAllStudentsName() {
        ArrayList<Search> MoviesArry =new ArrayList<>();
        //String result = "";
        String GET_ALL_STUDENTS_NAME_QUERY = "SELECT movietitle,moviedes,runtime,relizedate FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery(GET_ALL_STUDENTS_NAME_QUERY, null);

        while (data.moveToNext()){
            MoviesArry.add(new Search(data.getString(3),data.getString(0),data.getString(1),data.getString(2),"","",""));
            //result = result + data.getString(1) + data.getString(2) + "\n";
        }
        Log.d("varandsql", String.valueOf(MoviesArry.size()));
        db.close();

        return MoviesArry;
    }
}
