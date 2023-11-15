package ru.otus.balandinas.first.project;

public class Tens extends Nineteen {
    private final String D20 = "двадцать";
    private final String D30 = "тридцать";
    private final String D40 = "сорок";
    private final String D50 = "пятьдесят";
    private final String D60 = "шестьдесят";
    private final String D70 = "семьдесят";
    private final String D80 = "восемьдесят";
    private final String D90 = "девяносто";
    private String desc;
    private CurrencyCode code;

    public Tens(CurrencyCode code) {
        super(code);
        this.code = code;
    }

    @Override
    public String getDescription(long digit) {
        int mod10 = (int)digit%10;
        int mod100 = (int)digit%100 - mod10;
        switch (mod100) {
            case (20): desc = D20; break;
            case (30): desc = D30; break;
            case (40): desc = D40; break;
            case (50): desc = D50; break;
            case (60): desc = D60; break;
            case (70): desc = D70; break;
            case (80): desc = D80; break;
            case (90): desc = D90; break;
            default:  desc = ""; break;
        }
        if (desc.length() > 0 && digit%10 != 0)
        { desc += " "; }
        if(digit%100 > 20){
            if(mod10 != 0) {
                desc += super.getDescription(mod10);
            }
        } else {
             desc += super.getDescription(digit%100);
        }

        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
