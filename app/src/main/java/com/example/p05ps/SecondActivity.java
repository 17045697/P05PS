package com.example.p05ps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    Button btnShow;
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Song> songal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnShow = findViewById(R.id.btnShow);

        lv = findViewById(R.id.lv);
        songal = new ArrayList<Song>();
        aa = new SongAdapter(this,R.layout.custom_layout,songal);
        DBHelper db = new DBHelper(SecondActivity.this);
        ArrayList<String> data = db.getAllSongs();
        aa = new SongAdapter(this, R.layout.custom_layout, songal);
        lv.setAdapter(aa);




    }
}
