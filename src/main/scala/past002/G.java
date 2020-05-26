package past002;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class G {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public G() {
        this(System.in, System.out);
    }

    public G(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int q = sc.nextInt();
        LinkedList<P> l = new LinkedList<>();
        for (int i = 0; i < q; i++) {
            int t = sc.nextInt();
            if (t == 1) {
                l.addLast(new P(sc.next().charAt(0), sc.nextInt()));
            } else {
                int d = sc.nextInt();
                int sum = 0;
                long[] cnts = new long[26];
                while (!l.isEmpty() && sum < d) {
                    P cur = l.removeFirst();
//                    debug(cur.c, cur.x, sum + cur.x, d);
                    if (sum + cur.x > d) {
                        cnts[cur.c] += d - sum;
                        cur.x = sum + cur.x - d;
                        sum = d;
                        l.addFirst(cur);
                    } else {
                        cnts[cur.c] += cur.x;
                        sum += cur.x;
                    }
                }
//                debug(cnts);
                long r = 0;
                for (int j = 0; j < 26; j++) {
                    r += cnts[j] * cnts[j];
                }
                out.println(r);
            }
        }

        out.flush();
    }

    class P {
        int c;
        int x;
        P(char c, int x) {
            this.c = c - 'a';
            this.x = x;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new G().run();
    }
}