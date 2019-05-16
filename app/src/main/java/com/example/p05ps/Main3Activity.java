package com.example.p05ps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Button btnUpdate, btnDelete, btnCancel;
    TextView tvID;
    EditText etTitle, etSingers, etYear;
    Song data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnCancel = findViewById(R.id.btnCancel);
        tvID = findViewById(R.id.textView);
        etTitle = findViewById(R.id.etSongTitle);
        etSingers = findViewById(R.id.etSingers);
        etYear = findViewById(R.id.etYear);

        Intent i = getIntent();
        data = (Song) i.getSerializableExtra("data");

        tvID.setText(data.getId());
        etYear.setText(data.getYears());
        etSingers.setText(data.getSingers());
        etTitle.setText(data.getTitle());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(Main3Activity.this);
                data.setSingers(etSingers.getText().toString());
                data.setTitle(etTitle.getText().toString());
                data.setYear(Integer.parseInt(etYear.getText().toString()));

            }
        });

    }
}
