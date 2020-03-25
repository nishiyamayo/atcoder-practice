package agc043;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.*;

public class B {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public B() {
        this(System.in, System.out);
    }

    public B(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    int N;
    int[] ar;
    String s;
    HashMap<String, Integer> map = new HashMap<>();

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        N = sc.nextInt();
        s = sc.next();
        ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = s.charAt(i) - '1';
        }

        long cnt1 = 0;
        long cnt2 = 0;
        boolean exists = false;
        for (int i = 0; i < N; i++) {
            exists |= ar[i] == 1;
            if (ar[i] == 1 && ((N - 1) & i) == i) {
                cnt1++;
            } else if (ar[i] == 2 && ((N - 1) & i) == i)  {
                cnt2++;
            }
        }

        debug(cnt1, cnt2);

        if (cnt1 % 2 == 1) {
            out.println(1);
        } else {
            if (exists) {
                out.println(0);
            } else if (cnt2 % 2 == 1) {
                out.println(2);
            } else {
                out.println(0);
            }
        }


        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new B().run();
    }
}