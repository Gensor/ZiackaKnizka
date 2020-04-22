package com.example.ziackaknizka;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PridajUprav extends AppCompatActivity {

    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pridaj_uprav);

        Intent intent_studentInfo = getIntent();
        Student student = intent_studentInfo.getParcelableExtra("student");

        list=findViewById(R.id.pridajUprav_listview);
        ArrayAdapter<StudentovPredmet> adapter = new RiadokAdapter(PridajUprav.this,student.getStudentovePredmety());
        list.setAdapter(adapter);


    }

}
