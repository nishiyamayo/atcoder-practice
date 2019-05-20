package diverta2019;

import java.util.*;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        LinkedList<Integer> as = new LinkedList<>(), bs = new LinkedList<>();
        HashSet<Integer> ain = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = s.length() - 2; j > 0; j--) {
                if (s.charAt(j - 1) == 'A' && s.charAt(j) == 'B') ans++;
            }
            if (s.charAt(0) == 'B') {
                if (s.charAt(s.length() - 1) == 'A') bs.addFirst(i);
                else bs.addLast(i);
            }
            if (s.charAt(s.length() - 1) == 'A') {
                if (s.charAt(0) == 'B') {
                    as.addLast(i);
                } else {
                    as.addFirst(i);
                }
                ain.add(i);
            }
        }
//        debug(ans, as, bs);

        boolean[] used = new boolean[n];
        if (!as.isEmpty()) {
            int i = as.removeFirst();
            while (!bs.isEmpty()) {
                if (ain.contains(i)) {
                    // nothing
                } else {
                    used[i] = true;
                    while (!as.isEmpty() && used[i]) i = as.removeFirst();
                    if (used[i]) break;
                }
                used[i] = true;
                while (!bs.isEmpty()) {
                    int j = bs.remove();
                    if (used[j]) continue;
//                debug(i, j);
                    i = j;
                    ans++;
                    break;
                }
            }
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
