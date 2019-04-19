package s8pc6;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt(), w = sc.nextInt();
        boolean[][] b = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                b[i][j] = s.charAt(j) == '.';
            }
        }

        boolean ok = false;
        boolean[] ch = new boolean[w];
        ch[0] = true;
        for (int i = 0; i < h; i++) {
            boolean flg = b[i][0];
            ch[0] &= b[i][0];
            for (int j = 1; j < w; j++) {
                ch[j] = (ch[j] | ch[j - 1]) & b[i][j];
                flg &= b[i][j];
            }
            ok |= flg;
        }

        if (ok && ch[w - 1]) {
            System.out.println("Yay!");
        } else {
            System.out.println(":(");
        }
    }
}
