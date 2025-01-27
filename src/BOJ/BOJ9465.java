package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] upStickers = new int[N];
            int[] downStickers = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) upStickers[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) downStickers[i] = Integer.parseInt(st.nextToken());

            if (N == 1) {
                System.out.println(Math.max(upStickers[0], downStickers[0]));
                continue;
            }

            int[][] dp = new int[N][2];
            dp[0][0] = upStickers[0];
            dp[0][1] = downStickers[0];


            dp[1][0] = dp[0][1] + upStickers[1];
            dp[1][1] = dp[0][0] + downStickers[1];

            for (int i = 2; i < N; i++) {
                dp[i][0] = Math.max(dp[i - 1][1], dp[i - 2][1]) + upStickers[i];
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 2][0]) + downStickers[i];
            }

            System.out.println(Math.max(dp[N - 1][0], dp[N - 1][1]));
        }
    }
}