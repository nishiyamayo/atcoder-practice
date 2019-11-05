package zemicon;


import java.util.*;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        int s = x;
        int f = 0;
        while (s != 0) {
            f += s % 10;
            s /= 10;
        }

        System.out.println(x % f == 0 ? "Yes" : "No");

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }

}
