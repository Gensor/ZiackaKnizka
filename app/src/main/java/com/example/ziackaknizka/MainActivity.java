package com.example.ziackaknizka;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

/*
    Vytvorte aplikáciu, ktorá bude zobrazovať zoznam študentov.
    Po kliknutí na študenta sa v novom okne zobrazia jeho známky oddelené čiarkou.
    Pri výbere položky editovať alebo pridať sa zobrazí zoznam známok a bude možné pridať študentovi
    novú známku alebo upraviť existujúce známky.
*/
    ArrayList<Student> zoznamStudentov;
    ListView list;
    int studentID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zoznamStudentov = new ArrayList<>();
        list = findViewById(R.id.listView_zoznamStudentov);
        naplnZoznamStudentov(zoznamStudentov);

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,zoznamStudentov);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                studentID=position;
                Student student = zoznamStudentov.get(position);
                Intent intent_student_zoznamZnamok = new Intent(MainActivity.this, ZoznamZnamok.class);
                intent_student_zoznamZnamok.putExtra("student",  student);
                startActivityForResult(intent_student_zoznamZnamok,1);

            }
        });

}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent idata) {
        super.onActivityResult(requestCode, resultCode, idata);
        if(resultCode==1){
            Student student=idata.getParcelableExtra("student");
            zoznamStudentov.set(studentID,student);
        }
    }

    private void naplnZoznamStudentov(List list) {
        String []mena={"Jan","Frantisek","Stefan","Jozef","Peter","Ivan","Jakub","Anton","Martin"};
        String []priezviska ={"Novotny","Adamec","Bahno","Bobula","Cibula","Lopta","Lopata","Semafor"
                                ,"Zavinac","Bravcovy","Papierovy","Stol","Novovytvoreny","Stary"};

        for(int i = 0;i<20;i++){
            Student student = new Student(vyberNahodnyPrvok(mena),vyberNahodnyPrvok(priezviska));
            student.pridajPredmet(Predmet.APG);
            student.upravZnamkuPredmetu(student.getPredmet(0),vyberNahodnuZnamku());
            student.pridajPredmet(Predmet.PDA);
            student.upravZnamkuPredmetu(student.getPredmet(1),vyberNahodnuZnamku());
            student.pridajPredmet(Predmet.UI);
            student.upravZnamkuPredmetu(student.getPredmet(2),vyberNahodnuZnamku());
            student.pridajPredmet(Predmet.VMA);
            student.upravZnamkuPredmetu(student.getPredmet(3),vyberNahodnuZnamku());
            list.add(student);
        }
    }

    private String vyberNahodnyPrvok(String [] pole){
        Random rand= new Random();
        return pole[rand.nextInt(pole.length)];
    }

    private Znamka vyberNahodnuZnamku(){
        Random rand = new Random();
        int cislo = rand.nextInt(7);
        switch (cislo){
            case 0:
                return Znamka.A;
            case 1:
                return Znamka.B;
            case 2:
                return Znamka.C;
            case 3:
                return Znamka.D;
            case 4:
                return Znamka.E;
            case 5:
                return Znamka.FX;
            case 6:
                return Znamka.EMPTY;
        }
        return Znamka.EMPTY;
    }






}
