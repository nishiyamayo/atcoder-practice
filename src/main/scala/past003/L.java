package past003;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class L {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public L() {
        this(System.in, System.out);
    }

    public L(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt();
        Prds[] ps = new Prds[n];
        PriorityQueue<Prd> q1 = new PriorityQueue<>();
        PriorityQueue<Prd> q2 = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            ps[i] = new Prds();
            int k = sc.nextInt();
            for (int j = 0; j < k; j++) {
                int t = sc.nextInt();
                ps[i].add(new Prd(j, t));
            }
            for (int j = 1; j < k - 1; j++) {
                ps[i].get(j).pre = Optional.of(ps[i].get(j - 1));
                ps[i].get(j).next = Optional.of(ps[i].get(j + 1));
            }
            q1.add(ps[i].get(0));
            q2.add(ps[i].get(0));
            ps[i].get(0).enq1 = true;
            ps[i].get(0).enq2 = true;
            if (k > 1) {
                ps[i].get(0).next = Optional.of(ps[i].get(1));
                ps[i].get(k - 1).pre = Optional.of(ps[i].get(k - 2));
                q2.add(ps[i].get(1));
                ps[i].get(1).enq2 = true;
            }
        }

        int cur1 = 1, cur2 = 2;
        
        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            if ( a == 1) {
                Prd p = q1.remove();
                while (p.used) {
                    p = q1.remove();
                }
                out.println(p.t);
                p.used = true;
                p.next.ifPresent(next -> {
                    Prd nx = next;
                    while (nx.used) {
                        if (!nx.next.isPresent()) {
                            break;
                        }
                        nx = nx.next.get();
                    }
                    if (!nx.used) {
                        nx.enq1 = true;
                        q1.add(nx);
                    }
                });


                call(out, q1);
            } else {
                Prd p = q2.remove();
                while (p.used) {
                    p.next.ifPresent(next -> {
                        q2.add(next);
                        q1.add(next);
                    });
                    p = q2.remove();
                }
                out.println(p.t);
                p.used = true;
                p.next.ifPresent(next -> q2.add(next));
            }
        }

        out.flush();
    }

    private void call(PrintWriter out, PriorityQueue<Prd> q2) {
    }

    class Prds extends ArrayList<Prd> {}

    class Prd implements Comparable<Prd> {
        int idx, t;
        boolean enq1, enq2;
        boolean used;
        Optional<Prd> pre = Optional.empty();
        Optional<Prd> next = Optional.empty();
        Prd(int idx, int t) {
            this.idx = idx;
            this.t = t;
            this.used = enq1 = enq2 = false;
        }

        @Override
        public int compareTo(Prd o) {
            if (used) {
                return 1;
            }
            if (o.used) {
                return 1;
            }
            return o.t - t;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new L().run();
    }
}