package com.example.ziackaknizka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ZoznamZnamok extends AppCompatActivity {
    TextView textView_zoznamPredmetov ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoznam_znamok);
        textView_zoznamPredmetov = findViewById(R.id.textView_zoznamPredmetov);
        Intent intent_zoznamPredmetov = getIntent();
        textView_zoznamPredmetov.setText(intent_zoznamPredmetov.getStringExtra("zoznamPredmetov"));
    }
}
