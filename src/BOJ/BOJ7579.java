package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        int[] costs = new int[N];

        int totalCost = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
            totalCost += costs[i];
        }

        int[] dp = new int[totalCost + 1];
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int curMemory = memory[i];
            int curCost = costs[i];
            for (int j = totalCost; j >= curCost; j--) {
                dp[j] = Math.max(dp[j], dp[j - curCost] + curMemory);
                if (dp[j] >= M) {
                    result = Math.min(result, j);
                }
            }
        }

        System.out.println(result);
    }
}