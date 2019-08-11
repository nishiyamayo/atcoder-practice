package abc137;

import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        Map<Integer, ArrayList<Long>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            long b = sc.nextInt();
            ArrayList<Long> q = map.getOrDefault(a, new ArrayList<>());
            q.add(-b);
            map.put(a, q);
        }

        long cnt = 0;
        PriorityQueue<Long> q = new PriorityQueue<>();
        for (int i = m; i >= 0; i--) {
            if (map.containsKey(m - i)) {
                q.addAll(map.get(m - i));
            }
            if (!q.isEmpty()) {
                cnt += q.remove();
            }
        }

        System.out.println(-cnt);

    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
