package ru.otus.balandinas.first.project;

public class Millions extends Thousands {
    private final String D1M = "миллион";
    private final String D2_4M = "миллиона";
    private final String D0_OVER4M = "миллионов";
    private String desc;
    private CurrencyCode code;

    public Millions(CurrencyCode code) {
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
        int mod100K = (int) digit % 1000000;
        int mod1ML = (int) digit % 1000000000 / 1000000;
        int mod10 = mod1ML % 10;

        if (mod10 == 1 && mod1ML == 1) {

            if (mod1ML > 0) {
                if (mod1ML > 1){
                    desc += super.getDescription(mod1ML - mod10) + " ";
                }
                Nineteen nineteen = new Nineteen(code);
                desc += nineteen.getDescription(mod1ML%10);
                desc += " " + D1M;
            }

        } else if ((mod10 > 1 && mod10 <= 4) && (mod1ML <= 4 /*|| mod1ML > 19*/)) {

            if (mod1ML > 0) {
                if (mod1ML > 19){
                    desc += super.getDescription(mod1ML - mod10) + " ";
                }
                Nineteen nineteen = new Nineteen(code);
                desc += nineteen.getDescription(mod1ML%10);
                desc += " " + D2_4M;
            }

        } else if ((mod10 == 0 || mod10 > 4)|| mod1ML > 4) {

            if (mod1ML > 0) {

                desc += super.getDescription(mod1ML);
                desc += " " + D0_OVER4M;
            }

        }

        if (mod100K > 0){
            if (desc.length() > 0) {
                desc += " ";
            }
            desc += new Thousands(code).getDescription(mod100K);
        }
        if (mod100K == 0 && desc.length() == 0) {
            desc += new Thousands(code).getDescription(mod100K);
        }

        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
