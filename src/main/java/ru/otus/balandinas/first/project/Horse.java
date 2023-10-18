package ru.otus.balandinas.first.project;

public class Horse extends Animal {
    public Horse(String name, int run, int swim, int endur) {
        System.out.println("-------- horse ----------");
        this.name = name;
        this.runSpeed = run;
        this.swimSpead = swim;
        this.endurance = endur;
    }

    public void Swim(int distance) {
        System.out.println("Водные процедуры");
        if (this.endurance - (distance*4) >= 0) {
            this.endurance -= distance*4;
            System.out.println(String.format("Время : %f", (double) distance / this.swimSpead));
        } else {
            System.out.println("Время : -1");
            System.out.println("Появилось усталость");
        }
    }
}
