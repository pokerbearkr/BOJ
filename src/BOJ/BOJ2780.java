package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ2780 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception {
        int T = Integer.parseInt(br.readLine());
        int[] arr = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int maxT = Arrays.stream(arr).max().getAsInt();
        int mod = 1234567;

        int[][] dp = new int[maxT + 1][10];

        Arrays.fill(dp[1], 1);

        for (int i = 2; i <= maxT; i++) {
            dp[i][0] = dp[i - 1][7] % mod;
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][4]) % mod;
            dp[i][2] = (dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][5]) % mod;
            dp[i][3] = (dp[i - 1][2] + dp[i - 1][6]) % mod;
            dp[i][4] = (dp[i - 1][1] + dp[i - 1][5] + dp[i - 1][7]) % mod;
            dp[i][5] = (dp[i - 1][2] + dp[i - 1][4] + dp[i - 1][6] + dp[i - 1][8]) % mod;
            dp[i][6] = (dp[i - 1][3] + dp[i - 1][5] + dp[i - 1][9]) % mod;
            dp[i][7] = (dp[i - 1][4] + dp[i - 1][8] + dp[i - 1][0]) % mod;
            dp[i][8] = (dp[i - 1][5] + dp[i - 1][7] + dp[i - 1][9]) % mod;
            dp[i][9] = (dp[i - 1][6] + dp[i - 1][8]) % mod;
        }

        for (int i = 0; i < T; i++) {
            int n = arr[i];
            int result = Arrays.stream(dp[n]).sum() % mod;
            System.out.println(result);
        }
    }
}