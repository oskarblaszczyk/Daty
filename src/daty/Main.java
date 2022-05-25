package daty;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.YearMonth;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Date data = new Date();

        // dzien
        System.out.println(data.getDate());

        // dzien
        System.out.println(data.getDay());

        SimpleDateFormat sd = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        System.out.println(sd.format(data));

        Calendar calendar = Calendar.getInstance();


        // Instant, czyli punkt w czasie
        Instant instant = Instant.now();
        System.out.println(instant);

        //stworzenie instanta ze stringa, T format
        Instant inst = Instant.parse("2020-03-12T15:22:17Z");
        System.out.println("Ze Stringa: " + inst);
        System.out.println("----");

        //LocalDate sluzy do obslugi dat bez czasu z prostym definiowanym stref czasowych

        LocalDate now = LocalDate.now();
        System.out.println("Now: " + now);

        System.out.println("Dzień słownie: " + now.getDayOfWeek());
        System.out.println("Dzień liczbowo " + now.getDayOfMonth());
        System.out.println();

        System.out.println("Miesiąc słownie: " + now.getMonth());
        System.out.println("Miesiąc liczbowo: " + now.getMonthValue());
        System.out.println();

        System.out.println("Dzień roku: " + now.getDayOfYear());
        System.out.println("Rok: " + now.getYear());
        System.out.println();

        // Porównanie dwóch dat - czy data java8FirstRelease jest przed bieżącą datą:
        LocalDate date1 = LocalDate.of(2005, 12, 13);
        LocalDate date2 = LocalDate.of(2003, 11, 17);

        //isBefore zwraca true jesli data1 jest wczesniej niz date2
        System.out.println("Czy jest wczesniej? " + date1.isBefore(date2));

        //isAfter zwraca true jesli data1 jest pozniej niz date2
        System.out.println("Czy jest pozniej? " + date1.isAfter(date2));

        //jutrzejsza data
        System.out.println("Jutrzejsza data: " + now.plusDays(1));

        //data 2 tygodnie pozniej
        System.out.println("2 tygodnie póniej: " + now.plusWeeks(2));

        //data 2 miesiace pozniej
        System.out.println("2 miesiace pozniej: " + now.plusMonths(2));

        //data 5 lat pozniej
        System.out.println("5 lat pozniej: " + now.plusYears(5));

        //wczorajsza data
        System.out.println("Wczorajsza data: " + now.minusDays(1));

        //data 2 tygodnie wczesniej
        System.out.println("2 tygodnie wczesniej: " + now.minusWeeks(2));

        //data 2 miesiace wczesniej
        System.out.println("2 miesiace wczesniej: " + now.minusMonths(2));

        //data 5 lat wczesniej
        System.out.println("5 lat wczesniej: " + now.minusYears(5));

        System.out.println("Data 5 lat wczesniej: " + now.minus(5, ChronoUnit.YEARS));

        System.out.println("Data za 50 dni " + now.plus(50, ChronoUnit.DAYS));

        // Bieżąca data w strefie azjatyckiej - Tokio:
        //https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html
        LocalDate tokioDate = LocalDate.now(ZoneId.of("Asia/Tokyo"));
        System.out.println("Tokio:  " + tokioDate);

        // Data ze stringa:
        LocalDate fromString = LocalDate.parse("2014-03-18");
        System.out.println("Ze Stringa: " + fromString);


        //LocalTime - klasa reprezentujaca czas

        // Bieżący czas na podstawie zegara systemowego (domyślna strefa czasowa naszego systemu):
        LocalTime local = LocalTime.now();
        System.out.println(local);

        LocalTime all = LocalTime.of(20, 15, 30, 4455);
        System.out.println(all);

        LocalTime time = LocalTime.of(20, 15, 30);
        System.out.println(time);

        //czy localtme jest przed czasem biezacym
        System.out.println(time.isBefore(local));

        System.out.println("Hour: " + local.getHour());
        System.out.println("Minute: " + local.getMinute());
        System.out.println("Second: " + local.getSecond());
        System.out.println("Nano: " + local.getNano());


        //30 minut przed teraz
        System.out.println("30 minut temu " + local.minusMinutes(30));

        //Ostatnim typem "lokalnym" jest LocalDateTime, czyli połączenie dwóch poprzednich - LocalDate oraz LocalTime.
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("Wszystko naraz " + localDateTime);

        LocalDateTime startDateTime = LocalDateTime.of(2020, Month.APRIL, 21, 20, 15, 30);
        System.out.println(startDateTime);

        LocalDateTime startDateTimeParsed = LocalDateTime.parse("2020-04-21T20:15");
        System.out.println(startDateTimeParsed);

        System.out.println("Is startDateTimeParsed before localDateTime:");
        System.out.println(startDateTimeParsed.isBefore(localDateTime));

        // Pobranie godziny, minuty, sekundy oraz nanosekundy
        System.out.println("Hour: " + startDateTime.getHour());
        System.out.println("Minute: " + startDateTime.getMinute());
        System.out.println("Second: " + startDateTime.getSecond());
        System.out.println("Nano: " + startDateTime.getNano());

        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId europeWarsawZone = ZoneId.of("Europe/Warsaw");
        System.out.println("Zone name: " + europeWarsawZone.toString());
        System.out.println();

        //ZonedDateTime - biezaca data i czas na podstawie strefy czasowej
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);

        System.out.println(ZonedDateTime.now(ZoneId.of("Asia/Tokyo")));

        System.out.println("Hour: " + zonedDateTime.getHour());
        System.out.println("Minute: " + zonedDateTime.getMinute());
        System.out.println("Second: " + zonedDateTime.getSecond());
        System.out.println("Nano: " + zonedDateTime.getNano());

        // klasa Period reprezentujac aokres miedzy dwiema datami

        Period period = Period.of(1, 10, 5);
        System.out.println("Okres roku, 10 miesiecy i 5 dni " + period);

        LocalDate date3 = LocalDate.of(2005, 12, 13);
        LocalDate date4 = LocalDate.of(2003, 5, 17);

        System.out.println("Okres pomiędzy dwoma datami: " + Period.between(date3, date4));
        System.out.println("Okres pomiędzy dwoma datami: " + Period.between(date4, date3));

        Period period2 = Period.between(date4, date3);

        LocalDate dateBefore = LocalDate.of(2005, 11, 12);
        LocalDate dateAfter = LocalDate.of(2011, 10, 12);
        long daysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        System.out.println(daysBetween);

        // Duration roznica pomiedzy dwoma znacznikami czasowymi

        Instant startTime = Instant.now();
        for (int i = 0; i < 1; i++) {
            manipulateNumbers();
        }
        Instant endTime = Instant.now();

        System.out.println("Instant - Duration in millis:");
        System.out.println(Duration.between(startTime, endTime).toMillis());

        //formatery W Javie 8 dostajemy wbudowane formatery, jak również możemy tworzyć własne.
        LocalDateTime now3 = LocalDateTime.of(2020, Month.APRIL, 21, 5, 9, 33, 9991031);
        System.out.println("ISO_DATE: " + DateTimeFormatter.ISO_DATE.format(now3));
        System.out.println("ISO_DATE_TIME: " + DateTimeFormatter.ISO_DATE_TIME.format(now3));
        System.out.println("ISO_TIME: " + DateTimeFormatter.ISO_TIME.format(now3));

        LocalDateTime now4 = LocalDateTime.now();
        String fromat = "yyyy HH MM";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(fromat);
        System.out.println(dtf.format(now4));
    }

    private static void manipulateNumbers() {
        int sum = 0;
        for (int i = 0; i < 100000000; i++) {
            sum += i * 10;
            sum -= i / 20;
        }

    }
}
