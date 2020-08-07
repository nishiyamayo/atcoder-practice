package abc054;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class C {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public C() {
        this(System.in, System.out);
    }

    public C(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), m = sc.nextInt();
        boolean[][] edges = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            edges[a][b] = edges[b][a] = true;
        }

        Permutation perm = new Permutation(n);

        int cnt = 0;
        for (int[] next: perm) {
            if (next[0] != 0) continue;
            boolean ok = true;
            for (int i = 0; i < n - 1; i++) {
                ok &= edges[next[i]][next[i + 1]];
            }
            if (ok) cnt++;
        }
        out.println(cnt);

        out.flush();
    }

    public class Permutation implements Iterator<int[]>, Iterable<int[]> {
        private final int size;

        public Permutation(int size) {
            if (size <= 0) throw new IllegalArgumentException();
            this.size = size;
            source = new int[size];
            for (int i = 0; i < size; i++) {
                source[i] = i;
            }
        }

        public Permutation(int size, int[] source) {
            this(size);
            this.source = source;
        }

        int[] source;
        boolean isFirst = true;

        public boolean hasNext() {
            if (isFirst) {
                isFirst = false;
                return true;
            }

            int n = source.length;
            for (int i = n - 1; i > 0; i--) {
                if (source[i - 1] < source[i]) {
                    int j = n;
                    while (source[i - 1] >= source[--j]);
                    swap(source, i - 1, j);
                    reverse(source, i, n);
                    return true;
                }
            }
            reverse(source, 0, n);
            return false;
        }

        public int[] next() {
            int[] ret = new int[size];
            System.arraycopy(source, 0, ret, 0, size);
            return ret;
        }

        private void swap(int[] is, int i, int j) {
            int t = is[i];
            is[i] = is[j];
            is[j] = t;
        }

        private void reverse(int[] is, int s, int t) {
            while (s < --t) swap(is, s++, t);
        }

        @Override
        public Iterator<int[]> iterator() {
            return this;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}