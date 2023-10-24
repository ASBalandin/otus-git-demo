import ru.otus.balandinas.first.project.Terrain;
import ru.otus.balandinas.first.project.Transport;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
    }

    public boolean move(int distanse, Terrain terrain, Transport currTransport) {
        if (currTransport == null) {
            System.out.println("Идёт пешком");
        }
        return true;
    }
}
