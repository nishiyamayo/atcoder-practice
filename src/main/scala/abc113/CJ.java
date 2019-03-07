package abc113;

import java.util.*;

public class CJ {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] ps = new int[m], ys = new int[m];
        HashMap<Integer, ArrayList<V>> input = new HashMap<>();
        int[] pc = new int[n + 1];

        for (int i = 0; i < m; i++) {
            ps[i] = sc.nextInt();
            ys[i] = sc.nextInt();
            pc[ps[i]] += 1;
        }

        for (int i = 0; i < m; i++) {
            if (input.containsKey(ps[i])) {
                ArrayList<V> l = input.get(ps[i]);
                l.add(new V(i, ys[i]));
            } else {
                ArrayList<V> l = new ArrayList<>(pc[ps[i]]);
                l.add(new V(i, ys[i]));
                input.put(ps[i], l);
            }
        }

        String[] ans = new String[m];

        for (Map.Entry<Integer, ArrayList<V>> entry: input.entrySet()) {
            ArrayList<V> l = entry.getValue();
            Collections.sort(l, Comparator.comparingLong(o -> o.y));
            int i = 1;
            for (V v: l) {
                ans[v.idx] = String.format(String.format("%012d", 1L * entry.getKey() * 1000000 + i));
                i++;
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(ans[i]);
        }
    }

    class V {

        int idx;
        long y;
        V(int idx, long y) {
            this.idx = idx;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        new CJ().run();
    }
}
