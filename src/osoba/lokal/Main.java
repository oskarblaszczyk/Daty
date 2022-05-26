package osoba.lokal;

public class Main {
    public static void main(String[] args) {
        /*
         * Stwórz klase Osoba, która ma imie, nazisko, pesel (na jego podstawie tworzymy
         * date urodzenia). Stwórz klase Lokal, który ma nazwe, miejsce i minimalny wiek
         * zeby wejsc.
         *
         * Przy próbie wejscia, jesli osoba sie nie łapie na minimalny wiek (ustalamy go
         * z peselu podanego jako string) rzuc wyjatkiem ze jestesZaMlodyZiom().
         */

        Osoba o1 = new Osoba("Jan", "Kowalski", "08290502219");
        System.out.println(o1.getDataUrodzenia());
        Lokal l1 = new Lokal("Remiza", "Giebultow");
        o1.idzDoLokalu(l1);
    }
}
