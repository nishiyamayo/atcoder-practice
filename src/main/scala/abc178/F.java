package abc178;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public F() {
        this(System.in, System.out);
    }

    public F(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        int[] cnta = new int[n + 1];
        int[] cntb = new int[n + 1];
        int[] a = new int[n + 1];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            cnta[a[i]]++;
        }
        for (int i = 0; i < n; i++) {
            cntb[sc.nextInt()]++;
        }

        boolean ok = true;
        for (int i = 0; i < n; i++) {
            if (cnta[i] > n / 2 && cntb[i] > n / 2) {
                ok = false;
            }
        }

        if (ok) {
            out.println("Yes");
            ArrayList<Pair> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (cntb[i] == 0) continue;
                arr.add(new Pair(i, cntb[i]));
            }
            Collections.sort(arr);

            ArrayList<Tuple> target = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                target.add(new Tuple(i, a[i], cnta[a[i]]));
            }

            Collections.sort(target);


            int[] ans = new int[n];

            int cur = 1;
            int len = arr.size();
            for (Tuple t : target) {
                Pair p = arr.get(cur);
                debug(t.i, t.idx, t.cnt, p.idx, p.cnt);
                ans[t.i] = p.idx;
                p.cnt--;
                if (p.cnt == 0) {
                    cur++;
                    if (cur == len) cur = 0;
                }
            }

            out.print(ans[0]);
            for (int i = 1; i < n; i++) {
                out.print(" " + ans[i]);
            }
            out.println();

        } else {
            out.println("No");
        }

        out.flush();
    }

    class Tuple implements Comparable<Tuple> {
        int i, idx, cnt;
        Tuple(int i, int idx, int cnt) {
            this.i = i;
            this.idx = idx;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Tuple o) {
            if (o.cnt != cnt) {
                return o.cnt - cnt;
            }
            if (idx != o.idx) {
                return idx - o.idx;
            }
            return i - o.i;
        }
    }

    class Pair implements Comparable<Pair> {
        int idx, cnt;
        Pair(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }


        @Override
        public int compareTo(Pair o) {
            if (o.cnt != cnt) {
                return o.cnt - cnt;
            }
            return idx - o.idx;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}