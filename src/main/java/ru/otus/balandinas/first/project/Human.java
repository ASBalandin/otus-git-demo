package ru.otus.balandinas.first.project;

import ru.otus.balandinas.first.project.Terrain;
import ru.otus.balandinas.first.project.Transport;

public class Human {
    private String name;
    private Transport currentTransport;
    private int endurance;
    private int endurance_force;

    public Human(String name, int endurance) {
        this.name = name;
        this.endurance = endurance;
        this.endurance_force = 1;
    }

    public void setTransport(Transport currTransport) {
        this.currentTransport = currTransport;
    }

    public boolean move(int distanse, Terrain terrain) {
        String desc = "";
        if (currentTransport == null) {
            System.out.println("Идёт пешком");
        } else {
            if (currentTransport instanceof Bike) {
                if (endurance - distanse * endurance_force >= 0) {
                    endurance -= distanse * endurance_force;
                   if (currentTransport.move(distanse, terrain, currentTransport)) {
                       desc = "Перемещение на " + currentTransport.toString();
                   } else {
                       desc = "не удалось покататься на " + currentTransport.toString();
                   }
                } else {
                    desc = "Человек устал крутить педали";
                }
            } else {
                if (currentTransport.move(distanse, terrain, currentTransport)) {
                    desc = "Перемещение на " + currentTransport.toString();
                } else {
                    desc = "не удалось покататься на " + currentTransport.toString();
                }
            }
            System.out.println(desc);
        }
        return true;
    }

}
