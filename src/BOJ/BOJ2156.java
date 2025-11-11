package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2156 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] grapes = new int[n];
        for (int i = 0; i < n; i++) {
            grapes[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[0] = grapes[0];
        if (n == 1) {
            System.out.println(dp[0]);
            return;
        }
        dp[1] = dp[0] + grapes[1];
        if (n == 2) {
            System.out.println(dp[1]);
            return;
        }
        dp[2] = Math.max(dp[1], Math.max(dp[0] + grapes[2], grapes[1] + grapes[2]));
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapes[i], dp[i - 3] + grapes[i] + grapes[i - 1]));
        }
        System.out.println(dp[n - 1]);

    }
}
