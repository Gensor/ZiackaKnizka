package com.example.ziackaknizka;

public enum Znamka {
    A(1),B(2),C(3),D(4),E(5),FX(6),EMPTY(0);
    int znamkaCislo;

    Znamka(int i) {
        this.znamkaCislo=i;
    }

    public int getZnamkaCislo() {
        return znamkaCislo;
    }

    public static String getValue(int value){
        for (Znamka znamka : Znamka.values()) {
            if(znamka.getZnamkaCislo()==value){
                return znamka.name();
            }
        }
        return "";
    }
}

