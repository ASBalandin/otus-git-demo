package ru.otus.balandinas.first.project;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void Eat(Plate plate){
        if (plate.Eat(appetite)){
            satiety = true;
        }
    }

    public void  Info() {
        if (satiety) {
            System.out.println( name + " поел");
            return;
        }

        System.out.println( name + " голодный");
    }
}
