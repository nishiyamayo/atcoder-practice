package abc155;

import java.util.*;

public class D {

    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        ArrayList<P> vs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            vs.add(new P(sc.nextLong()));
        }

        Collections.sort(vs);
        ArrayList<Long> posi = new ArrayList<>();
        ArrayList<Long> nega = new ArrayList<>();

        int idx = 1;
        for (P cur : vs) {
            cur.absIdx = idx++;
            if (cur.isPosi) {
                posi.add(cur.x);
            } else {
                nega.add(cur.x);
            }
        }

        debug(vs);
        debug(posi);
        debug(nega);

        long pl = posi.size(), nl = nega.size();
        if (k <= pl * nl) {
            long cnt = 0;
            for (int pi = 0; pi < pl - 1; pi++) {
                int x = lowerBound(nega, -1 * posi.get(pi + 1));
            }

        } else {

        }
    }

    class P implements Comparable<P> {
        long x;
        boolean isPosi;
        int absIdx;
        P(long x) {
            this.x = x;
            isPosi = x >= 0;
            absIdx = -1;
        }

        @Override
        public int compareTo(P o) {
            return Long.compare(Math.abs(x), Math.abs(o.x));
        }

        @Override
        public String toString() {
            return "(x: " + x + ", idx: " + absIdx + ", posi: " + isPosi + ")";
        }
    }

    public  int lowerBound(ArrayList<Long> array, long value) {
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

    public  int upperBound(ArrayList<Long> array, long value) {
        int left = -1;
        int right = array.size();
        while (right - left > 1) {
            int middle = (right + left) / 2;
            if (array.get(middle) > value) {
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
        new D().run();
    }

}
