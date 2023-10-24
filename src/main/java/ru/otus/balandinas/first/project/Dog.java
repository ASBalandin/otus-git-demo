package ru.otus.balandinas.first.project;

public class Dog extends Animal {
    public Dog(String name, int run, int swim, int endur) {
        System.out.println("-------- dog ----------");
        this.name = name;
        this.runSpeed = run;
        this.swimSpead = swim;
        this.endurance = endur;
        this.endurFactor = 2;
    }

    public void swim(int distance) {
        System.out.println("Водные процедуры");
        if (this.endurance - (distance * this.endurFactor) >= 0) {
            this.endurance -= distance * this.endurFactor;
            System.out.println(String.format("Время : %f", (double) distance / this.swimSpead));
        } else {
            System.out.println("Время : -1");
            System.out.println("Появилась усталость");
        }
    }
}
