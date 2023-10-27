package ru.otus.balandinas.first.project;

public class Bike implements Transport {
    @Override
    public boolean move(int distanse, Terrain terrain, Transport currTransport) {
        if (terrain == Terrain.PLAIN || terrain == Terrain.FOREST)  {
            return true;
        } else {
            System.out.println("Недопустимый для велосипеда вид местности");
        }
        return false;
    }
    @Override
    public String toString() {
        return "велосипеде";
    }
}
