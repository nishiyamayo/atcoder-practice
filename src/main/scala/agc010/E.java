package agc010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        Edge[] g = new Edge[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Edge();
        }

        for (int a = 0; a < n; a++) for (int b = a + 1; b < n; b++) {
            if (gcd(ar[a], ar[b]) != 1) {
                g[a].add(b);
                g[b].add(a);
            }
        }

    }

    void solve(int n, int[] ar, boolean[] visited, Edge[] g) {
        Optional<Integer> st = findV(n, visited, g);

    }

    Optional<Integer> findV(int n, boolean[] visited, Edge[] g) {
        for (int i = 0; i < n; i++) if (!visited[i] && !g[i].isEmpty()){
            return Optional.of(i);
        }
        return Optional.empty();
    }

    class P implements Comparable<P> {
        int v, c;
        P(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(P o) {
            return c - o.c;
        }
    }

    class Edge extends ArrayList<Integer> {}

    int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        new E().run();
    }
}
