package ru.otus.balandinas.first.project;

public class MainApplication {
    public static void main(String[] args){
        Dog d = new Dog("bobik",15, 5, 100);
        d.run(50);
        d.Info();
        d.Swim(10);
        d.Info();

        Cat c = new Cat("murzik",15, 100);
        c.run(50);
        c.Info();

        Horse h = new Horse("retiviy",40,2, 700);
        h.run(50);
        h.Info();
        h.Swim(10);
        h.Info();

    }

}
