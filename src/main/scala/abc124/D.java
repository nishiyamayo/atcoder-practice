package abc124;

import java.util.*;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), k = sc.nextInt();
        String s = sc.next();

        ArrayList<V> ar = new ArrayList<>();
        int c = s.charAt(0) - '0', len = 1;
        for (int i = 1; i < n; i++) {
            if (c == s.charAt(i) - '0') {
                len++;
            } else {
                ar.add(new V(c, len));
                c = s.charAt(i) - '0';
                len = 1;
            }
        }
        ar.add(new V(c, len));

        int ans = 0;
        int sum = 0;
        for (int l = 0, r = 0; r < ar.size(); r++) {
            if (ar.get(r).c == 0) {
                if (k > 0) {
                    k--;
                } else {
                    if (ar.get(l).c == 0) {
                        sum -= ar.get(l).len;
                        l++;
                    } else {
                        sum -= ar.get(l).len;
                        sum -= ar.get(l + 1).len;
                        l += 2;
                    }
                }
            }
            sum += ar.get(r).len;
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

    class V {
        int c, len;
        V(int c, int len) {
            this.c = c;
            this.len = len;
        }

        @Override
        public String toString() {
            return String.format(String.format("(%d, %d)", c, len));
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}
