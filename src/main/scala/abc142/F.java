package abc142;

import java.util.*;

public class F {
    int n, m;

    int size;
    Edge[] g;

    void run() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        g = new Edge[n];
        for (int i = 0; i < n; i++) g[i] = new Edge();

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
            g[a].add(b);
            size++;
        }

//        debug(g);
        solve();
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            Path p = new Path(n);
            if (dfs(i, new boolean[n], p)) {
                answer(p);
                return;
            }
        }
        System.out.println(-1);
    }

    void answer(Path p) {
//        debug(p.path());

        while (!reduce(p.path())) {
            int[] find = find(p);
            Path a = new Path(n);
            int[] path = p.path();

            a.add(find[0]);

            boolean outa = false;
            for (int i = 0; i < 2 * path.length; i++) {
                if (!outa && find[1] == path[i % path.length]) {
                    outa = true;
                }
                if (outa && find[0] == path[i % path.length]) {
                    break;
                }
                if (outa) {
                    a.add(path[i % path.length]);
                }
            }
            p = a;
//            debug(p.path());
        }
        System.out.println(p.path().length);
        for (int i : p.path()) {
            System.out.println(i + 1);
        }
    }

    int[] find(Path p) {
        int[] path = p.path();

        for (int i = 0; i < path.length - 1; i++) {
            int f = path[i], t = path[i + 1];
            for (int j : g[f]) if (j != t) {
                return new int[] {f, j};
            }
        }
        return new int[] {-1, -1};
    }

    boolean reduce(int[] path) {
        HashSet<Integer> s = new HashSet<>();
        for (int p : path) s.add(p);

        for (int i = 0; i < n; i++) {
            if (s.contains(i)) {
                Iterator<Integer> it = g[i].iterator();
                while (it.hasNext()) {
                    if (!s.contains(it.next())) {
                        it.remove();
                        size--;
                    }
                }
            } else {
                size -= g[i].size();
                g[i].clear();
            }
        }

        return s.size() == size;
    }

    boolean dfs(int cur, boolean[] visited, Path p) {

        p.add(cur);
        visited[cur] = true;

        for (int next : g[cur]) {
            if (visited[next]) {
                return true;
            }
            if (dfs(next, visited, p)) {
                return true;
            }
        }
        p.remove();
        visited[cur] = false;
        return false;
    }

    class Path {
        int[] path;
        int cursor;
        Path(int n) {
            path = new int[n];
            Arrays.fill(path, -1);
            cursor = 0;
        }

        void add(int idx) {
            path[cursor++] = idx;
        }

        void remove() {
            cursor--;
            path[cursor] = -1;
        }

        int[] path() {
            int[] cp = new int[cursor];
            System.arraycopy(path, 0, cp, 0, cursor);
            return cp;
        }
        int size() {
            return cursor;
        }
    }

    class Edge extends ArrayList<Integer> {}

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
