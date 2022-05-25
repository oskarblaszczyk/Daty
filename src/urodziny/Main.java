package urodziny;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Main {
    private static final DateTimeFormatter dtr = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        //Poproś program aby zapytal Cię o datę Twojego urodzenia
        //- jeśli podałeś datę późniejszą niż dziś to niech program rzuci
        //   błędem: InvalidBirthDateException
        //- program wypisuje ile dni żyjesz już
        //- program wypisuje ile już miesiecy żyjesz
        //- program wypisuje już ile lat żyjesz
        //- program wypisuje w który dzień tygodnia się urodziłeś

        String input = "12-03-2022";
        LocalDate data = null;
        try {
           data = LocalDate.parse(input, dtr);
        }catch (DateTimeParseException e){
            System.out.println("Zly format daty");
        }
        System.out.println(data);
        czyPozniej(data);
        System.out.println(ileDni(data));

        /*
         * Stwórz klase Osoba, która ma imie, nazisko, pesel (na jego podstawie tworzymy
         * date urodzenia). Stwórz klase Lokal, który ma nazwe, miejsce i minimalny wiek
         * zeby wejsc.
         *
         * Przy próbie wejscia, jesli osoba sie nie łapie na minimalny wiek (ustalamy go
         * z peselu podanego jako string) rzuc wyjatkiem ze jestesZaMlodyZiom().
         */

        // 1 ETAP stworz sobie jakis plik z liczbami, kazda linia w pliku ma zawierac
        // jakas
        // liczbe ktora ma np: 100 znakow niech plik ma 100 linii(randomowe liczby, rozne od siebie), ale
        // przed linia ma byc zapisana godzina zapisu (z dokladnoscia co do milisekund)
        // 2 ETAP Wczytaj te liczby z pliku i zapisz iloczyn tych liczb do pliku
        // wynik.txt a na
        // koncu masz zapisac ile trwały wszystkie obliczenia :)

        //Stworz praconwika imie, data urodzenia
        //Znajdz najmlodszego Pracownika
        //Znajdz pracownikow ktorzy sa urodzeni po 11.04.2003
        //Posortuj pracownikow po datach urodzenia


        /*
         * Stwórz klasę gracz (imię, nazwisko, nick)
         * Stworz klasę turniej. Musimy przechowywac nazwe, wpisowe, data, punkty
         *
         * Gracz dostaje punkty za dane miejsce w turnieju, w roznych turniejach moga byc rozne ilosci
         * punktow za rozne miejsca.
         *
         *
         * Napisz metode która znajduje najlepszego gracza z danego miesiąca.
         * Napisz metode ktora znajduje najlepszego gracza z danego okresu czasu.
         * Napisz metode ktora znajduje graczy z danego okresu czasu.
         * Napisz metoda która zwraca liste graczy którzy zajeli 1 miejsce przynajmniej w dwoch roznych miesiącach
         */


    }

    private static void czyPozniej(LocalDate data){
        if(data.isAfter(LocalDate.now())){
            throw new InvalidBirthDateException("Podana data jest pozniejsza");
        }
    }
    private static long ileDni(LocalDate data){
        return ChronoUnit.DAYS.between(LocalDate.now(), data);
    }

}
