package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2166 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] numX = new int[n];
        int[] numY = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            numX[i] = Integer.parseInt(st.nextToken());
            numY[i] = Integer.parseInt(st.nextToken());
        }

        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;
            sum1 += (double) numX[i] * numY[next];
            sum2 += (double) numY[i] * numX[next];
        }

        double result = Math.abs(sum1 - sum2) / 2.0;

        System.out.printf("%.1f\n", result);
    }
}