package ru.otus.balandinas.first.project;

public class Horse implements Transport {
    private float endurence;
    private float endur_force;

    public Horse(int endurence) {
        this.endurence = endurence;
        this.endur_force = 1.0f;
    }

    @Override
    public boolean move(int distanse, Terrain terrain, Transport currTransport) {
        if ((terrain == Terrain.PLAIN || terrain == Terrain.FOREST) && (endurence - distanse * endur_force >= 0)) {
            endurence -= distanse * endur_force;
            System.out.println("остаток сил " + endurence);
            return true;
        } else if (terrain == Terrain.PLAIN || terrain == Terrain.FOREST) {
            System.out.println("У лошади не хватит выносливости!");
        } else {
            System.out.println("Недопустимый для лошади вид местности");
        }
        return false;
    }
    @Override
    public String toString() {
        return "лошади";
    }
}
