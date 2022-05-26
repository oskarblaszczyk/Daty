package osoba.lokal;

import java.util.ArrayList;
import java.util.List;

public class Lokal {
private String nazwa;
private final String miejsce;
private long minimalnyWiek = 18;
private List<Osoba> osoby = new ArrayList<>();

    public Lokal(String nazwa, String miejsce) {
        this.nazwa = nazwa;
        this.miejsce = miejsce;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public long getMinimalnyWiek() {
        return minimalnyWiek;
    }

    public List<Osoba> getOsoby() {
        return osoby;
    }
}
