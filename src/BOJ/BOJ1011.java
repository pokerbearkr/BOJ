package BOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1011 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(minMoves(start, end));
        }
    }

    private static int minMoves(int start, int end) {
        int distance = end - start;
        int maxMove = (int) Math.sqrt(distance);

        if (maxMove * maxMove == distance) {
            return 2 * maxMove - 1;
        } else if (distance <= maxMove * maxMove + maxMove) {
            return 2 * maxMove;
        } else {
            return 2 * maxMove + 1;
        }
    }
}