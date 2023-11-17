package com.example.relatrios;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class MyDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Relatorios.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "dados_hardwares";
    private static final String COLUMN_COD = "_cod";
    private static final String COLUMN_NAME = "hard_nome";
    private static final String COLUMN_STATUS = "hard_status";
    private static final String COLUMN_DESCRI = "hard_descr";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                        "  (" + COLUMN_COD + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                        COLUMN_NAME + " TEXT NOT NULL, " +
                        COLUMN_STATUS + " TEXT NOT NULL, " +
                        COLUMN_DESCRI + " TEXT NOT NULL);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addBD (String nome, String status, String descri, String cod){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, nome);
        cv.put(COLUMN_STATUS, status);
        cv.put(COLUMN_DESCRI, descri);
        cv.put(COLUMN_COD, cod);
        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Adicione os dados", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Dados adicionados!", Toast.LENGTH_SHORT).show();
        }
    }
}