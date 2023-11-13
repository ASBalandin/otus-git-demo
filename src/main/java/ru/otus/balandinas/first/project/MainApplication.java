package ru.otus.balandinas.first.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainApplication {
    public static void main(String[] args){

        StringMapping s = new StringMapping(100000.9378d, CurrencyCode.RUR);
        System.out.println(s);

    }

}
