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

        desc = new Billions(code).getDescription(whole).toString() + " ";

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
