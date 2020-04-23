package com.example.ziackaknizka;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class PridajUprav extends AppCompatActivity {

    ListView list;
    ArrayAdapter<StudentovPredmet> adapter;
    Student student;
    Button buttonOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pridaj_uprav);

        Intent intent_studentInfo = getIntent();
        student = intent_studentInfo.getParcelableExtra("student");

        buttonOK = findViewById(R.id.pridajUprav_button_ok);
        list = findViewById(R.id.pridajUprav_listview);
        adapter = new RiadokAdapter(PridajUprav.this,student.getStudentovePredmety());
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_vysledok = new Intent();
                intent_vysledok.putExtra("student",student);
                setResult(1,intent_vysledok);
                finish();
            }
        });

    }

}
