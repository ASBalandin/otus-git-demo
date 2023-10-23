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

    public void eat(Plate plate){
        if (plate.eat(appetite)){
            satiety = true;
        }
    }

    public void  info() {
        if (satiety) {
            System.out.println( name + " поел");
            return;
        }

        System.out.println( name + " голодный");
    }
}
