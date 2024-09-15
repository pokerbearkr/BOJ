package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ17626 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        for (int i = 2; i < N+1; i++) {
            for (int j = 1; j*j <=i ; j++) {
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
                
            }

        }
        System.out.println(dp[N]);
    }
}
