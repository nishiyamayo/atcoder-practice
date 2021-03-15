package arc112;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;
    Edge[] g;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int n = sc.nextInt();
        g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }
        for (int i = 1; i < n; i++) {
            int p = sc.nextInt() - 1;
            g[p].add(i);
        }

        Pair p = dfs(0);

        out.println(p.sum() % 2 == 0 ? p.s : p.f);

        out.flush();
    }

    Pair dfs(int p) {
        if (g[p].isEmpty()) {
            return new Pair(1, 0);
        }
        ArrayList<Pair> oddP = new ArrayList<>();
        ArrayList<Pair> goodP = new ArrayList<>();
        ArrayList<Pair> badP = new ArrayList<>();

        for (int i = 0; i < g[p].size(); i++) {
            Pair pair = dfs(g[p].get(i));
            if (pair.sum() % 2 == 0) {
                if (pair.f > pair.s) {
                    goodP.add(pair);
                } else {
                    badP.add(pair);
                }
            } else {
                oddP.add(pair);
            }
        }

//        debug(p, goodP, badP, oddP);

        Pair ret = new Pair(1, 0);
        for (Pair pair : goodP) {
            ret.f += pair.f;
            ret.s += pair.s;
        }

        Collections.sort(oddP);
        boolean odd = false;
        for (Pair pair : oddP) {
            if (odd) {
                ret.f += pair.s;
                ret.s += pair.f;
            } else {
                ret.f += pair.f;
                ret.s += pair.s;
            }
            odd = !odd;
        }
        for (Pair pair : badP) {
            if (odd) {
                ret.f += pair.f;
                ret.s += pair.s;
            } else {
                ret.f += pair.s;
                ret.s += pair.f;
            }
        }
        if (odd) {
            return new Pair(ret.s, ret.f);
        } else {
            return ret;
        }
    }

    class Pair implements Comparable<Pair> {
        int f, s;

        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }

        int sum() {
            return this.f + this.s;
        }

        @Override
        public String toString() {
            return "(" + f + ", " + s + ")";
        }

        @Override
        public int compareTo(Pair o) {
            return f - o.f;
        }
    }

    class Edge extends ArrayList<Integer> {
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
