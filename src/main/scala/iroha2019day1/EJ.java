package iroha2019day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EJ {

    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), a = sc.nextLong();
        int b = sc.nextInt();

        ArrayList<Long> ds = new ArrayList<>();

        for (int i = 0; i < b; i++) ds.add(sc.nextLong());
        ds.add(0L);

        Collections.sort(ds);

        long sum = 0;
        int len = ds.size();
        for (int i = 1; i < len; i++) {
            sum += (ds.get(i) - ds.get(i - 1) - 1) / a + 1;
        }
        sum += (n - ds.get(len - 1)) / a;

        System.out.println(n - sum);
    }

    public static void main(String[] args) {
        new EJ().run();
    }
}
