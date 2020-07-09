package past003;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class K {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public K() {
        this(System.in, System.out);
    }

    public K(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), q = sc.nextInt();
        Desk[] desks = new Desk[n];
        Cont[] conts = new Cont[n];
        for (int i = 0; i < n; i++) {
            desks[i] = new Desk();
            conts[i] = new Cont(i);
            desks[i].cont = Optional.of(conts[i]);
        }

        for (int i = 0; i < q; i++) {
            int f = sc.nextInt() - 1, t = sc.nextInt() - 1, x = sc.nextInt() - 1;
            if (desks[t].cont.isPresent()) {
                debug("pre", f, t, x);
                Cont next = desks[t].cont.get();
                desks[t].cont = desks[f].cont;
                desks[f].cont = conts[x].pre;
                next.pre = Optional.of(conts[x]);
            } else {
                debug("not pre", f, t, x);
                desks[t].cont = desks[f].cont;
                desks[f].cont = conts[x].pre;
                conts[x].pre = Optional.empty();
            }
        }

        debug(conts);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (desks[i].cont.isPresent()) {
                Cont t = desks[i].cont.get();
                debug(i, t.idx);
                ans[t.idx] = i + 1;
                while (t.pre.isPresent()) {
                    t = t.pre.get();
                    ans[t.idx] = i + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            out.println(ans[i]);
        }

        out.flush();
    }

    class Cont {
        Optional<Cont> pre = Optional.empty();
        int idx;
        Cont(int idx) {
            this.idx = idx;
        }

        @Override
        public String toString() {
            if (pre.isPresent()) {
                return "(idx: " + idx + ", pre: " + pre.get().idx + ")";
            }
            return "(idx: " + idx + ")";
        }
    }
    class Desk {
        Optional<Cont> cont = Optional.empty();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new K().run();
    }
}
/*
10 20
3 6 3
6 5 6
10 8 10
5 7 3
1 3 1
4 10 4
5 4 6
10 7 4
7 9 3
9 8 4
8 1 4
3 7 1
2 3 2
9 8 3
8 1 10
8 2 8
9 10 9
2 1 8
4 9 6
1 7 4
 */