package ru.otus.balandinas.first.project;

public class RusRub810 implements Currency {
    private final String ONE_F_RUR = "копейка";
    private final String TWO_TO_FOUR_F_RUR = "копейки";
    private final String ZERO_AND_OVER_FOUR_F_RUR = "копеек";
    private final String ONE_RUR = "рубль";
    private final String TWO_TO_FOUR_RUR = "рубля";
    private final String ZERO_AND_OVER_FOUR_RUR = "рублей";
    private long whole;
    private int fraction;
    private String desc;

    public RusRub810(long whole, int fraction) {
        this.whole = whole;
        this.fraction = fraction;
    }

    @Override
    public void description(long whole, int fraction, Currency currCurrency, CurrencyCode code) {
        int mod10 = (int) (whole % 10);
        int mod100 = (int) (whole % 100);
        int mod1000 = (int) (whole % 1000);
        int mod10000 = (int) (whole % 10000);
        int mod100000 = (int) (whole % 100000);
        int mod1000000 = (int) (whole % 1000000);
        int mod10000000 = (int) (whole % 10000000);
        int mod100000000 = (int) (whole % 100000000);
        int mod1000000000 = (int) (whole % 1000000000);
/*
        System.out.println("d " + mod10);
        System.out.println("s " + mod100);
        System.out.println("t " + mod1000);
        System.out.println("dt " + mod10000);
        System.out.println("st " + mod100000);
        System.out.println("m " + mod1000000);
        System.out.println("dm" + mod10000000);
        System.out.println("sm" + mod100000000);
        System.out.println("mlr" + mod100000000); */


        desc = new Millions(code).getDescription(mod1000000000).toString() + " ";

        if (mod10 == 0 || mod10 > 4) {
            desc += ZERO_AND_OVER_FOUR_RUR;
        } else if (mod10 == 1) {
            desc += ONE_RUR;
        } else if (mod10 > 1 && mod10 < 5) {
            desc += TWO_TO_FOUR_RUR;
        }

        Tens t = new Tens(code);
        t.setFraction(true);
        desc += " " + t.getDescription(fraction).toString() + " ";

        if (fraction%10 == 0 || fraction%10 > 4) {
            desc += ZERO_AND_OVER_FOUR_F_RUR;
        } else if (fraction%10 == 1) {
            desc += ONE_F_RUR;
        } else if (fraction%10 > 1 && fraction%10 < 5) {
            desc += TWO_TO_FOUR_F_RUR;
        }

    }

    @Override
    public String toString() {
        return desc;
    }
}
