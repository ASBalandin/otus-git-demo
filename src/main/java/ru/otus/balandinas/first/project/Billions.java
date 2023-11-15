package ru.otus.balandinas.first.project;

public class Billions extends Millions {
    private final String D1ML = "миллиард";
    private final String D2_4ML = "миллиарда";
    private final String D0_OVER4ML = "миллиардов";
    private String desc;
    private CurrencyCode code;

    public Billions(CurrencyCode code) {
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
        long mod100ML = digit / 1000000000;
        long mod1ML = (digit - mod100ML * 1000000000);
        int mod10 = (int) mod100ML % 10;

        if (mod10 == 1 && mod100ML == 1) {

            if (mod100ML > 0) {
                if (mod100ML > 1) {
                    desc += super.getDescription(mod100ML - mod10) + " ";
                }
                Nineteen nineteen = new Nineteen(code);
                desc += nineteen.getDescription(mod100ML % 10);
                desc += " " + D1ML;
            }

        } else if ((mod10 > 1 && mod10 <= 4) && (mod100ML <= 4 /*|| mod100ML > 19*/)) {

            if (mod100ML > 0) {
                if (mod100ML > 19) {
                    desc += super.getDescription(mod100ML - mod10) + " ";
                }
                Nineteen nineteen = new Nineteen(code);
                desc += nineteen.getDescription(mod100ML % 10);
                desc += " " + D2_4ML;
            }

        } else if ((mod10 == 0 || mod10 > 4) || mod100ML > 4) {

            if (mod100ML > 0) {

                desc += super.getDescription(mod100ML);
                desc += " " + D0_OVER4ML;
            }

        }

        if (mod1ML > 0) {
            if (desc.length() > 0) {
                desc += " ";
            }
            desc += new Millions(code).getDescription(mod1ML);
        }
        if (mod1ML == 0 && desc.length() == 0) {
            desc += new Millions(code).getDescription(mod1ML);
        }

        return desc;
    }

    @Override
    public String toString() {
        return desc;
    }
}
