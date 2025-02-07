package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1072 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long X = Long.parseLong(st.nextToken());
        long Y = Long.parseLong(st.nextToken());
        long presentWinRate = Y * 100 / X;

        if (presentWinRate >= 99) {
            System.out.println(-1);
            return;
        }

        long result = (X * presentWinRate + 1 - 100 * Y) / (99 - presentWinRate);
        System.out.println(result);
    }
}