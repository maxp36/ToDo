package com.test.maxp36.todo.sqlite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "todo";
    private static final int DB_VERSION = 1;

    public MySQLiteOpenHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("CREATE TABLE TODO_ITEMS ("
                                + "_id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "NAME TEXT, "
                                + "DATE TEXT, "
                                + "PRIORITY TEXT, "
                                + "MARK);");

        //sqLiteDatabase.execSQL("DROP TABLE TODO_ITEMS");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
