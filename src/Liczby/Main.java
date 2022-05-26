package Liczby;

import java.io.*;
import java.math.BigInteger;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("liczby"));
        Random rand = new Random();
        for (int i = 0; i < 100; i++) {
            bw.write(Instant.now().toString() + "\t");
            for (int j = 0; j < 100; j++) {
                bw.write(String.valueOf(rand.nextInt(10)));
            }
            bw.write("\n");
        }
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader("liczby"));
        Instant pierwszyZapis = null;
        String line;
        String[] wartosci;
        BigInteger bigint = BigInteger.ZERO;
        while ((line = br.readLine()) != null) {
            wartosci = line.split("\t");
            if (bigint.equals(BigInteger.ZERO)) {
                pierwszyZapis = Instant.parse(wartosci[0]);
                bigint = bigint.add(new BigInteger(wartosci[1]));
            } else {
                bigint = bigint.multiply(new BigInteger(wartosci[1]));
            }
        }

        BufferedWriter bw2 = new BufferedWriter(new FileWriter("wynik"));
        bw2.write(bigint.toString());
        Instant zakonczenie = Instant.now();
        bw2.write(String.valueOf(Duration.between(pierwszyZapis, zakonczenie).toMillis()));
        bw2.close();
        System.out.println(Duration.between(pierwszyZapis, zakonczenie).toMillis());


    }
}
