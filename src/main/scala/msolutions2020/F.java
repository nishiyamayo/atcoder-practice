package msolutions2020;

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
        Point[] ps = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt(), y = sc.nextInt();
            char c = sc.next().charAt(0);
            ps[i] = new Point(x, y, c);
        }
        Arrays.sort(ps);

        long ans = 1L << 60;

        HashMap<Integer, Point> U = new HashMap<>(), D = new HashMap<>(), R1 = new HashMap<>(), R2 = new HashMap<>();
        HashMap<Integer, Integer> UY = new HashMap<>(), RX = new HashMap<>();

        for (Point p : ps) {
            int yy = p.y - p.x;
            switch (p.d) {
                case 'U':
                    if (R1.containsKey(p.y + p.x)) {
                        Point t = R1.get(p.y + p.x);
                        ans = Math.min(ans, Math.abs(p.x - t.x) * 10);
                    }
                    U.put(p.y - p.x, p);
                    UY.put(p.x, p.y);
                    break;
                case 'D':
                    if (R2.containsKey(p.y - p.x)) {
                        Point t = R2.get(p.y - p.x);
                        ans = Math.min(ans, Math.abs(p.x - t.x) * 10);
                    }
                    if (UY.containsKey(p.x)) {
                        int y = UY.get(p.x);
                        ans = Math.min(ans, Math.abs(p.y - y) * 5);
                    }
                    D.put(p.y + p.x, p);
                    break;
                case 'L':
                    if (D.containsKey(p.y + p.x)) {
                        Point t = D.get(p.y + p.x);
                        ans = Math.min(ans, Math.abs(p.x - t.x) * 10);
                    }
                    if (U.containsKey(p.y - p.x)) {
                        Point t = U.get(p.y - p.x);
                        ans = Math.min(ans, Math.abs(p.x - t.x) * 10);
                    }
                    if (RX.containsKey(p.y)) {
                        int x = RX.get(p.y);
                        ans = Math.min(ans, Math.abs(p.x - x) * 5);
                    }
                    break;
                case 'R':
                    R1.put(p.y + p.x, p);
                    R2.put(p.y - p.x, p);
                    RX.put(p.y, p.x);
            }
        }

        out.println(ans == 1L << 60 ? "SAFE" : "" + ans);

        out.flush();
    }

    class Point implements Comparable<Point> {
        int x, y;
        char d;
        Point(int x, int y, char d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            if (x != o.x) {
                return x - o.x;
            }
            return y - o.y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + d + ")";
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}