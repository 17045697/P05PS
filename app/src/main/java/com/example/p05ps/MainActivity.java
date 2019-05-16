package com.example.p05ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnShow;

    EditText etSong;
    EditText etSingers;
    EditText etYear;
    RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInsert = findViewById(R.id.btnInsert);
        btnShow = findViewById(R.id.btnShowList);

        etSong = findViewById(R.id.etTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String song = etSong.getText().toString();
                String singer = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                RadioGroup rg = findViewById(R.id.rg);
                int selectedButtonid = rg.getCheckedRadioButtonId();


                DBHelper db = new DBHelper(MainActivity.this);
                long row_affected = db.insertSong(song, singer, year, selectedButtonid);
                db.close();

                if (row_affected != -1) {
                    Toast.makeText(MainActivity.this, "Insert successful",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,
                        SecondActivity.class);
                startActivityForResult(i, 9);
            }


        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == 9) {

        }
    }
}
