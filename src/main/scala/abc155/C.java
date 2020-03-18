package abc155;

import java.util.*;

public class C {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        ArrayList<String> o = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (ans == entry.getValue()) {
                o.add(entry.getKey());
            }
        }
        Collections.sort(o);

        for (String s: o) {
            System.out.println(s);
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new C().run();
    }

}
