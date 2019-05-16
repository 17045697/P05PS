package com.example.p05ps;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "songs.db";
    private static final int DATABASE_VERSION = 3;
    private static final String TABLE_SONG = "song";
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
        String createSongTableSql =  "CREATE TABLE " + TABLE_SONG + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_SONG_TITLE + " TEXT ," + COLUMN_SONG_SINGERS + " TEXT, " + COLUMN_SONG_YEAR + " INTEGER, " + COLUMN_SONG_STARS + " INTEGER )";

        db.execSQL(createSongTableSql);
        Log.i("info","created tables");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "SONG");
        onCreate(db);
    }

    public long insertSong(String title, String singers, int year, int stars) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_SONG_TITLE, title);
        values.put(COLUMN_SONG_SINGERS, singers);
        values.put(COLUMN_SONG_YEAR, year);
        values.put(COLUMN_SONG_STARS, stars);

        long result = db.insert(TABLE_SONG, null, values);

        //check if record is inserted successfully
        if (result == -1){
            Log.d("DBHelper", "Insert failed");
        }

        db.close();
        Log.d("SQL Insert ", "" + result);
        //id returned, shouldn’t be -1

        return result;

    }


    public int updateSong(Song data) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COLUMN_SONG_TITLE, data.getTitle());
        values.put(COLUMN_SONG_SINGERS, data.getSingers());
        values.put(COLUMN_SONG_YEAR, data.getYears());
        values.put(COLUMN_SONG_STARS, data.getStars());

        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(data.getId())};

        int result = db.update(TABLE_SONG, values, condition, args);

        //check if record is updated successfully if the affected record is 1
        if (result < 1){
            Log.d("DBHelper", "Update failed");
        }

        db.close();
        return result;

    }



    public int deleteSong(int id){

        SQLiteDatabase db = this.getWritableDatabase();
        String condition = COLUMN_ID + "= ?";
        String[] args = {String.valueOf(id)};

        int result = db.delete(TABLE_SONG, condition, args);

        //check if record is successfully updated if the affected record is 1
        if (result < 1){
            Log.d("DBHelper", "Update failed");
        }

        db.close();
        return result;

    }

    

    public ArrayList<Song> getAllSongs() {
        ArrayList<Song> songs = new ArrayList<Song>();

        String selectQuery = "SELECT " + COLUMN_ID + "," + COLUMN_SONG_TITLE +
                "," + COLUMN_SONG_SINGERS + "," + COLUMN_SONG_YEAR + "," + COLUMN_SONG_STARS +
                " FROM " + TABLE_SONG;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {

                int id = cursor.getInt(0);
                String content = cursor.getString(1);
                songs.add("ID:" + id + ", " + content);

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return songs;

    }

}
