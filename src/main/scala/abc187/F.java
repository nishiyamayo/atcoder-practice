package abc187;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class F {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;
    int n;
    int[] edges;
    boolean[] completelyConnected;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);
        n = sc.nextInt();
        int m = sc.nextInt();
        edges = new int[n];
        completelyConnected = new boolean[1 << n];

        for (int i = 0; i < n; i++) {
            edges[i] = 1 << i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            edges[a] |= 1 << b;
            edges[b] |= 1 << a;
        }

        for (int i = 1; i < (1 << n); i++) {
            completelyConnected[i] = complete(i);
        }

        memo = new int[1 << n];
        Arrays.fill(memo, -1);

        out.println(solve((1 << n) - 1));

        out.flush();
    }

    int[] memo;
    int solve(int S) {
//        debug(Integer.toBinaryString(S));
        if (memo[S] >= 0) return memo[S];
        if (completelyConnected[S]) {
//            debug(Integer.toBinaryString(S), 1, "complete");
            return memo[S] = 1;
        }
        memo[S] = n;

        int bc = Integer.bitCount(S);

        int ret = n;
        for (int j = S; j > 0;) {
            int t = j;
            int s = S ^ t;
            j--;
            j &= S;
//            debug(Integer.toBinaryString(s), Integer.toBinaryString(t));
            ret = Math.min(ret, solve(s) + solve(t));
        }

//        debug(Integer.toBinaryString(S), ret);
        return memo[S] = ret;
    }

    int makeState(int S, int mask, int bc) {
        int curS = 0;

        int ret = 0;
        for (int i = 0; i < bc; i++) {
            while (((S >> curS) & 1) == 0) curS++;
            ret |= ((mask >> i) & 1) << curS;
            curS++;
        }

        return ret;
    }

    boolean complete(int S) {
        int connected = (1 << n) - 1;
        for (int i = 0; i < n; i++) {
            if (((S >> i) & 1) == 1) connected &= edges[i];
        }
        return (S & connected) == S;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
