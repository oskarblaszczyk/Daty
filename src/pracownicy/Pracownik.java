package pracownicy;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pracownik {
    private String imie;
    private String dataUrodzenia;
    private List<Pracownik> ekstensja = new ArrayList<>();

    public Pracownik(String imie, String dataUrodzenia) {
        this.imie = imie;
        this.dataUrodzenia = dataUrodzenia;
        ekstensja.add(this);
    }

    public static Pracownik najmlodszy(List<Pracownik> p) {
        if (p == null || p.isEmpty()) {
            throw new NullPointerException("Lista pracownikow pusta");
        }
        Pracownik najmlodszy = p.get(0);
        for (Pracownik pracownik : p) {
            if (najmlodszy.getDataUrodzenia().isAfter(pracownik.getDataUrodzenia())) {
                najmlodszy = pracownik;
            }
        }
        return najmlodszy;
    }

    public static List<Pracownik> urodzeniPoData(List<Pracownik> pracownicy, LocalDate data) {
        if (pracownicy == null) {
            throw new NullPointerException("lista jest nullem");
        }
        List<Pracownik> wynik = new ArrayList<>();
        for (Pracownik p : pracownicy) {
            if (p.getDataUrodzenia().isAfter(data)) {
                wynik.add(p);
            }
        }
        return wynik;
    }

    public static List<Pracownik> posortowani(List<Pracownik> pracownicy){
        if (pracownicy == null) {
            throw new NullPointerException("lista jest nullem");
        }
        List<Pracownik> wynik = new ArrayList<>(pracownicy);
        Collections.sort(wynik, Comparator.comparing(Pracownik::getDataUrodzenia));
        return wynik;
    }

    private LocalDate getDataUrodzenia() {
        return LocalDate.parse(dataUrodzenia);
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }


    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    @Override
    public String toString() {
        return "Pracownik{" +
                "imie='" + imie + '\'' +
                ", dataUrodzenia='" + dataUrodzenia + '\'' +
                '}';
    }
}
