package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ14728 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Time = Integer.parseInt(st.nextToken());

        int[] dp = new int[Time+1];

        int[] studyTimes = new int[N];
        int[] studyPoints = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            studyTimes[i] = Integer.parseInt(st.nextToken());
            studyPoints[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            int curTime = studyTimes[i];
            int curPoint = studyPoints[i];
            for (int j = Time; j >= curTime; j--) {
                dp[j]=Math.max(dp[j],dp[j-curTime]+curPoint);
            }
        }

        int result=0;
        for (int i = 0; i <= Time; i++) {
            result = Math.max(result,dp[i]);
        }
        System.out.println(result);


    }
}
