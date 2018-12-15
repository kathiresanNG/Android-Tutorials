package com.example.tech2k8.todo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SaveNotesDatas extends SQLiteOpenHelper {


    public SaveNotesDatas(Context context) {
        super(context,"notes_db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase databaseRef) {
        String createTable="create table notes_details (title varchar(50),description varchar(150));";
        databaseRef.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    public void addNewDataToDB(String titleVal,String descVal)
    {
        ContentValues cv =new ContentValues();
        cv.put("title",titleVal);
        cv.put("description",descVal);
        SQLiteDatabase ref =this.getWritableDatabase();
        ref.insert("notes_details",null,cv);
    }

    public ArrayList getAllDataFromDB()
    {

        ArrayList titleDataList =new ArrayList();
        SQLiteDatabase ref =this.getReadableDatabase();
       Cursor data= ref.query("notes_details",new String[]{"title"},
                null,null,
                null,null,null);

       if (data != null)
       {
           if (data.moveToFirst())
           {
               do
               {
                   String titleData = data.getString(0);
                   titleDataList.add(titleData);
               }while (data.moveToNext());

           }
       }

    return titleDataList;
    }
}
