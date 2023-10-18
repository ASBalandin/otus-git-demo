package ru.otus.balandinas.first.project;

public class Cat extends Animal {
    public Cat(String name, int run, int endur) {
        System.out.println("-------- cat ----------");
        this.name = name;
        this.runSpeed = run;
        this.endurance = endur;
    }

}
