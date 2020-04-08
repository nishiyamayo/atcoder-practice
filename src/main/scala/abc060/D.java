package abc060;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class D
{
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }

    int N;
    long W;
    long[][] a;
    int w1;

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        N = sc.nextInt();
        W = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        w1 = sc.nextInt();
        int v1 = sc.nextInt();
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(v1);
        map.put(w1, l1);

        for (int i = 1; i < N; i++) {
            int w = sc.nextInt(), v = sc.nextInt();
            ArrayList<Integer> l = map.getOrDefault(w, new ArrayList<>());
            l.add(v);
            map.put(w, l);
        }

        ArrayList<Integer> W1 = map.getOrDefault(w1, new ArrayList<>());
        ArrayList<Integer> W2 = map.getOrDefault(w1 + 1, new ArrayList<>());
        ArrayList<Integer> W3 = map.getOrDefault(w1 + 2, new ArrayList<>());
        ArrayList<Integer> W4 = map.getOrDefault(w1 + 3, new ArrayList<>());
        Collections.sort(W1, Collections.reverseOrder());
        Collections.sort(W2, Collections.reverseOrder());
        Collections.sort(W3, Collections.reverseOrder());
        Collections.sort(W4, Collections.reverseOrder());

        int s1 = W1.size(), s2 = W2.size(), s3 = W3.size(), s4 = W4.size();
        a = new long[4][];
        a[0] = new long[s1 + 1];
        a[1] = new long[s2 + 1];
        a[2] = new long[s3 + 1];
        a[3] = new long[s4 + 1];

        for (int i = 1; i <= s1; i++) {
            a[0][i] = a[0][i - 1] + W1.get(i - 1);
        }
        for (int i = 1; i <= s2; i++) {
            a[1][i] = a[1][i - 1] + W2.get(i - 1);
        }
        for (int i = 1; i <= s3; i++) {
            a[2][i] = a[2][i - 1] + W3.get(i - 1);
        }
        for (int i = 1; i <= s4; i++) {
            a[3][i] = a[3][i - 1] + W4.get(i - 1);
        }

        solve(0, 0, 0);
        out.println(ans);

        out.flush();
    }

    long ans = 0;
    void solve(int i, long ws, long sum) {
        if (i == 3) {
            long cnt = Math.min(a[3].length - 1, (W - ws) / (w1 + 3));
            sum += a[3][(int)cnt];
            ans = Math.max(ans, sum);
            return;
        }

        for (int j = 0; j < a[i].length; j++) {
            if (ws + j * (w1 + i) > W) break;
            solve(i + 1, ws + j * (w1 + i), sum + a[i][j]);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}