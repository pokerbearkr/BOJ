package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ17845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxTime = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] studyValue = new int[K];
        int[] studyTime = new int[K];

        int[] dp = new int[maxTime + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            studyValue[i] = Integer.parseInt(st.nextToken());
            studyTime[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            int curValue = studyValue[i];
            int curTime = studyTime[i];
            for (int j = maxTime; j >= curTime ; j--) {

                dp[j]=Math.max(dp[j],dp[j-curTime]+curValue);
            }
        }

        int result=0;
        for (int i = 0; i <= maxTime; i++) {
            result = Math.max(result,dp[i]);
        }

        System.out.println(result);

    }
}
