package zemicon2;

import zemicon.D;

import java.util.*;

public class F {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), x = sc.nextInt();
        E[] g = new E[n];
        for (int i = 0; i < n; i++) g[i] = new E();

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            g[b].add(a);
        }


    }

    class E extends ArrayList<Integer> {}

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
