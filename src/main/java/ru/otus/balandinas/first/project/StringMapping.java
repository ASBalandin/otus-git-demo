package ru.otus.balandinas.first.project;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class StringMapping {

    private long whole;
    private int fraction;
    CurrencyCode currentCode;

    private String desc;

    public StringMapping(double digit, CurrencyCode code) {
        BigDecimal bd = BigDecimal.valueOf(digit);
        bd = bd.setScale(2, RoundingMode.DOWN);
        this.fraction = bd.remainder(BigDecimal.ONE).movePointRight(bd.scale()).abs().toBigInteger().intValue();
        this.whole = bd.setScale(0, RoundingMode.DOWN).abs().toBigInteger().longValueExact();
        this.currentCode = code;
        description(whole, fraction, code);
        //System.out.println("целая часть = " + whole + "\r\nдробная часть = " + fraction);
    }

    public String description(long whole, int fraction, CurrencyCode code) {
        System.out.println("Число : " + whole + "." + String.format("%02d", fraction));
        if (whole / 1000000000 >= 1000) {
            desc = "Извините, число к преобразованию превышает 999 миллиардов. Используйте, пожалуйста, меньшую разрядность.";
            return desc;
        }
        if (code == CurrencyCode.RUR) {
            RusRub810 rub = new RusRub810(whole, fraction);
            rub.description(whole, fraction, rub, code);
            desc = rub.toString();
        } else if (code == CurrencyCode.TRY) {
            TurkishLira949 tl = new TurkishLira949(whole, fraction);
            tl.description(whole, fraction, tl, code);
            desc = tl.toString();
        } else {
            desc = "Извините, валюта недружественных стран не поддерживается";
        }
        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
