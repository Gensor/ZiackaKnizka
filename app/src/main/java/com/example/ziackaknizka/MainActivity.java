package com.example.ziackaknizka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

/*
    Vytvorte aplikáciu, ktorá bude zobrazovať zoznam študentov.
    Po kliknutí na študenta sa v novom okne zobrazia jeho známky oddelené čiarkou.
    Pri výbere položky editovať alebo pridať sa zobrazí zoznam známok a bude možné pridať študentovi novú známku alebo upraviť existujúce známky.
*/
    ArrayList<Student> zoznamStudentov;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        zoznamStudentov = new ArrayList<>();
        naplnZoznamStudentov();
}


    private void naplnZoznamStudentov() {
        String []mena={"Jan","Frantisek","Stefan","Jozef","Peter","Ivan","Jakub","Anton","Martin"};
        String []priezviska ={"Novotny","Adamec","Bahno","Bobula","Cibula","Lopta","Lopata","Semafor"};

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
