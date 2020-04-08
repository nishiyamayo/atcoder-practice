package abc145;

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
        int n = sc.nextInt();
        int[] xs = new int[n], ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
            ys[i] = sc.nextInt();
        }

        Permutation per = new Permutation(n);

        int cnt = 0;
        double len = 0;
        for (int[] cur: per) {
            for (int i = 0; i < n - 1; i++) {
                len += dist(xs[cur[i]], ys[cur[i]], xs[cur[i + 1]], ys[cur[i + 1]]);
            }
            cnt++;
        }

        out.println(len / cnt);
        out.flush();
    }

    double dist(int x1, int y1, int x2, int y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;
        return Math.sqrt(dx * dx + dy * dy);
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
            return source;
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