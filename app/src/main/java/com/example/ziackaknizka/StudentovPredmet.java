package com.example.ziackaknizka;

class StudentovPredmet {
    private Predmet predmet;
    private Znamka hodnotenie;

    public StudentovPredmet(Predmet predmet) {
        this.predmet = predmet;
        this.hodnotenie= Znamka.EMPTY;
    }

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
}
