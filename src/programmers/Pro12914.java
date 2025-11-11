package programmers;

public class Pro12914 {
    public static void main(String[] args) {
        int n = 5;

        if (n <= 3) {
            System.out.println(n);
            return;
        }
        long[] dp = new long[n+1];

        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        for (int i = 4; i <= n ; i++) {
            dp[i]=(dp[i-1]+dp[i-2])%1234567;
        }

        System.out.println(dp[n]);
    }
}
