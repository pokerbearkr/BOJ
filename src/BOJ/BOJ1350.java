package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1350 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(bf.readLine());
        long ans = 0;
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cluster = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                ans += ((arr[i] + cluster - 1) / cluster) * cluster;
            }
        }

        System.out.println(ans);
    }
}