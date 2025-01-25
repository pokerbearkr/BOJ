package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ2670 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double max = arr[0];
        double currentMax = arr[0];

        for (int i = 1; i < n; i++) {
            currentMax = Math.max(arr[i], currentMax * arr[i]);
            max = Math.max(max, currentMax);
        }

        System.out.printf("%.3f\n", max);
    }
}