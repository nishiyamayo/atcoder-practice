package abc188;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in = System.in;
    OutputStream out = System.out;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        int n = sc.nextInt(), C = sc.nextInt();

        TreeMap<Integer, LinkedList<Integer>> m = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            LinkedList<Integer> la = m.getOrDefault(a, new LinkedList<>());
            la.addLast(c);
            m.put(a, la);
            LinkedList<Integer> lb = m.getOrDefault(b + 1, new LinkedList<>());
            lb.addFirst(-c);
            m.put(b + 1, lb);
        }

        long ans = 0;
        long sum = 0;
        int cur = 0;
        for (Map.Entry<Integer, LinkedList<Integer>> entry: m.entrySet()) {
            for (Integer cost: entry.getValue()) {
                sum += cost;
            }
            ans += Math.min(sum, C) * (entry.getKey() - cur);
            cur = entry.getKey();
        }

        out.println(ans);


        out.flush();
    }

    class Ev {
        int type;
        int value;
        Ev(int type, int value) {
            this.type = type;
            this.value = value;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
