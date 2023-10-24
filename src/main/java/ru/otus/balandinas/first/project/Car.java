package ru.otus.balandinas.first.project;

public class Car implements Transport {
    private float fuelLevel;
    private float consumption;

    public Car(float fuelLevel) {
        this.fuelLevel = fuelLevel;
        this.consumption = 8.0f;
    }

    @Override
    public boolean move(int distanse, Terrain terrain, Transport currTransport) {
        if (terrain == Terrain.plain && ((float) distanse / 100.0) * consumption <= fuelLevel) {
            fuelLevel -= ((float) distanse / 100) * consumption;
            System.out.println(" в баке авто осталось " + fuelLevel);
            return true;
        } else if (terrain == Terrain.plain) {
            System.out.println("Авто не хватит топлива!");
        } else {
            System.out.println("Недопустимый для авто вид местности");
        }
        return false;
    }

    @Override
    public String toString() {
        return "авто";
    }
}
