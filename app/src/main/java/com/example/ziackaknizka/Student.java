package com.example.ziackaknizka;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

class Student implements Parcelable {
    private String meno;
    private String priezvisko;
    private ArrayList<StudentovPredmet> studentovePredmety;

    public Student(String meno, String priezvisko) {
        this.meno = meno;
        this.priezvisko = priezvisko;
        this.studentovePredmety =new ArrayList<>();
    }

    protected Student(Parcel in) {
        meno = in.readString();
        priezvisko = in.readString();
        if (in.readByte() == 0x01) {
            studentovePredmety = new ArrayList<StudentovPredmet>();
            in.readList(studentovePredmety, StudentovPredmet.class.getClassLoader());
        } else {
            studentovePredmety = null;
        }
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

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

    public String vypisStudentovePredmety(){
        String vysledok ="";
        for (int i=0;i<studentovePredmety.size();i++){
            StudentovPredmet predmet = studentovePredmety.get(i);

            String hodnotenie = predmet.getHodnotenie().toString();
            if(hodnotenie.equals("EMPTY"))hodnotenie="";

            vysledok+=String.format("%-37s : %2s ,\n",predmet.getPredmet().getNazov(),hodnotenie);
        }
        return vysledok;
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

    public ArrayList<StudentovPredmet> getStudentovePredmety() {
        return studentovePredmety;
    }

    @Override
    public String toString() {
        return meno+" "+priezvisko;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(meno);
        dest.writeString(priezvisko);
        if (studentovePredmety == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(studentovePredmety);
        }
    }
}
