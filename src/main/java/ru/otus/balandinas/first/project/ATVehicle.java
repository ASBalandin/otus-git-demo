package ru.otus.balandinas.first.project;

public class ATVehicle implements Transport{
    private float fuelLevel;
    private float consumption;

    public ATVehicle(float fuelLevel) {
        this.fuelLevel = fuelLevel;
        this.consumption = 20.0f;
    }

    @Override
    public boolean move(int distanse, Terrain terrain, Transport currTransport) {
        if (((float) distanse / 100.0) * consumption <= fuelLevel) {
            fuelLevel -= ((float) distanse / 100) * consumption;
            System.out.println(" в баке вездехода осталось " + fuelLevel);
            return true;
        } else {
            System.out.println("Вездеходу не хватит топлива!");
        }
        return false;
    }

    @Override
    public String toString() {
        return "вездеходе";
    }
}
