package zemicon;


import java.util.*;

public class D {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int c = m.getOrDefault(a, 0);
            m.put(a, c + 1);
        }
        PriorityQueue<Integer> q = new PriorityQueue<>();
        int cnt = 0;
        for (Map.Entry<Integer, Integer> e: m.entrySet()) {
            q.add(e.getValue());
            cnt++;
        }
        int ans = 0;
        for (int i = 0; i < Math.max(0, cnt - k); i++) {
            ans += q.remove();
        }
        System.out.println(ans);
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }

}
