package ru.otus.balandinas.first.project;

public abstract class Animal {
    String name;
    int runSpeed;
    int swimSpead;
    int endurance;
    int endurFactor;
    public void run(int distance) {
        System.out.println("Бег");
        if (endurance - distance >= 0) {
            endurance -= distance;
            System.out.println(String.format("Время : %f", (double) distance / runSpeed));
        } else {
            System.out.println("Время : -1");
            System.out.println("Появилось усталость");
        }

    }

    public void info() {
        System.out.println("Имя : " + name);
        System.out.println("Остаток выносивости : " + endurance);
    }

}
