package abc175;

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

    int n;
    String[] s, sr;
    long[] c;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        s = new String[n];
        sr = new String[n];
        c = new long[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
            sr[i] = reverse(s[i]);
            c[i] = sc.nextInt();
        }

        out.println(dijkstra());

        out.flush();
    }

    long INF = 1L << 61;

    long dijkstra() {

        HashMap<String, Long> memo = new HashMap<>();
        PriorityQueue<Data> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (memo.getOrDefault(s[i], INF) > c[i]) {
                q.add(new Data(s[i], c[i], true));
                memo.put(s[i], c[i]);
            }
        }

//        debug(memo);

        while (!q.isEmpty()) {
            Data cur = q.remove();
//            debug(cur.s, cur.c, cur.rev, cur.getString());

            if (memo.get(cur.getString()) != cur.c) continue;
            if (ok(cur.s)) {
                return cur.c;
            }

            for (int i = 0; i < n; i++) {
                String target = cur.rev ? sr[i] : s[i];
                int nlen = target.length(), clen = cur.s.length();
                if (cur.s.startsWith(target)) {
                    String next = cur.s.substring(nlen);
                    if (memo.getOrDefault((cur.rev ? "" : "-") + next, INF) > cur.c + c[i]) {
                        Data d = new Data(
                                next,
                                cur.c + c[i],
                                cur.rev
                        );
                        q.add(d);
                        memo.put(d.getString(), d.c);
                    }
                } else if (target.startsWith(cur.s)) {
                    String next = target.substring(clen);
                    if (memo.getOrDefault((!cur.rev ? "" : "-") + next, INF) > cur.c + c[i]) {
                        Data d = new Data(
                                next,
                                cur.c + c[i],
                                !cur.rev
                        );
                        q.add(d);
                        memo.put(d.getString(), d.c);
                    }
                }
            }
        }

        return -1;
    }

    String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        int l = s.length();
        for (int i = 0; i < l; i++) {
            sb.append(s.charAt(l - i - 1));
        }
        return sb.toString();
    }

    boolean ok(String s) {
        int l = s.length();
        for (int i = 0; i < l; i++) {
            if (s.charAt(i) != s.charAt(l - i - 1)) return false;
        }
        return true;
    }


    class Data implements Comparable<Data> {

        long c;
        String s;
        boolean rev;

        Data(String s, long c, boolean rev) {
            this.s = s;
            this.c = c;
            this.rev = rev;
        }

        @Override
        public int compareTo(Data o) {
            return Long.compare(c, o.c);
        }

        String getString() {
            return (this.rev ? "" : "-") + this.s;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}