package ru.otus.balandinas.first.project;

public abstract class Animal {
    int runSpeed;
    int swimSpead;
    int endurance;

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

    public void Info() {
        System.out.println("Остаток выносивости : " + endurance
        );
    }

}
