package com.example.p05ps;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "songs.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NOTE = "note";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_SONG_TITLE = "song_title";
    private static final String COLUMN_SONG_SINGERS = "song_singers";
    private static final String COLUMN_SONG_YEAR = "song_year";
    private static final String COLUMN_SONG_STARS = "song_stars";


    public DBHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSongTableSql =  "CREATE TABLE " + TABLE_NOTE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG_TITLE + " TEXT ," + COLUMN_SONG_SINGERS + " TEXT, " + COLUMN_SONG_YEAR + "INTEGER," + COLUMN_SONG_STARS + "INTEGER )";

        db.execSQL(createSongTableSql);
        Log.i("info","created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "SONG");
        onCreate(db);
    }

    public long insertSong() {

    }

    public int deleteNote(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        String condition =  + "= ?";
        String[] args = {String.valueOf(id)};
        int result = db.delete(TABLE_NOTE, condition, args);
        db.close();
        return result;
    }


}
