package past19;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class F {
    char[] up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    void run() {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        boolean isStart = true;
        StringBuilder sb = new StringBuilder();
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isStart && contains(s.charAt(i))) {
                isStart = false;
                sb = new StringBuilder();
                sb.append(s.charAt(i));
            } else if (!isStart && contains(s.charAt(i))) {
                isStart = true;
                sb.append(s.charAt(i));
                words.add(sb.toString().toLowerCase());
            } else {
                sb.append(s.charAt(i));
            }
        }
        Collections.sort(words);
        PrintWriter out = new PrintWriter(System.out);
        for (String w : words) {
            int l = w.length();
            out.print(w.substring(0, 1).toUpperCase() + w.substring(1, l - 1) + w.substring(l - 1).toUpperCase());
        }
        out.println();
        out.flush();
    }

    boolean contains(char c) {
        for (char alf : up) {
            if (alf == c) return true;
        }
        return false;
    }

    void debug(Object...os) {
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args) {
        new F().run();
    }

}
