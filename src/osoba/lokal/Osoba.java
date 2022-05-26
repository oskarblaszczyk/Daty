package osoba.lokal;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

public class Osoba {
    private String imie;
    private String nazwisko;
    private final String pesel;
    private final LocalDate dataUrodzenia;
    private Lokal lokal;

    public Osoba(String imie, String nazwisko, String pesel) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = setPesel(pesel);
        dataUrodzenia = dataUrodzenia();
    }

    private LocalDate dataUrodzenia() {
        DateTimeFormatter dtr = DateTimeFormatter.ofPattern("yyyy-M-d");
        String data = "";
        int  rok =Integer.parseInt(getPesel().substring(0, 2));
        int miesiac = Integer.parseInt(getPesel().substring(2, 4));
        int dzien = Integer.parseInt(getPesel().substring(4, 6));
        if (miesiac < 13) {
            rok +=1900;
            data = String.valueOf(rok) + "-" + String.valueOf(miesiac) + "-" + String.valueOf(dzien);

        } else if (miesiac > 20 && miesiac < 33) {
            rok += 2000;
            miesiac -= 20;
            data = String.valueOf(rok) + "-" + String.valueOf(miesiac) + "-" + String.valueOf(dzien);
        }
        System.out.println(data);
        LocalDate data1 = null;
        try {
            data1 = LocalDate.parse(data, dtr);
        } catch (DateTimeParseException e) {
            System.out.println("Zly format daty");
        }
        return data1;
    }

    public void idzDoLokalu(Lokal lokal) {
        if (ChronoUnit.YEARS.between(dataUrodzenia, LocalDate.now()) < lokal.getMinimalnyWiek()) {
            System.out.println(ChronoUnit.YEARS.between(dataUrodzenia, LocalDate.now()));
            throw new JestesZaMlodyZiom("Jestes za mlody");
        }
        setLokal(lokal);
        lokal.getOsoby().add(this);
    }

    private String setPesel(String pesel){
        Pattern pat = Pattern.compile("[0-9]{11}");
        if(!pat.matcher(pesel).matches()){
            throw new IllegalArgumentException("Zly format Pesel");
        }
        return pesel;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public LocalDate getDataUrodzenia() {
        return dataUrodzenia;
    }

    public Lokal getLokal() {
        return lokal;
    }

    public void setLokal(Lokal lokal) {
        this.lokal = lokal;
    }
}
