package abc090;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

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

    void run() {
        Scanner sc = new Scanner(this.in);
        PrintWriter out = new PrintWriter(this.out);

        // write your code
        int n = sc.nextInt(), k = sc.nextInt();

        long cnt = 0;
        // ナイーブな実装
//        for (int b = 1; b <= n; b++) {
//            for (int a = 1; a <= n; a++) {
//                if (a % b >= k) cnt++;
//            }
//        }

        // リファクタリング1 式変形
//        for (int b = k + 1; b <= n; b++) {
//            for (int a = k; a < b; a++) {
//                int multNum = n / b;
//                // これだけではダメ
//                cnt += multNum;
//                // 1回大きいものを追加で数えあげる
//                if (multNum * b + a <= n) cnt++;
//            }
//        }

        // リファクタリング2 ループ変数に関係のない値を抜き出す & ループのif文をループ2つに分割
//        for (int b = k + 1; b <= n; b++) {
//            int multNum = n / b;
//            debug(n - multNum * b, b);
//            for (int a = k; a <= n - multNum * b; a++) {
//                cnt += multNum + 1;
//            }
//            for (int a = Math.max(k, n - multNum * b + 1); a < b; a++) {
//                cnt += multNum;
//            }
//        }

        // 完成系
//        for (int b = k + 1; b <= n; b++) {
//            long multNum = n / b;
//            cnt += (multNum + 1) * Math.max(0, n - multNum * b - k + 1);
//            cnt += multNum * (b - Math.max(k, n - multNum * b + 1));
//        }

        // さらに綺麗に
        for (int b = k + 1; b <= n; b++) {
            long multNum = n / b;
            long th = Math.max(0, n - multNum * b - k + 1);
            cnt += (multNum + 1) * th;
            cnt += multNum * (b - k - th);
        }

        // リファクタリング1 式変形
        if (k == 0) cnt -= n;

        out.println(cnt);

        out.flush();
    }

    void debug(Object... os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new D().run();
    }
}