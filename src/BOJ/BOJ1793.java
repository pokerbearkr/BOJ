package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ1793 {
    private static BigInteger[] dp = new BigInteger[251];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;

        for (int i = 2; i <= 250; i++) {
            dp[i] = dp[i - 1].add(dp[i - 2].multiply(BigInteger.TWO));
        }

        String input;
        StringBuilder sb = new StringBuilder();
        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int n = Integer.parseInt(input.trim());
            sb.append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}