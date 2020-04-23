package com.example.ziackaknizka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ZoznamZnamok extends AppCompatActivity {
   static TextView textView_zoznamPredmetov ;
    Button buttonPridajUprav;
    Student student;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoznam_znamok);
        textView_zoznamPredmetov = findViewById(R.id.textView_zoznamPredmetov);
        final Intent intent_studentInfo = getIntent();
        student = intent_studentInfo.getParcelableExtra("student");
        textView_zoznamPredmetov.setText(student.vypisStudentovePredmety());

        buttonPridajUprav = findViewById(R.id.button_pridatUpravit);
        buttonPridajUprav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent_zoznamPredmetov = new Intent(ZoznamZnamok.this,PridajUprav.class);
               intent_zoznamPredmetov.putExtra("student",student);
               startActivityForResult(intent_zoznamPredmetov,1);
            }
        });
        textView_zoznamPredmetov.setText(student.vypisStudentovePredmety());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent idata) {
        super.onActivityResult(requestCode, resultCode, idata);

        if(resultCode==1){
            student=idata.getParcelableExtra("student");
            textView_zoznamPredmetov.setText(student.vypisStudentovePredmety());
            Intent intent_vysledok = new Intent();
            intent_vysledok.putExtra("student",student);

            setResult(1,intent_vysledok);

          finish();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this,"Zoznam znamok klassa",Toast.LENGTH_SHORT).show();
    }
}
