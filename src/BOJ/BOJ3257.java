package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BOJ3257 {

    static String word1, word2, combined;
    static int len1, len2, lenC;
    static int[][][] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word1 = br.readLine();
        word2 = br.readLine();
        combined = br.readLine();

        len1 = word1.length();
        len2 = word2.length();
        lenC = combined.length();

        memo = new int[len1 + 1][len2 + 1][3];

        solve(0, 0, 1);
        solve(0, 0, 2);

        StringBuilder ans = new StringBuilder();
        int idx1 = 0;
        int idx2 = 0;

        int currentTurn = (memo[0][0][1] == 1) ? 1 : 2;

        while (idx1 + idx2 < lenC) {
            if (currentTurn == 1) {
                for (int i = idx1; i < len1; i++) {
                    int k = i + idx2;

                    if (k >= lenC || word1.charAt(i) != combined.charAt(k)) {
                        break;
                    }

                    if (solve(i + 1, idx2, 2) == 1) {
                        int charsTyped = (i - idx1 + 1);
                        for (int j = 0; j < charsTyped; j++) {
                            ans.append('1');
                        }

                        idx1 = i + 1;
                        currentTurn = 2;
                        break;
                    }
                }
            } else {
                for (int i = idx2; i < len2; i++) {
                    int k = idx1 + i;

                    if (k >= lenC || word2.charAt(i) != combined.charAt(k)) {
                        break;
                    }

                    if (solve(idx1, i + 1, 1) == 1) {
                        int charsTyped = (i - idx2 + 1);
                        for (int j = 0; j < charsTyped; j++) {
                            ans.append('2');
                        }

                        idx2 = i + 1;
                        currentTurn = 1;
                        break;
                    }
                }
            }
        }

        System.out.println(ans.toString());
    }

    static int solve(int idx1, int idx2, int turn) {
        int k = idx1 + idx2;

        if (k == lenC) {
            return (idx1 == len1 && idx2 == len2) ? 1 : 2;
        }

        if (memo[idx1][idx2][turn] != 0) {
            return memo[idx1][idx2][turn];
        }

        int result = 2;

        if (turn == 1) {
            for (int i = idx1; i < len1; i++) {
                int k_prime = i + idx2;

                if (k_prime >= lenC || word1.charAt(i) != combined.charAt(k_prime)) {
                    break;
                }

                if (solve(i + 1, idx2, 2) == 1) {
                    result = 1;
                    break;
                }
            }
        } else {
            for (int i = idx2; i < len2; i++) {
                int k_prime = idx1 + i;

                if (k_prime >= lenC || word2.charAt(i) != combined.charAt(k_prime)) {
                    break;
                }

                if (solve(idx1, i + 1, 1) == 1) {
                    result = 1;
                    break;
                }
            }
        }

        return memo[idx1][idx2][turn] = result;
    }
}