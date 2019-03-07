package abc120;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class C {

    int a, b, c, n;
    int[] ls;
    int[] ts;

    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        LinkedList<Character> q = new LinkedList<>();
        int cnt = 0;

        for (char c: s.toCharArray()) {
            if (!q.isEmpty() && q.getLast() != c) {
                q.removeLast();
                cnt += 2;
            } else {
                q.addLast(c);
            }
        }
        System.out.println(cnt);
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
