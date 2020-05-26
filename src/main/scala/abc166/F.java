package abc166;

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
        Integer n = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt(), C = sc.nextInt();
        ArrayList<String> ss = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            ss.add(s);
        }

        V v1 = new V(A, "A");
        V v2 = new V(B, "B");
        V v3 = new V(C, "C");

        boolean ok = true;
        ArrayList<String> ans = new ArrayList<>();
        n = ss.size();
        for (int i = 0; i < n - 1; i++) {
            switch (ss.get(i)) {
                case "AB":
                    if (ss.get(i + 1).contains("A")) {
                        ok &= update(v2, v1, ans);
                    } else {
                        ok &= update(v1, v2, ans);
                    }
                    break;
                case "AC":
                    if (ss.get(i + 1).contains("A")) {
                        ok &= update(v3, v1, ans);
                    } else {
                        ok &= update(v1, v3, ans);
                    }
                    break;
                case "BC":
                    if (ss.get(i + 1).contains("B")) {
                        ok &= update(v3, v2, ans);
                    } else {
                        ok &= update(v2, v3, ans);
                    }
                    break;
            }
            if (!ok) {
                break;
            }
        }

        switch (ss.get(n - 1)) {
            case "AB":
                ok &= update(v1, v2, ans);
                break;
            case "AC":
                ok &= update(v1, v3, ans);
                break;
            case "BC":
                ok &= update(v2, v3, ans);
                break;
        }

        if (ok) {
            out.println("Yes");
            for (String s : ans) {
                out.println(s);
            }
        } else {
            out.println("No");
        }

        out.flush();
    }

    boolean update(V X, V Y, ArrayList<String> ans) {
        if (X.X == 0 && Y.X == 0) {
            return false;
        } else if (X.X == 0) {
            ans.add(X.s);
            X.X++;
            Y.X--;
        } else if (Y.X == 0) {
            ans.add(Y.s);
            X.X--;
            Y.X++;
        } else {
            ans.add(Y.s);
            Y.X++;
            X.X--;
        }
        return true;
    }

    class V {
        int X;
        String s;

        V(int X, String s) {
            this.X = X;
            this.s = s;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }
}
