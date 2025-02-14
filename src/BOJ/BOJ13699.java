package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ13699 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] dp = new long[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < i/2; j++) {
                    dp[i] += 2L * dp[j] * dp[i - 1 - j];
                }
            } else {
                for (int j = 0; j < (i-1)/2 ; j++) {
                    dp[i] += 2L * dp[j] * dp[i - 1 - j];
                }
                dp[i] += dp[i/2] * dp[i/2];
            }
        }
        System.out.println(dp[n]);
    }
}