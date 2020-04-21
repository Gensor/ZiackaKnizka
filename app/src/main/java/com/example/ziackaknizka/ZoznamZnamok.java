package com.example.ziackaknizka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ZoznamZnamok extends AppCompatActivity {
    TextView textView_zoznamPredmetov ;
    Button buttonPridajUprav;
    Student student;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoznam_znamok);
        textView_zoznamPredmetov = findViewById(R.id.textView_zoznamPredmetov);
        Intent intent_studentInfo = getIntent();
        textView_zoznamPredmetov.setText(intent_studentInfo.getStringExtra("zoznamPredmetov"));
        student = intent_studentInfo.getParcelableExtra("student");

        buttonPridajUprav = findViewById(R.id.button_pridatUpravit);
        buttonPridajUprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent_zoznamPredmetov = new Intent(this.ZoznamZnamok,)
            }
        });
    }


}
