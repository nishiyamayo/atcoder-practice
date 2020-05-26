package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class H {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public H() {
        this(System.in, System.out);
    }

    public H(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int h = sc.nextInt(), w = sc.nextInt();
        E[] es = new E[11];
        for (int i = 0; i < 11; i++) {
            es[i] = new E();
        }
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                switch (s.charAt(j)) {
                    case 'S':
                        es[0].add(new P(j, i));
                        break;
                    case 'G':
                        es[10].add(new P(j, i));
                        break;
                    default:
                        es[s.charAt(j) - '0'].add(new P(j, i));
                }
            }
        }

        ArrayList<P> cur = new ArrayList<>();
        cur.add(es[0].get(0));
        for (int i = 1; i < 11; i++) {
            ArrayList<P> next = new ArrayList<>();
            if (es[i].size() == 0) {
                out.println(-1);
                out.flush();
                return;
            }
            for (P p : es[i]) {
                int d = 1 << 28;
                for (P c : cur) {
                    d = Math.min(d, c.c + Math.abs(p.f - c.f) + Math.abs(p.s - c.s));
                }
                p.c = d;
                next.add(p);
            }
            cur = next;
        }

        out.println(cur.get(0).c);


        out.flush();
    }

    class E extends ArrayList<P> {
    }

    class P {
        int f;
        int s;
        int c;

        P(int f, int s) {
            this.f = f;
            this.s = s;
            this.c = 0;
        }

        P(int f, int s, int c) {
            this.f = f;
            this.s = s;
            this.c = c;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new H().run();
    }
}