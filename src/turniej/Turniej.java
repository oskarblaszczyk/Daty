package turniej;

import java.time.LocalDate;

public class Turniej {
    private String nazwa;
    private double wpisowe;
    private LocalDate data;
    private int punkty;

    public Turniej(String nazwa, LocalDate data) {
        this.nazwa = nazwa;
        this.data = data;
    }


}
