package com.example.p05ps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

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

        lv = this.findViewById(R.id.lv);

        lv = new ArrayList<Song>();
        lv.add(new Song());


        aa = new

    }
}
