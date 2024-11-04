package SW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1859 {
    static BufferedReader bf;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 1; i < T + 1; i++) {
            System.out.print("#" + i + " ");
            System.out.println(test());

        }
    }

    public static long test() throws IOException{
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long ans=0;
        int max = arr[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (max > arr[i]) {
                ans += max - arr[i];
            } else {
                max = arr[i];
            }
        }
        return ans;
    }
}
