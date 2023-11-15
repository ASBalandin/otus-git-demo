package ru.otus.balandinas.first.project;

public class Hundreds extends Tens {
    private final String D1H = "сто";
    private final String D2H = "двести";
    private final String D3H = "триста";
    private final String D4H = "четыреста";
    private final String D5H = "пятьсот";
    private final String D6H = "шестьсот";
    private final String D7H = "семьсот";
    private final String D8H = "восемьсот";
    private final String D9H = "девятьсот";
    private String desc;
    private CurrencyCode code;

    public Hundreds(CurrencyCode code) {
        super(code);
        this.code = code;
    }

    @Override
    public String getDescription(long digit) {
        int mod100 = (int)digit%100;
        int mod1000 = (int)digit%1000 - mod100;
        switch (mod1000) {
            case (100): desc = D1H; break;
            case (200): desc = D2H; break;
            case (300): desc = D3H; break;
            case (400): desc = D4H; break;
            case (500): desc = D5H; break;
            case (600): desc = D6H; break;
            case (700): desc = D7H; break;
            case (800): desc = D8H; break;
            case (900): desc = D9H; break;
            default:  desc = ""; break;
        }

        if(mod100 > 0 ) {
            desc += " ";
            desc += super.getDescription(mod100);
        } else if (mod100 == 0 && desc.length() == 0) {
            desc += super.getDescription(mod100);
        }


        return desc;
    }
}
