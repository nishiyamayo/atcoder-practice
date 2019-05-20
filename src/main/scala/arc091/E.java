package arc091;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();

        PrintWriter out = new PrintWriter(System.out);

        LinkedList<Long> ans = make(n, a, b);

        Iterator<Long> it = a < b ? ans.descendingIterator() : ans.iterator();

        it.hasNext();
        out.print(it.next());

        while (it.hasNext()) {
            out.print(" " + it.next());
        }

        out.println();
        out.flush();
    }

    LinkedList<Long> make(long n, long a, long b) {

        if (a < b) return make(n, b, a);
        LinkedList<Long> ans = new LinkedList<>();


        if (a * b >= n && n >= a + b - 1) {
            for (long i = 1; i <= b; i++) {
                for (long j = Math.min(a, n - b + i) - 1; j >= 0; j--)
                    ans.addLast(n - j);
                n -= Math.min(a, n + i - b);
//                debug(n, i, ans);
            }
        } else {
            ans.add(-1L);
        }

        return ans;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }
}
