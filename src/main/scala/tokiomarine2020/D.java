package tokiomarine2020;

import java.io.*;

import java.util.*;

public class D {
    long MOD = (long) 1e9 + 7;

    InputStream in;
    OutputStream out;

    public D() {
        this(System.in, System.out);
    }

    public D(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
    }
    int n;
    int[] V, W;

    void run() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        n = Integer.parseInt(br.readLine());
        V = new int[n];
        W = new int[n];
        for (int i = 0; i < n; i++) {
            String[] sp = br.readLine().split(" ");
            V[i] = Integer.parseInt(sp[0]);
            W[i] = Integer.parseInt(sp[1]);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String[] sp = br.readLine().split(" ");
            int v = Integer.parseInt(sp[0]), l = Integer.parseInt(sp[1]);
            ArrayList<Integer> nodes = new ArrayList<>();
            while (v > 0) {
                nodes.add(v - 1);
                v /= 2;
            }
            out.println(solve(nodes, l));
        }


        out.flush();
    }

    long solve(ArrayList<Integer> nodes, int l) {

        int size = nodes.size();

        ArrayList<Integer> left = new ArrayList<>(), right = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (i < size / 2) {
                left.add(nodes.get(i));
            } else {
                right.add(nodes.get(i));
            }
        }

        long[][] lp = enumerate(left, size / 2, l);
        long[][] rp = enumerate(right, size - size / 2, l);
        debug(lp, rp);
        int lsize = lp[0].length;
        int rsize = rp[0].length;

        long max = 0;
        for (int i = 0; i < lsize; i++) {
            if (l - lp[0][i] < 0) continue;
            int idx = upperBound(rp[0], l - lp[0][i]);
            if (idx == rsize) idx--;
//            debug(p, l, idx, rp.get(idx));
            max = Math.max(max, lp[1][i] + rp[1][idx]);
        }

        return max;
    }

    void dfs(int idx, int size, long vs, long ws, int l, ArrayList<Integer> nodes, Map<Long, Long> ret) {
        if (idx == size) {
            long cv = ret.getOrDefault(ws, 0L);
            ret.put(ws, Math.max(vs, cv));
            return;
        }
        dfs(idx + 1, size, vs, ws, l, nodes, ret);
        if (ws + W[nodes.get(idx)] <= l)
            dfs(idx + 1, size, vs + V[nodes.get(idx)], ws + W[nodes.get(idx)], l, nodes, ret);
    }

    long[][]  enumerate(ArrayList<Integer> nodes, int size, int L) {
        TreeMap<Long, Long> map = new TreeMap<>();
        dfs(0, size, 0, 0, L, nodes, map);

        long cv = 0;
        long[][] ret = new long[2][map.size()];
        int idx = 0;
        for (Map.Entry<Long, Long> entry : map.entrySet()) {
            cv = Math.max(cv, entry.getValue());
            ret[0][idx] = entry.getKey();
            ret[1][idx] = cv;
            idx++;
        }
        return ret;
    }

    public int upperBound(long[] array, long value) {
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
        return left;
    }

    class Pair implements Comparable<Pair> {
        long vs, ws;
        Pair(long vs, long ws) {
            this.vs = vs;
            this.ws = ws;
        }

        @Override
        public int compareTo(Pair o) {
            return Long.compare(ws, o.ws);
        }

        @Override
        public String toString() {
            return "(" + vs +", " + ws + ")";
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        try {
            new D().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}