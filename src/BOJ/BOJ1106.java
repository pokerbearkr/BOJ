package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1106 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());

        int[] dp = new int[target + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int[] cost = new int[city];
        int[] customer = new int[city];

        for (int i = 0; i < city; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            customer[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < city; i++) {
            int chosenCost = cost[i];
            int chosenCustomer = customer[i];
            for (int j = chosenCustomer; j <= target + 99; j++) {
                if (dp[j - chosenCustomer] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - chosenCustomer] + chosenCost);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = target; i < target + 100; i++) {
            result = Math.min(result, dp[i]);
        }

        System.out.println(result);
    }
}