package br.udesc.ceplan.tep.exemplomvc.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UKTech on 25/10/2016.
 */

public class SQLiteExemploDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "exemplo_mvc.sqlite";
    private static final Integer DATABASE_VERSION = 1;


    public SQLiteExemploDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS tarefa (_id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, name TEXT NOT NULL, description TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
