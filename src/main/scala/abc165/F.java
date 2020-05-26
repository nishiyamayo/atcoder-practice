package abc165;

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
    int[] a;
    Edge[] g;

    int[] ans;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = sc.nextInt();
        a = new int[n];
        g = new Edge[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            g[i] = new Edge();
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
            g[u].add(v);
            g[v].add(u);
        }

        dfs(0, -1, 0, new int[n]);

        for (int i = 0; i < n; i++) {
            out.println(ans[i]);
        }

        out.flush();
    }

    void dfs(int cur, int par, int len, int[] lis) {
        int x = a[cur];
        if (len == 0 || lis[len - 1] < x) {
            int tmp = lis[len];
            lis[len] = x;
            ans[cur] = len + 1;
            for (int next : g[cur]) {
                if (next == par) continue;
                dfs(next, cur, len + 1, lis);
            }
            lis[len] = tmp;
        } else {
            int r = lowerBound(lis, x, len);
            int tmp = lis[r];
            lis[r] = x;
            ans[cur] = len;
            for (int next : g[cur]) {
                if (next == par) continue;
                dfs(next, cur, len, lis);
            }
            lis[r] = tmp;
        }
    }

    public int upperBound(int[] array, int value, int size) {
        int left = -1;
        int right = size;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] > value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }


    public int lowerBound(int[] array, int value, int size) {
        int left = -1;
        int right = size;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }
    
    class Edge extends ArrayList<Integer> {};

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}