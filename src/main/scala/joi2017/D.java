package joi2017;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
    int MAX = 50 * 1000;
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] l = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }

        HashMap<Pair, Integer> m = new HashMap<>();
        m.put(new Pair(0, 0), 0);

        for (int i = 0; i < n; i++) {
            HashMap<Pair, Integer> next = new HashMap<>();

            for (Map.Entry<Pair, Integer> entry: m.entrySet()) {

            }
        }
    }

    class Pair {
        int l, min;
        Pair (int l, int min) {
            this.l = l;
            this.min = min;
        }

        @Override
        public int hashCode() {
            return l * 100000 + min;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair o = (Pair) obj;
                return o.l == l && o.min == min;
            }
            return false;
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
