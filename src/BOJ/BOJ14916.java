package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ14916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int INF = 100000;
        int[] dp = new int[Math.max(6, n + 1)];

        Arrays.fill(dp, INF);
        dp[0] = 0;
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;

        for (int i = 6; i <= n; i++) {
            if (dp[i - 2] != INF) dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            if (dp[i - 5] != INF) dp[i] = Math.min(dp[i], dp[i - 5] + 1);
        }

        if(dp[n] == INF) System.out.println(-1);
        else System.out.println(dp[n]);
    }
}