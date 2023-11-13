package ru.otus.balandinas.first.project;

public class Thousands extends Hundreds {
    private final String D1T = "тысяча";
    private final String D2_4T = "тысячи";
    private final String D0_OVER4T = "тысяч";
    private String desc;
    private CurrencyCode code;

    public Thousands(CurrencyCode code) {
        super(code);
        this.code = code;
        this.desc = "";
    }

    @Override
    public void setCode(CurrencyCode code) {
        this.code = code;
    }

    @Override
    public String getDescription(long digit) {
        int mod10K = (int) digit % 100000 / 1000;
        int mod1M = (int) digit % 1000000 / 1000;
        int mod10 = mod1M % 10;
        /*System.out.println(mod1M);
        System.out.println(mod10K);*/
        if (mod10 == 1) {

            if (mod1M > 0) {
                if (mod1M > 1){
                    desc += super.getDescription(mod1M - mod10) + " ";
                }
                Nineteen nineteen = new Nineteen(code);
                nineteen.setFraction(true);
                desc += nineteen.getDescription(mod1M%10);
                desc += " " + D1T;
            }

        } else if (mod10 > 1 && mod10 < 4) {

            if (mod1M > 0) {
                if (mod1M > 1){
                    desc += super.getDescription(mod1M - mod10) + " ";
                }
                Nineteen nineteen = new Nineteen(code);
                nineteen.setFraction(true);
                desc += nineteen.getDescription(mod1M%10);
                desc += " " + D2_4T;
            }

        } else if (mod10 == 0 || mod10 > 4) {

            if (mod1M > 0) {

                desc += super.getDescription(mod1M);
                desc += " " + D0_OVER4T;
            }

        }

        if (digit % 1000 > 0){
            desc += " ";
            desc += super.getDescription(digit % 1000);
        }
        if (digit % 1000 == 0 && desc.length() == 0) {
            desc += super.getDescription(digit % 1000);
        }

        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
