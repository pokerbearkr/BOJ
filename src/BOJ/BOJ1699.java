package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ1699 {

    private static int size;
    private static int[] cache;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());
        cache = new int[size + 1];
        for (int i = 1; i * i <= size; i++) {
            cache[i * i] = 1;
        }

        for (int i = 1; i <= size; i++) {
            dp(i);
        }

        System.out.println(cache[size]);
    }

    private static int dp(int num) {
        if (cache[num] != 0) {
            return cache[num];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= num / 2; i++) {
            min = Math.min(cache[i * i] + cache[num - (i * i)], min);
        }

        return cache[num] = min;
    }
}
