package com.example.ziackaknizka;

import android.os.Parcel;
import android.os.Parcelable;

class StudentovPredmet implements Parcelable{
    private Predmet predmet;
    private Znamka hodnotenie;

    public StudentovPredmet(Predmet predmet) {
        this.predmet = predmet;
        this.hodnotenie= Znamka.EMPTY;
    }

    protected StudentovPredmet(Parcel in) {
        predmet = (Predmet) in.readValue(Predmet.class.getClassLoader());
        hodnotenie = (Znamka) in.readValue(Znamka.class.getClassLoader());
    }

    public static final Creator<StudentovPredmet> CREATOR = new Creator<StudentovPredmet>() {
        @Override
        public StudentovPredmet createFromParcel(Parcel in) {
            return new StudentovPredmet(in);
        }

        @Override
        public StudentovPredmet[] newArray(int size) {
            return new StudentovPredmet[size];
        }
    };

    public Predmet getPredmet() {
        return predmet;
    }

    public void setPredmet(Predmet predmet) {
        this.predmet = predmet;
    }

    public Znamka getHodnotenie() {
        return hodnotenie;
    }

    public void setHodnotenie(Znamka hodnotenie) {
        this.hodnotenie = hodnotenie;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(predmet);
        dest.writeValue(hodnotenie);
    }
}
