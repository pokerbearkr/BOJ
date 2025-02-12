package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ10844 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        final int div = 1000000000;
        int[][] dp = new int[n+1][10];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        dp[1][3] = 1;
        dp[1][4] = 1;
        dp[1][5] = 1;
        dp[1][6] = 1;
        dp[1][7] = 1;
        dp[1][8] = 1;
        dp[1][9] = 1;
        if (n == 1) {
            System.out.println(9);
            return;
        }
        for (int i = 2; i <= n; i++) {
            dp[i][0]=dp[i-1][1]%div;
            dp[i][1]=(dp[i-1][2]+dp[i-1][0])%div;
            dp[i][2]=(dp[i-1][1]+dp[i-1][3])%div;
            dp[i][3]=(dp[i-1][2]+dp[i-1][4])%div;
            dp[i][4]=(dp[i-1][3]+dp[i-1][5])%div;
            dp[i][5]=(dp[i-1][4]+dp[i-1][6])%div;
            dp[i][6]=(dp[i-1][5]+dp[i-1][7])%div;
            dp[i][7]=(dp[i-1][6]+dp[i-1][8])%div;
            dp[i][8]=(dp[i-1][7]+dp[i-1][9])%div;
            dp[i][9]=dp[i-1][8]%div;
        }
        int ans=0;
        for (int i = 1; i < 10; i++) {
            ans = (ans +dp[n][i])%div;
        }
        System.out.println(ans);
        
    }
}
