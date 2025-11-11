package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ9663 {
    private static int count = 0;
    private static int n;
    private static int[] queens;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queens = new int[n];

        recur(0);
        System.out.println(count);
    }

    private static void recur(int depth) {
        if (depth == n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            queens[depth] = i;
            if (isSafe(depth)) {
                recur(depth + 1);
            }
        }
    }

    private static boolean isSafe(int depth) {
        for (int i = 0; i < depth; i++) {

            if (queens[i] == queens[depth] || Math.abs(queens[i] - queens[depth]) == Math.abs(i - depth)) {
                return false;
            }
        }
        return true;
    }
}