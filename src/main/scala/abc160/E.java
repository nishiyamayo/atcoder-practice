package abc160;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class E {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public E() {
        this(System.in, System.out);
    }

    public E(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int x = sc.nextInt(), y = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        PriorityQueue<Node> q = new PriorityQueue<>();
        int xy = x + y;

        for (int i = 0; i < a; i++) {
            q.add(new Node(sc.nextInt(), 0));
        }
        for (int i = 0; i < b; i++) {
            q.add(new Node(sc.nextInt(), 1));
        }
        for (int i = 0; i < c; i++) {
            q.add(new Node(sc.nextInt(), 2));
        }

        long ans = 0;
        while (xy > 0) {
            Node cur = q.remove();
            switch (cur.type) {
                case 0:
                    if (x > 0) {
                        ans += cur.v;
                        x--;
                        xy--;
                    }
                    break;
                case 1:
                    if (y > 0) {
                        ans += cur.v;
                        y--;
                        xy--;
                    }
                    break;
                case 2:
                    ans += cur.v;
                    xy--;
            }
        }

        out.println(ans);
        out.flush();
    }

    class Node implements Comparable<Node> {

        long v;
        int type;
        Node(long v, int type) {
            this.v = v;
            this.type = type;
        }

        @Override
        public int compareTo(Node o) {
            if (v == o.v) {
                return type - o.type;
            }
            return Long.compare(o.v, v);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}