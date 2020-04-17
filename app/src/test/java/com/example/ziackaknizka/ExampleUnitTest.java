package com.example.ziackaknizka;


import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
class Testy {


    @Nested
    class Student_test {


        private Student student;

        @BeforeEach
        public void naplnZoznamPredmetov() {
            student = new Student("Stefan", "Razdva");
            student.pridajPredmet(Predmet.APG);
            student.pridajPredmet(Predmet.UI);
            student.pridajPredmet(Predmet.PDA);
            student.pridajPredmet(Predmet.VMA);
        }


        @Test
        public void getPredmetTest() {
            StudentovPredmet apg = student.getPredmet(0);
            String nazovPredmetu = apg.getPredmet().getNazov();
            assertEquals("Aplikovana pocitacova grafika", nazovPredmetu);
            Znamka znamka = apg.getHodnotenie();
            assertEquals(Znamka.EMPTY, znamka);

        }

        @Test
        public void pridajPredmetTest() {
            StudentovPredmet apg = student.getPredmet(0);
            Znamka znamka = apg.getHodnotenie();
            assertNotEquals(Znamka.E, znamka);
            apg.setHodnotenie(Znamka.E);
            znamka = apg.getHodnotenie();
            assertEquals(Znamka.E, znamka);
        }

    }
}