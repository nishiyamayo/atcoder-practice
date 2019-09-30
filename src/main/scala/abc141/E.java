package abc141;

import java.util.*;

public class E {
    long MLT1 = 1009;
    long MLT2 = 1007;
    long MOD1 = 1000000007;
    long MOD2 = 1000000009;
    long PAIR = 261;
//    long MLT1 = 11;
//    long MLT2 = 13L;
//    long MOD1 = 23L;
//    long MOD2 = 31L;
//    long PAIR = 59;

    long[] rh1;
    long[] rh2;
    long[] pow1;
    long[] pow2;
    int n;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        String s = " " + sc.next();
        rh1 = new long[n + 1];
        rh2 = new long[n + 1];
        pow1 = new long[n + 1];
        pow2 = new long[n + 1];

        pow1[0] = pow2[0] = 1;

        for (int i = 1; i <= n; i++) {
            rh1[i] = (rh1[i - 1] * MLT1 + (s.charAt(i) - 'a' + 1)) % MOD1;
            rh2[i] = (rh2[i - 1] * MLT2 + (s.charAt(i) - 'a' + 1)) % MOD2;
            pow1[i] = pow1[i - 1] * MLT1 % MOD1;
            pow2[i] = pow2[i - 1] * MLT2 % MOD2;
        }

//        debug(rh1);
//        debug(rh2);

        long ans = 0;
        HashMap<Pair, long[]> map = new HashMap<>();
        for (int i = 1; i <= n / 2; i++) {
            map.clear();
            for (int j = 0; j <= n - i; j++) {
                long[] g = get(j, j + i);
                Pair p = new Pair(g[0], g[1]);
                long[] set =  map.getOrDefault(p, new long[]{n, 0});
                set[0] = Math.min(set[0], j);
                set[1] = Math.max(set[1], j);
                map.put(p, set);
            }

//            debug(map);

            for (Map.Entry<Pair, long[]> entry : map.entrySet()) {
                if (entry.getValue()[0] != entry.getValue()[1]) {
                    if (entry.getValue()[1] - entry.getValue()[0] >= i) {
                        ans = i;
                    }
                }
            }
        }
        System.out.println(ans);
    }

    long[] get(int l, int r) {
        long t1 = ((rh1[r] - rh1[l] * pow1[r - l]) % MOD1 + MOD1) % MOD1;
        long t2 = ((rh2[r] - rh2[l] * pow2[r - l]) % MOD2 + MOD2) % MOD2;

        return new long[] {t1, t2};
    }

    class Pair implements Comparable<Pair> {
        long s1, s2;
        Pair(long s1, long s2) {
            this.s1 = s1;
            this.s2 = s2;
        }

        @Override
        public int compareTo(Pair o) {
            if (s1 != o.s1) {
                return Long.compare(s1, o.s1);
            }
            return Long.compare(s2, o.s2);
        }

        @Override
        public int hashCode() {
            return Long.hashCode(s1 * PAIR + s2);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                Pair o = (Pair) obj;
                return s1 == o.s1 && s2 == o.s2;
            }
            return false;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", s1, s2);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
