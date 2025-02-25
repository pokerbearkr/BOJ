package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ11057 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int MOD = 10007;

        int[][] dp = new int[N][10];

        for (int j = 0; j < 10; j++) {
            dp[0][j] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j > 0) {
                    dp[i][j] += dp[i][j - 1];
                }
                dp[i][j] %= MOD;
            }
        }

        int result = 0;
        for (int j = 0; j < 10; j++) {
            result += dp[N - 1][j];
            result %= MOD;
        }

        System.out.println(result);
    }
}