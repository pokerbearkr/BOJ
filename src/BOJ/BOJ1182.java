package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1182 {
    private static int n, s, count;
    private static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;

        dfs(0, 0);

        System.out.println(s == 0 ? count - 1 : count);
    }

    private static void dfs(int index, int sum) {
        if (index == n) {
            if (sum == s) count++;
            return;
        }

        dfs(index + 1, sum + arr[index]);

        dfs(index + 1, sum);
    }
}