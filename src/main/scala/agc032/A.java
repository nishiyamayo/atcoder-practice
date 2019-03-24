package agc032;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class A {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> a = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        LinkedList<Integer> ans = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            debug(i);
            for (int j = n - i; j > 0; j--) if (a.get(j - 1) == j) {
                ans.addFirst(a.remove(j - 1));
                break;
            }
        }
        if (a.size() == 0) {
            for (int x: ans) {
                System.out.println(x);
            }
        } else {
          System.out.println(-1);
        }
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new A().run();
    }
}
