package ru.otus.balandinas.first.project;

public class Nineteen {
    private final String D0 = "ноль";
    private final String D1 = "один";
    private final String D1F = "одна";
    private final String D2 = "два";
    private final String D2F = "две";
    private final String D3 = "три";
    private final String D4 = "четыре";
    private final String D5 = "пять";
    private final String D6 = "шесть";
    private final String D7 = "семь";
    private final String D8 = "восемь";
    private final String D9 = "девять";
    private final String D10 = "десять";
    private final String D11 = "одиннадцать";
    private final String D12 = "двенадцать";
    private final String D13 = "тринадцать";
    private final String D14 = "четырнадцать";
    private final String D15 = "пятнадцать";
    private final String D16 = "шестнадцать";
    private final String D17 = "семнадцать";
    private final String D18 = "восемнадцать";
    private final String D19 = "девятнадцать";
    private String desc;
    private boolean isFraction;
    private CurrencyCode code;

    public Nineteen(CurrencyCode code) {
        this.isFraction = false;
        this.code = code;
    }

    public void setFraction(boolean fraction) {
        isFraction = fraction;
    }

    public void setCode(CurrencyCode code) {
        this.code = code;
    }

    public String getDescription(long digit) {
        switch ((int)digit) {
            case (0): desc = D0; break;
            case (1): if(isFraction && code == CurrencyCode.RUR) {desc = D1F;} else {desc = D1;} break;
            case (2): if(isFraction && code == CurrencyCode.RUR) {desc = D2F;} else {desc = D2;} break;
            case (3): desc = D3; break;
            case (4): desc = D4; break;
            case (5): desc = D5; break;
            case (6): desc = D6; break;
            case (7): desc = D7; break;
            case (8): desc = D8; break;
            case (9): desc = D9; break;
            case (10): desc = D10; break;
            case (11): desc = D11; break;
            case (12): desc = D12; break;
            case (13): desc = D13; break;
            case (14): desc = D14; break;
            case (15): desc = D15; break;
            case (16): desc = D16; break;
            case (17): desc = D17; break;
            case (18): desc = D18; break;
            case (19): desc = D19; break;
            default:  desc = ""; break;
        }

        return desc;

    }

    @Override
    public String toString() {
        return desc;
    }
}