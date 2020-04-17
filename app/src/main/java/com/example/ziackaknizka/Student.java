package com.example.ziackaknizka;

import java.util.ArrayList;

class Student {
    private String meno;
    private String priezvisko;
    private ArrayList<StudentovPredmet> studentovePredmety;

    public Student(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.studentovePredmety =new ArrayList<>();
    }

    public StudentovPredmet getPredmet(int i){
        if((i>=0)&&(i<studentovePredmety.size())) {
            return studentovePredmety.get(i);
        }
        return null;
    }

    public void upravZnamkuPredmetu(StudentovPredmet predmet, Znamka hodnotenie){
        predmet.setHodnotenie(hodnotenie);
    }
    public void pridajPredmet(Predmet predmet){
        StudentovPredmet novyPredmet = new StudentovPredmet(predmet);
        studentovePredmety.add(novyPredmet);
    }

    public String getMeno() {
        return meno;
    }

    public void setMeno(String meno) {
        this.meno = meno;
    }

    public String getPriezvisko() {
        return priezvisko;
    }

    public void setPriezvisko(String priezvisko) {
        this.priezvisko = priezvisko;
    }
}
