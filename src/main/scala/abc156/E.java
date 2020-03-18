package abc156;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class E {
    void run() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        HashSet<Node> visited1 = new HashSet<>();
        HashSet<Node> visited2 = new HashSet<>();
        int[] ar = new int[n];
        Arrays.fill(ar, 1);
        visited1.add(new Node(ar, n));

        for (int i = 0; i < k; i++) {
            for (Node node : visited1) {
                for (int j = 0; j < n; j++) if (node.ar[j] > 0) {
                    for (int h = 0; h < n; h++) if (h != j) {
                        Node next = new Node(node.ar, n);
                        next.ar[j] --;
                        next.ar[h] ++;
                        visited2.add(next);
                    }
                }
            }
            visited1.clear();
            visited1.addAll(visited2);
            visited2.clear();
            print(visited1, k);
        }

        System.out.println(visited1.size());
    }

    void print(HashSet<Node> nodes, int k) {
        debug("try", k);
        for (Node node : nodes) {
            debug(node.ar);
        }
    }


    class Node {
        int[] ar;
        int n;
        Node(int[] ar, int n) {
            this.ar = new int[n];
            this.n = n;
            System.arraycopy(ar, 0, this.ar, 0, n);
        }

        @Override
        public int hashCode() {
            int ret = 0;
            int mult = 1;
            for (int i = 0; i < n; i++) {
                ret += mult * ar[i];
                mult *= 10;
            }
            return ret;
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Node) {
                Node node = (Node) o;
                for (int i = 0; i < n; i++) {
                    if (ar[i] != node.ar[i]) return false;
                }
                return true;
            }
            return false;
        }
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new E().run();
    }

}
// 3,   6  10
// 4,  12  31   35
// 5,  20  81  121  126
// 6,  30 181  381  456  462
// 7,  42 358 1058 1583 1709 1716