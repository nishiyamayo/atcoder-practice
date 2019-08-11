package abc137;

import javax.print.attribute.IntegerSyntax;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        Map<String, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char[] cs = sc.next().toCharArray();
            Arrays.sort(cs);
            String hash = String.valueOf(cs);

            m.put(hash, m.getOrDefault(hash, 0) + 1);
        }
//        debug(m);
        long ans = 0;
        for (Map.Entry<String, Integer> entry: m.entrySet()) {
            ans += 1L * entry.getValue() * (entry.getValue() - 1) / 2;
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }
}
