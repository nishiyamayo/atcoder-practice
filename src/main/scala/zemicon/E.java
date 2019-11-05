package zemicon;


import java.util.*;

public class E {
    int MAX = 100000;
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), C = sc.nextInt();
        int[][] m = new int[MAX + 5][C];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt(), t = sc.nextInt(), c = sc.nextInt() - 1;

            m[s - 1][c] += 1;
            m[t][c] += -1;
        }

        for (int i = 1; i <= MAX; i++) {
            for (int c = 0; c < C; c++) {
                m[i][c] += m[i - 1][c];
            }
        }
        int max = 0;
        for (int i = 0; i <= MAX; i++) {
            int cnt = 0;
            for (int c = 0; c < C; c++) {
                if (m[i][c] > 0)cnt++;
            }
            max = Math.max(cnt, max);
        }
        for (int[] a: m) debug(a);
        System.out.println(max);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
