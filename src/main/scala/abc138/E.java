package abc138;

import java.util.*;

public class E {

    void run() {
        Scanner sc = new Scanner(System.in);

        String s = sc.next(), t = sc.next();

        if (!exists(s, t)) {
            System.out.println(-1);
            return;
        }

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        HashMap<Character, Integer> lens = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> l = map.getOrDefault(s.charAt(i), new ArrayList<>());
            l.add(i);
            map.put(s.charAt(i), l);
            lens.put(s.charAt(i), lens.getOrDefault(s.charAt(i), 0) + 1);
        }

        int m = t.length();

        long len = 0;
        int cur = -1;

        for (int i = 0; i < m; i++) {
            char c = t.charAt(i);
            ArrayList<Integer> l = map.get(c);
            int idx = lowerBound(l, cur + 1);
            if (idx == lens.get(c)) {
                len = ((len - 1) / n + 1) * n;
                idx = lowerBound(l, 0);
                cur = l.get(idx);
                len += l.get(idx) + 1;

//                debug("1", l.get(idx), cur, len);
            } else {
                len += l.get(idx) - cur;
                cur = l.get(idx);

//                debug("2", l.get(idx), cur, len);
            }
        }
        System.out.println(len);
    }

    boolean exists(String s, String t) {
        HashSet<Character> exists = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) exists.add(s.charAt(i));

        int m = t.length();
        for (int i = 0; i < m; i++) if (!exists.contains(t.charAt(i))) {
            return false;
        }
        return true;
    }

    public int lowerBound(ArrayList<Integer> array, int value) {
        int left = -1;
        int right = array.size();
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array.get(middle) >= value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    public int upperBound(int[] array, int value) {
        int left = -1;
        int right = array.length;
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array[middle] > value) {
                right = middle;
            } else {
                left = middle;
            }
        }
        return right;
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
